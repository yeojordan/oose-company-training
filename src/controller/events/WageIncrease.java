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
        propertyController.notifyObservers(1.05);
    }

}
