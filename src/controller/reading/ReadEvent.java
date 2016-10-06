package controller.reading;

import model.*;

import java.util.*;
import java.io.*;

public class ReadEvent extends FileReading
{
    //private SimulatorController controller;
    private List<Event> events;

    public ReadEvent(List<Event> events)
    {
        this.events = events;
    }

    public void processLine(String[] line)
    {
        Event event = null;
        int year = Integer.parseInt(line[0]);
        String eventString = line[1];
        String property = line[2];

        event = new Event(year, eventString, property);

        events.add(event);
    }


}
