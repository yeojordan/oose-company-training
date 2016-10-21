package controller.reading;

import controller.*;
import model.*;
import controller.factories.*;
import controller.events.*;
import java.util.*;
import java.io.*;

public class ReadEvent extends FileReading
{
    private EventController controller;
    private PropertyController propertyController;

    public ReadEvent(EventController controller, PropertyController propertyController)
    {
        this.controller = controller;
        this.propertyController = propertyController;
    }

    public void processLine(String[] line) throws IllegalArgumentException
    {
        Event event = null;
        // Check the property exists in the map

        EventFactory evFact = new EventFactory(this.propertyController);
        event = evFact.createEvent(line);
        
        controller.addEvent(event);

    }


}
