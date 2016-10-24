/**
* @Author: Jordan Yeo
* @Date:   21/10/2016
* @Project: OOSE Assignment SEM 2 2016
* @Last modified by:   Jordan Yeo
* @Last modified time: 24/10/2016
* @Purpose: Handles wage increase events
*/


package controller.events;

import model.*;
import model.exceptions.*;
import controller.events.*;
import java.util.*;
import controller.*;

public class WageIncrease extends Event
{
    public WageIncrease()
    {
        /* Allow the Event super class to handle intialisation */
        super();
    }

    /**
     * Perform a wage increase on all wage observers
     * @param propertyController The administrator of Properties
     */
    public void performEvent(PropertyController propertyController) throws EventException
    {
        propertyController.notifyObservers(1.05);
    }

}
