package controller.actions;

import java.util.*;
import model.*;

public class Wages implements Action
{
    private Map<String, Property> properties;

    public Wages(Map<String, Property> properties)
    {
        this.properties = properties;
    }

    public void performEvent(Event event)
    {
        String task = event.getEvent();
        double newWages;

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
    }
}
