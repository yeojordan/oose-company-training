/**
* @Author: Jordan Yeo
* @Date:   16/10/2016
* @Project: OOSE Assignment SEM 2 2016
* @Last modified by:   jordanyeo
* @Last modified time: 24/10/2016
* @Purpose: Handles Buy plans
*/


package controller.plans;

import java.util.*;
import model.*;
import model.exceptions.*;

public class Buy extends Plan
{
    /**
     * Constructor for Buy Object
     */
    public Buy()
    {
        /* Allow the Plan super class to handle intialisation */
        super();
    }

    /**
    * Execute a Buy plan
    * @param  properties     The map of all properties in simulation
    * @param  primaryCompany The primary company for the Simulatio
    */
    public void performPlan(Map<String, Property> properties, Company primaryCompany) throws FileFormatException
    {
        Property property = null;
        Company oldOwner = null;
        String ogOwner;

        String propertyName;

            // Property to be bought
            propertyName = getProperty();

            // Retrieve property from map
            property = properties.get(propertyName);

            double value;

            // Retrieve name of original owner
            ogOwner = property.getOwner();

            // Retrieve original owner from map
            oldOwner = (Company)(properties.get(ogOwner));

            // If the primary company doesn't already own the property
            // and property exists in map
            if ( !(primaryCompany.checkOwnership(propertyName)) && (property != null) )
            {
                value = property.getMonetaryValue();

                // Set owner name in property bought
                property.setOwner(primaryCompany.getName());

                // Add property to new owner
                primaryCompany.addProperty(property);

                // Check if old owner is in simulation
                if (oldOwner != null)
                {
                    // Remove property from old owner
                    oldOwner.removeProperty(property);
                    // Increase bank balance, by value of property
                    oldOwner.updateBank(value);

                }

                // Decrease bank balance
                primaryCompany.updateBank(value*-1.0);

            }
            else
            {
                throw new FileFormatException("Cannot Buy a Property you already own");
            }

    }

     /**
     * Retrieve the state of the Buy object
     * @return String   The state of the Plan as a String
     */
    public String toString()
    {
        String toString = super.toString();
        toString = toString + "Buy/Sell: Buy\n";
        return toString;
    }



}
