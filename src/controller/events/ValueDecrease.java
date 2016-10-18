package controller.events;

import model.*;
import controller.events.*;
import java.util.*;


public class ValueDecrease extends Event
{
    public ValueDecrease()
    {
        super();
    }

    public void performEvent(Map<String, Property> properties)
    {
        double newWages;

        Property prop = properties.get(getProperty());
        // Find Business Units

        prop.updateValue(0.95);

    }

}
