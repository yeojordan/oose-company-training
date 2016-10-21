package controller.events;

import model.*;
import controller.events.*;
import java.util.*;
import controller.*;

public class WageDecrease extends Event
{
    public WageDecrease()
    {
        super();
    }

    public void performEvent(PropertyController propertyController)
    {
        propertyController.notifyObservers(0.95);
    }

}
