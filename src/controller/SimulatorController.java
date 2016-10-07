package controller;

import java.util.*;

import model.*;
import view.*;
import controller.actions.*;
import controller.observer.*;

public class SimulatorController
{

    private Map<String, Property> propertyMap;
    private List<Event> eventList;
    private List<Plan> planList;

    private SimulatorView view;

    private Map<String, WageObserver> wageObservers;
    // private List<Event> eventList;


    public SimulatorController(Map<String, Property> properties, List<Event> events, List<Plan> plans)
    {
        this.propertyMap = properties;
        this.eventList = events;
        this.planList = plans;
        view = new SimulatorView();
        wageObservers = new HashMap<String, WageObserver>();
        // Add all wage observers
        addAllObservers();

    }

    public void runSimulation(int start, int end)
    {


        Action currAction;
    //    Map<Character, Action> actions = new HashMap<Character, Action>();
        char ev;
        char inc;
        boolean increase = false;

        if( start > end )
        {
            throw new IllegalArgumentException("Start year cannot be earlier than end year");
        }

        Iterator<Event> it = eventList.iterator();

        Event event = it.next();

        // Loop for the intended number of years.
        for (int i = start; i <= end; i++)
        {
            // While event still in the current year
            while (it.hasNext() && event.getYear() == i)
            {

                // Obtain relevant Action from map
                ev = event.getEvent().charAt(0);
                inc = event.getEvent().charAt(1);
                System.out.println("Year: " + i + "Action" + ev + inc);

                if ( ev == 'W')
                {
                    increase = false;
                    if ( inc == '+')
                    {
                        increase = true;
                    }

                    for (WageObserver wo : wageObservers.values())
                    {
                        wo.updateWages(increase);
                    }
                }

                event = it.next();

            }

        }
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
        for ( Property prop : propertyMap.values() )
        {
            if (prop instanceof WageObserver)
            {
                addObserver((WageObserver)(prop) );
            }
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
}
