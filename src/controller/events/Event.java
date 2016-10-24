/**
* @Author: Jordan Yeo
* @Date:   21/10/2016
* @Project: OOSE Assignment SEM 2 2016
* @Last modified by:   Jordan Yeo
* @Last modified time: 24/10/2016
* @Purpose: An abstract class for Events, as all events share common fields
*/


package controller.events;

import java.util.*;
import controller.events.*;
import model.*;
import controller.*;
import model.exceptions.*;

public abstract class Event
{
    private int year;
    private String property;

    /**
     * Constructor an Event
     */
    public Event()
    {
        this.year = 0;
        this.property = "";
    }


    /**
     * Set the year the event
     * @param year Year of the event
     */
    public void setYear(int year)
    {
        /* Check the year is non-negative */
        if (year > 0)
        {
            this.year = year;
        }
        else
        {
            throw new IllegalArgumentException("Invalid year");
        }
    }

    /**
     * Set the name of the Property the event will occur on
     * @param property The name of the property
     */
    public void setProperty(String property)
    {
        this.property = property;
    }

    /**
     * Retrieve the year of the event
     * @return int The year of the event
     */
    public int getYear()
    {
        return this.year;
    }

    /**
     * Retrieve the name of the property to perform the event on
     * @return String Name of the property the event is to be performed on
     */
    public String getProperty()
    {
        return this.property;
    }

    /**
     * Retrieve the state of the Event
     * @return String The state of the Event as a String
     */
    public String toString()
    {
        String toString = "";
        toString = toString + "Year:     "+ year + "\n";
        toString = toString + "Property: "+ property + "\n";

        return toString;
    }

    /**
     * Abstract method to be overriden by subclasses of Event
     * @param propertyController The property administrator
     */
    public abstract void performEvent(PropertyController propertyController) throws EventException;
}
