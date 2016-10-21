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


    public ReadEvent(EventController controller)
    {
        this.controller = controller;
    }

    public void processLine(String[] line)
    {
        Event event = null;
        int year    = Integer.parseInt(line[0]);
        String eventString = line[1];
        String property = line[2];

        EventFactory evFact = new EventFactory();

        event = evFact.createEvent(eventString);
        event.setYear(year);
        event.setProperty(property);

        controller.addEvent(event);
    }


}
