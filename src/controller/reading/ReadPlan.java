package controller.reading;

import controller.*;
import model.*;

import java.util.*;
import java.io.*;

public class ReadPlan extends FileReading
{
    private SimulatorController controller;


    public ReadPlan(SimulatorController controller)
    {
        this.controller = controller;
    }

    public void processLine(String[] line)
    {
        Plan plan = null;
        int year = Integer.parseInt(line[0]);
        char decision = line[1].charAt(0);
        String property = line[2];

        plan = new Plan(year, decision, property);

        controller.addPlan(plan);
    }


}
