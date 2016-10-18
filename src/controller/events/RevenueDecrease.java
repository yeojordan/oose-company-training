package controller.events;

import model.*;
import controller.events.*;
import java.util.*;


public class RevenueDecrease extends Event
{
    public RevenueDecrease()
    {
        super();
    }

    public void performEvent(Map<String, Property> properties)
    {
        double newRevenue;


        Property prop = properties.get(getProperty());

        newRevenue = ((BusinessUnit)(prop)).getRevenue();

        newRevenue = newRevenue * 0.95;

        ((BusinessUnit)(prop)).setRevenue(newRevenue);


    }

}
