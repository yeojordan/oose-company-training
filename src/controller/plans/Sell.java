package controller.plans;

import java.util.*;
import model.*;
import model.exceptions.*;

public class Sell extends Plan
{
    /**
     * Default Constructor for Sell Object
     */
    public Sell()
    {
        /* Allow the Plan super class to handle intialisation */
        super();
    }

    /* Buy a business unit or company

        1. Check if owned already
        2. Look for cycle of ownership
        3. Check for an owner exists in the map of properties
        4. Add property to owned map
        5. Remove property from old owner
        6. Decrease bank account by value of property

    */

    /**
    * Execute a Sell plan
    * @param  properties     The map of all properties in simulation
    * @param  primaryCompany The primary company for the Simulatio
    */
    public void performPlan(Map<String, Property> properties, Company primaryCompany) throws FileFormatException
    {
        Property property = null;

        // Property to be bought
        String propertyName = getProperty();

        // Retrieve property from map
        property = properties.get(propertyName);

        // Retrieve value of property
        double value;

        // If the primary company owns the property
        if ( (primaryCompany.checkOwnership(propertyName)) && (property != null) )
        {
            value = property.getMonetaryValue();
            // Add property to new owner
            primaryCompany.removeProperty(property);

            // Increase bank balance
            primaryCompany.updateBank(value);

            property.setOwner("Unnamed Buyer");
        }
        else
        {
            throw new FileFormatException("Cannot Sell a Property you do not own");
        }



    }

    /**
    * Retrieve the state of the Sell object
    * @return String   The state of the Plan as a String
    */
    public String toString()
    {
        String toString = super.toString();
        toString = toString + "Buy/Sell: Sell\n";
        return toString;
    }


}
