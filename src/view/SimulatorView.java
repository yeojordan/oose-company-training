package view;

import model.*;
import view.*;
import java.io.*;
import java.util.*;
import controller.plans.*;
import controller.events.*;

public class SimulatorView
{

    /**
     * Display all properties in the properties map
     * @param  propertyMap  Map of properties
     */
    public void displayProperties(Map<String, Property> propertyMap)
    {
        for(Property prop : propertyMap.values() )
        {
            System.out.println(prop.toString());
        }
    }

    /**
     * Display all business units in the properties map
     * @param  propertyMap  Map of properties
     */
    public void displayBusinessUnits(Map<String, Property> propertyMap)
    {
        for(Property prop : propertyMap.values() )
        {
            if( prop instanceof BusinessUnit )
            {
                System.out.println(prop.toString());
            }
        }
    }

    /**
     * Display all events in the event list
     * @param  eventList    List of events
     */
    public void displayEvents(List<Event> eventList)
    {
        for(Event ev : eventList)
        {
            System.out.println(ev.toString());
        }
    }

    /**
     * Display all plans in the plan list
     * @param  planList     List of plans
     */
    public void displayPlans(List<Plan> planList)
    {
        for(Plan plan : planList)
        {
            System.out.println(plan.toString());
        }
    }


    /**
     * Display Exception message
     * @param e  Exception to be displayed
     */
    public void displayException(Exception e)
    {
        System.out.println(e.getMessage());
    }
}
