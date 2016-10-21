package controller;

import java.util.*;
import model.*;
import controller.observer.*;

public class PropertyController
{
    private Company primaryCompany;
    private Map<String, Property> propertyMap;
    private List<WageObserver> wageObservers;

    public PropertyController()
    {
        this.primaryCompany = null;
        this.propertyMap    = new HashMap<String, Property>();
        this.wageObservers = new LinkedList<WageObserver>();
    }


    public Map<String, Property> getProperties()
    {
        return this.propertyMap;
    }

    // Insert a property the map
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

    public void addObserver(WageObserver property)
    {
        wageObservers.add((WageObserver)property);
    }

    // public void removeObserver(String key)
    // {
    //     wageObservers.remove(key);
    // }

    public void notifyObservers(double multiplier)
    {
        for (WageObserver wo : wageObservers )
        {
            wo.update(multiplier);
        }
    }


    public Company getPrimaryCompany()
    {
        return this.primaryCompany;
    }

    public void updateProfit()
    {
        // Calculate interest for each company for previous year's bank balance
        for ( Property prop : this.propertyMap.values() )
        {
            // if (comp instanceof Company )
            // {
                // If company has no owner or sold to unnamed buyer
                if ( (prop.getOwner().equals("")) || prop.getOwner().equals("Unnamed Buyer") )
                {
                    //System.out.println("Company to Calculate Profit On: " + comp.getName() + "\nOwner: " + comp.getOwner() + "\n\n\n");
                    // Updates profit
                    // ((Company)(comp)).calculateProfit();
                    prop.calculateProfit();
                }
            // }
        }
    }
}
