package controller.events;

import model.*;
import model.exceptions.*;
import controller.events.*;
import java.util.*;
import controller.*;

public class ValueDecrease extends Event
{
    /**
     * Default constructor to create a ValueDecrease Object
     */
    public ValueDecrease()
    {
        /* Allow the Event super class to handle intialisation */
        super();
    }

    /**
     * Perform a value decrease on a given Business Unit or Company
     * @param propertyController The administrator of Properties
     */
    public void performEvent(PropertyController propertyController) throws EventException
    {
        double newValue;
        Map<String, Property> properties = propertyController.getProperties();

        /* Check if the properties are obtained correctly */
        if (properties == null)
        {
            throw new EventException("Properties Map is null");
        }

        Property prop = properties.get(getProperty());

        /* Retrieve the property to apply a revenue increase on */
        newValue = prop.getMonetaryValue();

        /* Update the value for the specific Business Unit or Company */
        newValue *= 0.95;
        prop.setMonetaryValue(newValue);
    }

}
