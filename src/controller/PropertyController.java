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


}
