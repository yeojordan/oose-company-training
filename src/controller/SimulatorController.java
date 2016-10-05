package controller;

import java.util.*;

import model.*;

public class SimulatorController
{
    private List<Property> propertyList;
    // private List<Event> eventList;


    public SimulatorController()
    {
        propertyList = new LinkedList<Property>();
    }

    public void setProperty(List<Property> properties)
    {
        this.propertyList = properties;
    }

    
    public void addProperty(Property property)
    {
        propertyList.add(property);
    }

    public void printProperties()
    {
        for(Property prop: propertyList)
        {
            System.out.println(prop.toString());
        }
    }
}
