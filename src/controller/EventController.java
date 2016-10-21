package controller;

import java.util.*;
import controller.events.*;

public class EventController
{
    private List<Event> eventList;

    public EventController()
    {
        this.eventList = new LinkedList<Event>();
    }

    public void addEvent(Event event)
    {
        this.eventList.add(event);
    }

    public List<Event> getEvents()
    {
        return this.eventList;
    }
}
