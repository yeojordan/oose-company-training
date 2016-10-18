package controller.factories;

import model.*;
import controller.plans.*;
import controller.events.*;

public class EventFactory
{
    public Event createEvent(String type)
    {
        Event event;

        switch (type)
        {
            case "W+":
                event = new WageIncrease();
                break;
            case "W-":
                event = new WageDecrease();
                break;
            case "R+":
                event = new RevenueIncrease();
                break;
            case "R-":
                event = new RevenueDecrease();
                break;
            case "V+":
                event = new ValueIncrease();
                break;
            case "V-":
                event = new ValueDecrease();
                break;
            default:
                throw new IllegalArgumentException("Invalid event type");

        }

        return event;
    }
}
