package controller.plans;

import model.*;
import model.exceptions.*;
import java.util.*;
public abstract class Plan
{
    String property;
    int year;

    /**
     * Default Constructor for a Plan
     */
    public Plan()
    {
        this.property = "";
        this.year = 0;
    }

    /**
     * Set the year the plan
     * @param year Year of the plan
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
     * Retrieve the year of the plan
     * @return int The year of the plan
     */
    public int getYear()
    {
        return this.year;
    }

    /**
     * Retrieve the name of the property to perform the plan on
     * @return String Name of the property the plan is to be performed on
     */
    public String getProperty()
    {
        return this.property;
    }

    /**
     * Retrieve the state of the Plan
     * @return String The state of the Plan as a String
     */
    public String toString()
    {
        String toString = "";
        toString = toString + "Year:     "+ year + "\n";
        toString = toString + "Property: "+ property + "\n";

        return toString;
    }

    /**
     * Abstract method to be overriden by subclasses of Plan
     * @param propertyController The property administrator
     */
    public abstract void performPlan(Map<String, Property> propertyMap, Company primaryCompany) throws FileFormatException;
}
