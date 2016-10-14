package controller.plans;

import java.util.*;
import model.*;

public class Buy implements PerformPlan
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
        5. Decrease bank account by value of property

    */
    public void performPlan(Plan plan)
    {
        // Property to be bought
        String property = plan.getProperty();

        Company newOwner = properties.get();

        
        if ( !(properties.containsKey(property)) )
        {

        }

/*
        // Loop through all properties
        for ( Property prop : properties.values() )
        {

            // Find Business Units
            if ( prop instanceof BusinessUnit )
            {

                //double oldWages =
                // Calculate wages of Business Unit
                newWages = ((BusinessUnit)(prop)).getWages() * 0.95;

                if ( task.charAt(1) == '+' )
                {
                    newWages = ((BusinessUnit)(prop)).getWages() * 1.05;
                }

                // Update wages of Business Unit
                ((BusinessUnit)(prop)).setWages(newWages);

            }
        }

        */
    }





}
