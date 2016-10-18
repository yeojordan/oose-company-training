package controller.plans;

import model.*;
import java.util.*;
public abstract class Plan
{
    String property;
    int year;

    public Plan()
    {
        this.property = "";
        this.year = 0;
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

    public abstract void performPlan(Map<String, Property> propertyMap, Company primaryCompany);
}
