package controller;

import java.util.*;

import model.*;

public class SimulatorController
{
    private Map<String, Property> propertyMap;
    // private List<Event> eventList;


    public SimulatorController(Map<String, Property> properties)
    {
        //propertyList = new HashMap<Property>();
        this.propertyMap = properties;
    }
    //
    // public void setProperty(Map<Property> properties)
    // {
    //     this.propertyList = properties;
    // }


    // public void addProperty(Property property)
    // {
    //     propertyList.add(property);
    // }

    public void printProperties()
    {
        for(Property prop : propertyMap.values() )
        {
            System.out.println(prop.toString());
        }
    }
}
