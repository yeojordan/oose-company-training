package controller.events;

import model.*;
import controller.events.*;
import java.util.*;
import controller.*;

public class ValueIncrease extends Event
{
    public ValueIncrease()
    {
        super();
    }

    public void performEvent(PropertyController propertyController)
    {
        double newValue;
        Map<String, Property> properties = propertyController.getProperties();
        Property prop = properties.get(getProperty());
        // Find Business Units

        newValue = prop.getMonetaryValue();

        newValue *= 1.05;

        prop.setMonetaryValue(newValue);
    }

}
