package controller;

import java.util.*;

import model.*;
import view.*;

public class SimulatorController
{
    private Map<String, Property> propertyMap;
    private List<Event> eventList;
    private List<Plan> planList;

    private SimulatorView view;
    // private List<Event> eventList;


    public SimulatorController(Map<String, Property> properties, List<Event> events, List<Plan> plans)
    {
        this.propertyMap = properties;
        this.eventList = events;
        this.planList = plans;
        view = new SimulatorView();
    }

    public void printProperties()
    {

        view.displayProperties(propertyMap);
    }

    public void printEvents()
    {
        view.displayEvents(eventList);
    }

    public void printPlans()
    {
        view.displayPlans(planList);
    }
}
