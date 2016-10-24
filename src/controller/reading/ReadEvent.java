/**
* @Author: Jordan Yeo
* @Date:   21/10/2016
* @Project: OOSE Assignment SEM 2 2016
* @Last modified by:   Jordan Yeo
* @Last modified time: 24/10/2016
* @Purpose: Handles the necessary parsing and delegation of creation of Events
*/


package controller.reading;

import controller.*;
import model.*;
import controller.factories.*;
import controller.events.*;
import java.util.*;
import java.io.*;
import model.exceptions.*;

public class ReadEvent extends FileReading
{
    private EventController controller;
    private PropertyController propertyController;

    /**
     * Constructor to create ReadEvent, for processing an Event file
     * @param   controller          EventController to store events
     * @param   propertyController  PropertyController to assist in validating events
     */
    public ReadEvent(EventController controller, PropertyController propertyController)
    {
        this.controller = controller;
        this.propertyController = propertyController;
    }

    /**
     * Accepts an array of Strings containing parameters for an Event.
     * Delegates the creation and then adds the newly created Event to the
     * eventController
     * @param line  An array of strings containing parameters for an Event
     */
    public void processLine(String[] line) throws FileFormatException
    {
        Event event = null;

        // Create a new EventCreator, giving it access to the current properties
        EventCreator evCreator = new EventCreator(this.propertyController);

        // Create a new EventCreator, giving it access to the current properties
        event = evCreator.createEvent(line);

        // Add the event to the EventController
        controller.addEvent(event);

    }


}
