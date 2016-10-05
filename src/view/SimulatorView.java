package view;

import model.*;
import view.*;
import java.io.*;
import java.util.*;

public class SimulatorView
{

    public void displayProperties(Map<String, Property> propertyMap)
    {
        for(Property prop : propertyMap.values() )
        {
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
}
