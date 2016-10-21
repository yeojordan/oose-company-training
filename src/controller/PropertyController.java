package controller;

import java.util.*;
import model.*;

public class PropertyController
{
    private Company primaryCompany;
    private Map<String, Property> propertyMap;

    public PropertyController()
    {
        this.primaryCompany = null;
        this.propertyMap    = new HashMap<String, Property>();
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
        if ( (property instanceof Company) && (primaryCompany == null) )
        {
            primaryCompany = (Company)property;
        }

        this.propertyMap.put(key, property);

    }

/*    public void addObserver(WageObserver property)
    {
        String name = null;
        BusinessUnit prop = (BusinessUnit)(property);
        name = prop.getName();

        wageObservers.put( name, (WageObserver)property);
    }

    public void removeObserver(String key)
    {
        wageObservers.remove(key);
    }
*/
    public Company getPrimaryCompany()
    {
        return this.primaryCompany;
    }

    public void updateProfit()
    {
        // Calculate interest for each company for previous year's bank balance
        for ( Property comp : this.propertyMap.values() )
        {
            if (comp instanceof Company )
            {
                // If company has no owner or sold to unnamed buyer
                if ( (comp.getOwner().equals("")) || (comp.getOwner().equals("Unnamed Buyer")) )
                {
                    //System.out.println("Company to Calculate Profit On: " + comp.getName() + "\nOwner: " + comp.getOwner() + "\n\n\n");
                    // Updates profit
                    ((Company)(comp)).calculateProfit();
                }
            }
        }
    }
}
