package view;

import model.*;
import view.*;
import java.io.*;
import java.util.*;
import controller.plans.*;

public class SimulatorView
{

    public void displayProperties(Map<String, Property> propertyMap)
    {
        if (propertyMap == null)
            System.out.println("MAP NULL:");


        System.out.println(propertyMap.size());
        System.out.println("PRINTING PROPERTIES");

        for(Property prop : propertyMap.values() )
        {
            System.out.println(prop.toString());
        }
    }

    public void displayBusinessUnits(Map<String, Property> propertyMap)
    {
        for(Property prop : propertyMap.values() )
        {
            if( prop instanceof BusinessUnit )
                System.out.println(prop.toString());
        }
    }

    public void displayEvents(List<Event> eventList)
    {
        for(Event ev : eventList)
        {
            System.out.println(ev.toString());
        }
    }

    public void displayPlans(List<Plan> planList)
    {
        for(Plan plan : planList)
        {
            System.out.println(plan.toString());
        }
    }
}
