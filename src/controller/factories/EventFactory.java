package controller.factories;

import model.*;
import controller.plans.*;
import controller.events.*;
import controller.*;


public class EventFactory
{
    private PropertyController propertyController;
    public EventFactory(PropertyController propertyController)
    {
        this.propertyController = propertyController;
    }

    public Event createEvent(String[] line) throws IllegalArgumentException
    {
        Event event;
        int year        = Integer.parseInt(line[0]);
        String type     = line[1];
        String property = line[2];


        switch (type)
        {
            case "W+":
                validateWage(property);
                event = new WageIncrease();
                break;
            case "W-":
                validateWage(property);
                event = new WageDecrease();
                break;
            case "R+":
                validateRevenue(property);
                event = new RevenueIncrease();
                break;
            case "R-":
                validateRevenue(property);
                event = new RevenueDecrease();
                break;
            case "V+":
                validateValue(property);
                event = new ValueIncrease();
                break;
            case "V-":
                validateRevenue(property);
                event = new ValueDecrease();
                break;
            default:
                throw new IllegalArgumentException("Invalid event type");
        }

        event.setYear(year);
        event.setProperty(property);

        return event;
    }



    public void validateWage(String property) throws IllegalArgumentException
    {
        if ( !(property.equals("")) )
        {
            throw new IllegalArgumentException("Wage Event Cannot apply to a Single Business Unit");
        }

    }

    public void validateRevenue(String property) throws IllegalArgumentException
    {
        if ( property.equals("") )
        {
            throw new IllegalArgumentException("Revenue Event must apply to a Single Business Unit");
        }

    }

    public void validateValue(String property) throws IllegalArgumentException
    {

        if ( property.equals("") )
        {
            throw new IllegalArgumentException("Value Event must apply to a Single Business Unit or Company");
        }
    }



}
