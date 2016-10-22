package controller;

import java.util.*;
import controller.events.*;
import model.exceptions.*;

public class EventController
{
    private List<Event> eventList;

    public EventController()
    {
        this.eventList = new LinkedList<Event>();
    }

    public void addEvent(Event event) throws EventException
    {
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

    public List<Event> getEvents()
    {
        return this.eventList;
    }

    public void handleEvent(int year, PropertyController propertyController)
    {
        Iterator<Event> eventIterator = this.eventList.iterator();
        Event event = null;

        // If there are more events
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
