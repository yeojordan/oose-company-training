package controller.events;

import model.*;
import controller.events.*;
import java.util.*;


public class RevenueIncrease extends Event
{
    public RevenueIncrease()
    {
        super();
    }

    public void performEvent(Map<String, Property> properties)
    {
        double newRevenue;


        Property prop = properties.get(getProperty());

        newRevenue = ((BusinessUnit)(prop)).getRevenue();

        newRevenue = newRevenue * 1.05;

        ((BusinessUnit)(prop)).setRevenue(newRevenue);


    }

}
