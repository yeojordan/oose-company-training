/**
* @Author: Jordan Yeo
* @Date:   21/10/2016
* @Project: OOSE Assignment SEM 2 2016
* @Last modified by:   jordanyeo
* @Last modified time: 24/10/2016
* @Purpose: Handles performing Properties and addition of properties
*/


package controller;

import java.util.*;
import model.*;
import controller.observer.*;

public class PropertyController
{
    private Company primaryCompany;
    private Map<String, Property> propertyMap;
    private List<WageObserver> wageObservers;

    /**
     * Constructor for PropertyController
     * Instantiates a new HashMap for properties and new LinkedList for observers
     * Sets the primaryCompany to be null until one is added
     */
    public PropertyController()
    {
        this.primaryCompany = null;
        this.propertyMap    = new HashMap<String, Property>();
        this.wageObservers = new LinkedList<WageObserver>();
    }


    /**
     * Retrieve the map of properties
     * @return Map of properties in PropertyController
     */
    public Map<String, Property> getProperties()
    {
        return this.propertyMap;
    }


    /**
     * Insert a property to the current map of properties
     * @param property [description]
     */
    public void addProperty(Property property)
    {
        String key;
        key = property.getName();

        // If the company to insert is the first (primary)
        if ( (primaryCompany == null) && (property instanceof Company) )
        {
            primaryCompany = (Company)property;
        }

        this.propertyMap.put(key, property);

    }

    /**
     * Add an observer to the list of observers
     * @param property The property to be added as an observer
     */
    public void addObserver(WageObserver property)
    {
        wageObservers.add((WageObserver)property);
    }


    /**
     * Notify all observers of a change in wages
     * @param multiplier Value to multiply wages by
     */
    public void notifyObservers(double multiplier)
    {
        for (WageObserver wo : wageObservers )
        {
            wo.update(multiplier);
        }
    }


    /**
     * Retrieve the primary company
     * @return The Primary Company
     */
    public Company getPrimaryCompany()
    {
        return this.primaryCompany;
    }

    /**
     * Calculate the profit of each property in the map
     */
    public void updateProfit()
    {
        /* Iterate through each property */
        for ( Property prop : this.propertyMap.values() )
        {
             /* Calculate profit on properties without owners */
            if ( (prop.getOwner().equals("")) || prop.getOwner().equals("Unnamed Buyer")
                                    || prop.getOwner().equals("-"))
            {
                prop.calculateProfit();
            }

        }
    }
}
