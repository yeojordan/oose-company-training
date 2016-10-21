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
        Map<String, Property> properties = propertyController.getProperties();

        Property prop = properties.get(getProperty());
        // Find Business Units

        prop.updateValue(0.95);

    }

}
