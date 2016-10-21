package controller.events;

import model.*;
import controller.events.*;
import java.util.*;
import controller.*;

public class RevenueIncrease extends Event
{
    public RevenueIncrease()
    {
        super();
    }

    public void performEvent(PropertyController propertyController)
    {
        double newRevenue;
        Map<String, Property> properties = propertyController.getProperties();

        if (properties == null)
            System.out.println("PROPERTY MAP NULL");

        Property prop = properties.get(getProperty());

        newRevenue = ((BusinessUnit)(prop)).getRevenue();

        newRevenue = newRevenue * 1.05;

        ((BusinessUnit)(prop)).setRevenue(newRevenue);


    }

}
