package controller.events;

import java.util.*;
import controller.events.*;
import model.*;

public abstract class Event
{
    private int year;
    private String property;

    public Event()
    {
        this.year = 0;
        this.property = "";
    }


    public void setYear(int year)
    {
        if (year > 0)
        {
            this.year = year;
        }
        else
        {
            throw new IllegalArgumentException("Invalid year");
        }
    }

    public void setProperty(String property)
    {
        this.property = property;
    }

    public int getYear()
    {
        return this.year;
    }

    public String getProperty()
    {
        return this.property;
    }

    public String toString()
    {
        String toString = "";
        toString = toString + "Year:     "+ year + "\n";
        toString = toString + "Property: "+ property + "\n";

        return toString;
    }

    public abstract void performEvent(Map<String, Property> propertyMap);
}
