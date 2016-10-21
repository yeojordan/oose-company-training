package controller;

import java.util.*;

import model.*;
import view.*;

import controller.observer.*;
import controller.plans.*;
import controller.events.*;
import controller.*;

public class SimulatorController
{
    // private Company primaryCompany;
    private PropertyController propertyController;
    //private Map<String, Property> propertyMap;
    // private List<Event> eventList;
    private EventController eventController;
    //private List<Plan> planList;
    private PlanController planController;
    private SimulatorView view;

    //private Map<String, WageObserver> wageObservers;
    // private List<Event> eventList;


    public SimulatorController()
    {
        // this.primaryCompany = null;
        //this.propertyMap    = new HashMap<String, Property>();
        this.propertyController = null;
        //this.eventList      = new LinkedList<Event>();
        this.eventController = null;
        //this.planList       = new LinkedList<Plan>();
        this.planController = null;
        this.view           = new SimulatorView();
        //this.wageObservers  = new HashMap<String, WageObserver>();
        // Add all wage observers
        //addAllObservers();

    }

    public void setPropertyController(PropertyController propertyController)
    {
        this.propertyController = propertyController;
    }

    public void setPlanController(PlanController planController)
    {
        this.planController = planController;
    }

    public void setEventController(EventController eventController)
    {
        this.eventController = eventController;
    }

    public void runSimulation(int start, int end)
    {


        //addAllObservers();

    //    updatePlans(plans);

        if( start > end )
        {
            throw new IllegalArgumentException("Start year cannot be earlier than end year");
        }


        int eventYear;

        for (int currYear = start; currYear <= end; currYear++)
        {

            System.out.println("\n\n\n\n");
            System.out.println("YEAR: " + currYear);

            view.displayProperties(propertyController.getProperties());

            eventController.handleEvent(currYear, this.propertyController);
            
            planController.handlePlan(currYear, this.propertyController);

            propertyController.updateProfit();


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
    // public void printProperties()
    // {
    //     view.displayProperties(propertyController.getProperties());
    // }

    public void printBusinessUnits()
    {
        view.displayBusinessUnits(this.propertyController.getProperties());
    }

    public void printEvents()
    {
        view.displayEvents(this.eventController.getEvents());
    }

    public void printPlans()
    {
        view.displayPlans(this.planController.getPlans());
    }

    // Add all observers to the map
/*    public void addAllObservers()
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
*/


    // public void addObserver(WageObserver property)
    // {
    //     String name = null;
    //     BusinessUnit prop = (BusinessUnit)(property);
    //     name = prop.getName();
    //
    //     wageObservers.put( name, (WageObserver)property);
    // }
    //
    // public void removeObserver(String key)
    // {
    //     wageObservers.remove(key);
    // }

    // // Insert a property the map
    // public void addProperty(Property property)
    // {
    //     String key;
    //     key = property.getName();
    //
    //     // If the company to insert is the first (primary)
    //     if ( (property instanceof Company) && (primaryCompany == null) )
    //     {
    //         primaryCompany = (Company)property;
    //     }
    //
    //     this.propertyMap.put(key, property);
    //
    // }

    // public void addPlan(Plan plan)
    // {
    //     this.planList.add(plan);
    // }

    // public void addEvent(Event event)
    // {
    //     this.eventList.add(event);
    // }

    // public Map<String, Property> getProperties()
    // {
    //     return this.propertyMap;
    // }


}
