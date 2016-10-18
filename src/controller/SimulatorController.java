package controller;

import java.util.*;

import model.*;
import view.*;

import controller.observer.*;
import controller.plans.*;
import controller.events.*;

public class SimulatorController
{
    private Company primaryCompany;
    private Map<String, Property> propertyMap;
    private List<Event> eventList;
    private List<Plan> planList;

    private SimulatorView view;

    private Map<String, WageObserver> wageObservers;
    // private List<Event> eventList;


    public SimulatorController()
    {
        this.primaryCompany = null;
        this.propertyMap    = new HashMap<String, Property>();
        this.eventList      = new LinkedList<Event>();
        this.planList       = new LinkedList<Plan>();
        this.view           = new SimulatorView();
        this.wageObservers  = new HashMap<String, WageObserver>();
        // Add all wage observers
        //addAllObservers();

    }

    public void runSimulation(int start, int end)
    {



        char ev;
        char inc;
        boolean increase = false;
        HashMap<Character, PlanAction> plans = new HashMap<Character, PlanAction>();


        addAllObservers();

    //    updatePlans(plans);


        if( start > end )
        {
            throw new IllegalArgumentException("Start year cannot be earlier than end year");
        }

        Iterator<Event> it = eventList.iterator();
        Iterator<Plan> planIt = planList.iterator();


        Plan plan = null;

        Event event = null;
        int eventYear;
        event = it.next();
        eventYear = event.getYear();

        int planYear;
        plan = planIt.next();
        planYear = plan.getYear();
        // Loop for the intended number of years.
        for (int i = start; i <= end; i++)
        {

            System.out.println("\n\n\n\n");
            System.out.println("YEAR: " + i);

            printProperties();

            // While event still in the current year
            while (eventYear == i)
            {

                event.performEvent(this.propertyMap);
                    // // Obtain relevant Action from map
                    // ev = event.getEvent().charAt(0);
                    // inc = event.getEvent().charAt(1);
                    // //System.out.println("Year: " + i + "Action" + ev + inc);
                    //
                    // increase = false;
                    // if ( inc == '+')
                    // {
                    //     increase = true;
                    // }
                    //
                    // if ( ev == 'W')
                    // {
                    //     for (WageObserver wo : wageObservers.values())
                    //     {
                    //         wo.updateWages(increase);
                    //     }
                    // }
                    // else if (ev == 'R')
                    // {
                    //     String name = event.getProperty();
                    //     WageObserver wg = wageObservers.get(name);
                    //     if (wg != null)
                    //         ((BusinessUnit)(wg)).updateRevenue(increase);
                    // }
                    // else if (ev == 'V')
                    // {
                    //     String name = event.getProperty();
                    //     Property prop = propertyMap.get(name);
                    //     if (prop != null)
                    //         prop.updateValue(increase);
                    // }


                if (it.hasNext())
                {
                    event = it.next();
                    eventYear = event.getYear();
                }
                else
                {
                    eventYear = i +1;
                }
            }//End event while


            // Plan File
            while (planYear == i)
            {

            //     char pl = plan.getDecision();
            //     PlanAction plAct = plans.get(Character.valueOf('S'));;
            // //    System.out.println(plan.toString());
            //
            //     if( pl == 'B')
            //     {
            //         plAct = plans.get(Character.valueOf('B'));
            //     }
            //     else if (pl == 'S')
            //     {
            //         plAct = plans.get(Character.valueOf('S'));
            //     }
            //

                plan.performPlan(this.propertyMap, this.primaryCompany);


                if (planIt.hasNext())
                {
                    plan = planIt.next();
                    planYear = plan.getYear();
                }
                else
                {
                    planYear = i +1;
                }


            }//End plan while


            // Calculate interest for each company for previous year's bank balance
            for ( Property comp : propertyMap.values())
            {
                if (comp instanceof Company )
                {
                    // If company has no owner or sold to unnamed buyer
                    if ( (comp.getOwner().equals("")) || (comp.getOwner().equals("Unnamed Buyer")) )
                    {
                        //System.out.println("Company to Calculate Profit On: " + comp.getName() + "\nOwner: " + comp.getOwner() + "\n\n\n");
                        // Updates profit
                        ((Company)(comp)).calculateProfit();

                    }
                }
            }

        }//End for
    }

    // public void updatePlans(Map<Character, PlanAction> plans )
    // {
    //     plans.put(Character.valueOf('B'), new Buy(this.propertyMap));
    //     plans.put(Character.valueOf('S'), new Sell(this.propertyMap));
    // }

/*
    public void updateActions(Map<Character, Action> actions )
    {
        actions.put(Character.valueOf('W'), new Wages(propertyMap));
    //         actions.put(Character.valueOf('R'), );
    //         actions.put(Character.valueOf('V'), );
    }

*/
    public void printProperties()
    {
        view.displayProperties(propertyMap);
    }

    public void printBusinessUnits()
    {
        view.displayBusinessUnits(propertyMap);
    }

    public void printEvents()
    {
        view.displayEvents(eventList);
    }

    public void printPlans()
    {
        view.displayPlans(planList);
    }

    // Add all observers to the map
    public void addAllObservers()
    {
        try
        {

            for ( Property prop : propertyMap.values() )
            {
                if (prop == null)
                {

                }
                //System.out.println(prop.toString());
                if (prop instanceof WageObserver)
                {
                    addObserver((WageObserver)(prop) );
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }



    }

    public void addObserver(WageObserver property)
    {
        String name = null;
        BusinessUnit prop = (BusinessUnit)(property);
        name = prop.getName();

        wageObservers.put( name, (WageObserver)property);
    }

    public void removeObserver(String key)
    {
        wageObservers.remove(key);
    }

    // Insert a property the map
    public void addProperty(Property property)
    {
        String key;
        key = property.getName();

        // If the company to insert is the first (primary)
        if ( (property instanceof Company) && (primaryCompany == null) )
        {
            System.out.println("PRIMARY COMPANY ADDED");
            primaryCompany = (Company)property;
        }

        this.propertyMap.put(key, property);

    }

    public void addPlan(Plan plan)
    {
        this.planList.add(plan);
    }

    public void addEvent(Event event)
    {
        this.eventList.add(event);
    }

    public Map<String, Property> getProperties()
    {
        return this.propertyMap;
    }


}
