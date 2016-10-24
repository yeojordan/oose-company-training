/**
* @Author: Jordan Yeo
* @Date:   16/10/2016
* @Project: OOSE Assignment SEM 2 2016
* @Last modified by:   Jordan Yeo
* @Last modified time: 24/10/2016
* @Purpose: Handles user input and output
*/


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
    public void displayProperties(int currYear, Map<String, Property> propertyMap)
    {
        System.out.println("\n\n\n\n");
        System.out.println("YEAR: " + currYear);

        for(Property prop : propertyMap.values() )
        {
            System.out.println(prop.toString());
        }
    }

    public void displayCompanies(int currYear, Map<String, Property> propertyMap)
    {
        System.out.println("\n\n\n\n");
        System.out.println("YEAR: " + currYear);

        for(Property prop : propertyMap.values() )
        {
            if( prop instanceof Company )
            {
                System.out.println(prop.toString());
            }
        }
    }

    /**
     * Display all business units in the properties map
     * @param  propertyMap  Map of properties
     */
    public void displayBusinessUnits(int currYear, Map<String, Property> propertyMap)
    {
        System.out.println("\n\n\n\n");
        System.out.println("YEAR: " + currYear);

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
