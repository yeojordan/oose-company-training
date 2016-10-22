package controller.factories;

import model.*;
import controller.plans.*;
import controller.events.*;
import controller.*;
import model.exceptions.*;

public class EventFactory
{
    private PropertyController propertyController;
    public EventFactory(PropertyController propertyController)
    {
        this.propertyController = propertyController;
    }

    public Event createEvent(String[] line) throws EventException
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
                throw new EventException("Invalid event type");
        }

        event.setYear(year);
        event.setProperty(property);

        return event;
    }



    public void validateWage(String property) throws WageEventException
    {
        if ( !(property.equals("")) )
        {
            throw new WageEventException("Wage Event Cannot apply to a Single Business Unit");
        }

    }

    public void validateRevenue(String property) throws RevenueEventException
    {
        if ( property.equals("") )
        {
            throw new RevenueEventException("Revenue Event must apply to a Single Business Unit");
        }

    }

    public void validateValue(String property) throws ValueEventException
    {

        if ( property.equals("") )
        {
            throw new ValueEventException("Value Event must apply to a Single Business Unit or Company");
        }
    }



}
