package controller.reading;

import controller.*;
import model.*;

import java.util.*;
import java.io.*;

public class ReadEvent extends FileReading
{
    private SimulatorController controller;


    public ReadEvent(SimulatorController controller)
    {
        this.controller = controller;
    }

    public void processLine(String[] line)
    {
        Event event = null;
        int year = Integer.parseInt(line[0]);
        String eventString = line[1];
        String property = line[2];

        event = new Event(year, eventString, property);



        controller.addEvent(event);
    }


}
