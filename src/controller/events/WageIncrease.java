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
