package controller.factories;

import model.*;
import controller.plans.*;
import controller.events.*;
import controller.*;
import model.exceptions.*;

public class EventCreator
{
    private PropertyController propertyController;

    /**
     * Default Constructor for the EventCreator
     * @param  propertyController The property Administrator
     */
    public EventCreator(PropertyController propertyController)
    {
        this.propertyController = propertyController;
    }

    /**
     * Create an event based on a String array containing parameters
     * @param  line  Parameters of an Event as Strings
     * @return event An event created using the parameters passed in
     */
    public Event createEvent(String[] line) throws EventException
    {
        Event event;
        int year        = Integer.parseInt(line[0]);
        String type     = line[1];
        String property = line[2];

        try
        {
            year = Integer.parseInt(line[0]);
        }
        catch(NumberFormatException e)
        {
            throw new EventException("Invalid Number Format");
        }

        /* Create a subclass of Event depending on the type of Event */
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

        /* Set the remaining fields of an Event subclass */
        event.setYear(year);
        event.setProperty(property);

        return event;
    }


    /**
     * Validate if the property name for a Wage Event is valid
     * @param property The property String to validate
     */
    public void validateWage(String property) throws WageEventException
    {
        if ( !(property.equals("")) )
        {
            throw new WageEventException("Wage Event Cannot apply to a Single Business Unit");
        }
    }

    /**
     * Validate if the property name for a Revenue Event is valid
     * @param property The property String to validate
     */
    public void validateRevenue(String property) throws RevenueEventException
    {
        if ( property.equals("") )
        {
            throw new RevenueEventException("Revenue Event must apply to a Single Business Unit");
        }

    }

    /**
     * Validate if the property name for a Value Event is valid
     * @param property The property String to validate
     */
    public void validateValue(String property) throws ValueEventException
    {
        if ( property.equals("") )
        {
            throw new ValueEventException("Value Event must apply to a Single Business Unit or Company");
        }
    }



}
