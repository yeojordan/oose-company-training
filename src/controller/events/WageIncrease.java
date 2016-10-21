package controller.events;

import model.*;
import controller.events.*;
import java.util.*;
import controller.*;

public class WageIncrease extends Event
{
    public WageIncrease()
    {
        super();
    }

    public void performEvent(PropertyController propertyController)
    {
        double newWages;
        Map<String, Property> properties = propertyController.getProperties();
        // Loop through all properties
        for ( Property prop : properties.values() )
        {
            // Find Business Units
            if ( prop instanceof BusinessUnit )
            {
                // Calculate wages of Business Unit
                newWages = ((BusinessUnit)(prop)).getWages() * 1.05;

                // Update wages of Business Unit
                ((BusinessUnit)(prop)).setWages(newWages);

            }
        }
    }

}
