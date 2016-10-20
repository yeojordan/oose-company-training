package controller.events;

import model.*;
import controller.events.*;
import java.util.*;

public class WageDecrease extends Event
{
    public WageDecrease()
    {
        super();
    }

    public void performEvent(Map<String, Property> properties)
    {
        double newWages;

        // Loop through all properties
        for ( Property prop : properties.values() )
        {

            // Find Business Units
            if ( prop instanceof BusinessUnit )
            {

                // Calculate wages of Business Unit
                newWages = ((BusinessUnit)(prop)).getWages() * 0.95;

                // Update wages of Business Unit
                ((BusinessUnit)(prop)).setWages(newWages);

            }
        }
    }

}
