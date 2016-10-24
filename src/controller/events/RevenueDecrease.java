/**
* @Author: Jordan Yeo
* @Date:   21/10/2016
* @Project: OOSE Assignment SEM 2 2016
* @Last modified by:   Jordan Yeo
* @Last modified time: 24/10/2016
* @Purpose: Handles revenue decrease events
*/


package controller.events;

import model.*;
import model.exceptions.*;
import controller.events.*;
import java.util.*;
import controller.*;

public class RevenueDecrease extends Event
{
    /**
     * Default constructor  RevenueDecrease object
     */
    public RevenueDecrease()
    {
        /* Allow the Event super class to handle intialisation */
        super();
    }

    /**
     * Perform a revenue decrease on a given Business Unit
     * @param propertyController The administrator of Properties
     */
    public void performEvent(PropertyController propertyController) throws EventException
    {
        double newRevenue;
        Map<String, Property> properties = propertyController.getProperties();

        /* Check if the properties are obtained correctly */
        if (properties == null)
        {
            throw new EventException("Properties Map is null");
        }

        /* Retrieve the property to apply a revenue increase on */
        Property prop = properties.get(getProperty());

        /* Update the revenue for the specific Business Unit */
        newRevenue = ((BusinessUnit)(prop)).getRevenue();
        newRevenue = newRevenue * 0.95;
        ((BusinessUnit)(prop)).setRevenue(newRevenue);

    }

}
