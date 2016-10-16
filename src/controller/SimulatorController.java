package controller;

import java.util.*;

import model.*;
import view.*;
import controller.actions.*;
import controller.observer.*;
import controller.plans.*;

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


        Action currAction;
        char ev;
        char inc;
        boolean increase = false;
        HashMap<Character, PlanAction> plans = new HashMap<Character, PlanAction>();


        addAllObservers();

        updatePlans(plans);


        if( start > end )
        {
            throw new IllegalArgumentException("Start year cannot be earlier than end year");
        }

        Iterator<Event> it = eventList.iterator();
        Iterator<Plan> planIt = planList.iterator();


        Plan plan = planIt.next();

        Event event = it.next();

        // Loop for the intended number of years.
        for (int i = start; i <= end; i++)
        {   System.out.println("\n\n\n\n");
            System.out.println("YEAR: " + i);
            // Calculate interest for each company for previous year's bank balance
            for ( Property comp : propertyMap.values())
            {
                if (comp instanceof Company)
                {
                    //((Company)(comp)).calculateInterest();
                    ((Company)(comp)).calculateProfit();
                    //System.out.println("\n\nBalance after interest: " ((Company)(comp)).getMonetaryValue() + "\n\n");
                }
            }

            //System.out.println("\n\n\n\n");



            printProperties();


            // While event still in the current year
            while (it.hasNext() && event.getYear() == i)
            {

                // Obtain relevant Action from map
                ev = event.getEvent().charAt(0);
                inc = event.getEvent().charAt(1);
                //System.out.println("Year: " + i + "Action" + ev + inc);

                increase = false;
                if ( inc == '+')
                {
                    increase = true;
                }

                if ( ev == 'W')
                {
                    for (WageObserver wo : wageObservers.values())
                    {
                        wo.updateWages(increase);
                    }
                }
                else if (ev == 'R')
                {
                    String name = event.getProperty();
                    WageObserver wg = wageObservers.get(name);
                    if (wg != null)
                        ((BusinessUnit)(wg)).updateRevenue(increase);
                }
                else if (ev == 'V')
                {
                    String name = event.getProperty();
                    Property prop = propertyMap.get(name);
                    if (prop != null)
                        prop.updateValue(increase);
                }

                event = it.next();
            }


            // Plan File
            while (planIt.hasNext() && plan.getYear() == i)
            {

                char pl = plan.getDecision();
                PlanAction plAct = plans.get(Character.valueOf('S'));;
            //    System.out.println(plan.toString());

                if( pl == 'B')
                {
                    plAct = plans.get(Character.valueOf('B'));
                }
                else if (pl == 'S')
                {
                    plAct = plans.get(Character.valueOf('S'));
                }


                plAct.performPlan(plan, this.primaryCompany);

                plan = planIt.next();
            }

        }
    }

    public void updatePlans(Map<Character, PlanAction> plans )
    {
        plans.put(Character.valueOf('B'), new Buy(this.propertyMap));
        plans.put(Character.valueOf('S'), new Sell(this.propertyMap));
    }

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
                System.out.println(prop.toString());
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
