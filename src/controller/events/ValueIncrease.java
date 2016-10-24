/**
* @Author: Jordan Yeo
* @Date:   21/10/2016
* @Project: OOSE Assignment SEM 2 2016
* @Last modified by:   Jordan Yeo
* @Last modified time: 24/10/2016
* @Purpose: Handles value increase events
*/


package controller.events;

import model.*;
import model.exceptions.*;
import controller.events.*;
import java.util.*;
import controller.*;

public class ValueIncrease extends Event
{
    public ValueIncrease()
    {
        /* Allow the Event super class to handle intialisation */
        super();
    }

    /**
     * Perform a value increase on a given Business Unit or Company
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


        /* Update the value for the specific Business Unit or Company */
        newValue = prop.getMonetaryValue();

        newValue *= 1.05;

        prop.setMonetaryValue(newValue);
    }

}
