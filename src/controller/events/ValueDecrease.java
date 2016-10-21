package controller.events;

import model.*;
import controller.events.*;
import java.util.*;
import controller.*;

public class ValueDecrease extends Event
{
    public ValueDecrease()
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

        newValue *= 0.95;
        //prop.updateValue(0.95);
        prop.setMonetaryValue(newValue);
    }

}
