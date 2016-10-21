package controller.events;

import model.*;
import controller.events.*;
import java.util.*;
import controller.*;

public class RevenueDecrease extends Event
{
    public RevenueDecrease()
    {
        super();
    }

    public void performEvent(PropertyController propertyController)
    {
        double newRevenue;
        Map<String, Property> properties = propertyController.getProperties();

        Property prop = properties.get(getProperty());

        newRevenue = ((BusinessUnit)(prop)).getRevenue();

        newRevenue = newRevenue * 0.95;

        ((BusinessUnit)(prop)).setRevenue(newRevenue);


    }

}
