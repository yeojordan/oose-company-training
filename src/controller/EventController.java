/**
* @Author: Jordan Yeo
* @Date:   21/10/2016
* @Project: OOSE Assignment SEM 2 2016
* @Last modified by:   jordanyeo
* @Last modified time: 24/10/2016
* @Purpose: Handles performing events and addition of events
*/


package controller;

import java.util.*;
import model.exceptions.*;
import controller.events.*;
import model.exceptions.*;

public class EventController
{
    private List<Event> eventList;

    /**
     * Constructor for EventController
     */
    public EventController()
    {
        this.eventList = new LinkedList<Event>();
    }

    /**
     * Adds an event to the list of events
     * @param event [description]
     */
    public void addEvent(Event event) throws EventException
    {
        // Event tempEvent;

        /* Validates the newest event to be added is in chronological order */
        if(eventList.size() > 0)
        {
            Event tempEvent = eventList.get(eventList.size() - 1);
            if ( event.getYear() < tempEvent.getYear() || tempEvent == null )
            {
                throw new EventException("Events must be listed in chronological order");
            }
        }
        this.eventList.add(event);

    }

    /**
     * Retrieve the entire list of events
     * @return List of events in the EventController
     */
    public List<Event> getEvents()
    {
        return this.eventList;
    }

    /**
     * Handle an event based on a given year of a simulation
     * @param  year                 The current year of the simulation
     * @param  propertyController   The property administrator
     */
    public void handleEvent(int year, PropertyController propertyController) throws EventException
    {
        // Instantiate an iterator for events
        Iterator<Event> eventIterator = this.eventList.iterator();
        Event event = null;

        // Check if there are more events
        if (eventIterator.hasNext() )
        {
            // Retrieve next event
            event = eventIterator.next();

            // Check the event matches the year
            while ( event != null && event.getYear() == year)
            {
                // Remove the event from the list
                eventIterator.remove();

                // Perform the event
                event.performEvent(propertyController);

                // Check if there are any more events in the list
                event = null;
                if (eventIterator.hasNext() )
                {
                    // Retrieve the next iterator
                    event = eventIterator.next();
                }

            }

        }
    }

}
