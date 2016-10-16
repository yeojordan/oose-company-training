package controller.plans;

import java.util.*;
import model.*;

public class Buy implements PlanAction
{
    private Map<String, Property> properties;

    public Buy(Map<String, Property> properties)
    {
        this.properties = properties;
    }

    /* Buy a business unit or company

        1. Check if owned already
        2. Look for cycle of ownership
        3. Check for an owner exists in the map of properties
        4. Add property to owned map
        5. Remove property from old owner
        6. Decrease bank account by value of property

    */
    public void performPlan(Plan plan, Company primaryCompany)
    {
        Property property = null;
        Company oldOwner = null;
        String ogOwner;
        // Property to be bought
        String propertyName = plan.getProperty();

        // Retrieve property from map
        property = properties.get(propertyName);

        // Retrieve value of property
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

    }


}
