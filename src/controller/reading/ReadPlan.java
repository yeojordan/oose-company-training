package controller.reading;

import model.*;

import java.util.*;
import java.io.*;

public class ReadPlan extends FileReading
{
    //private SimulatorController controller;
    private List<Plan> plans;

    public ReadPlan(List<Plan> plans)
    {
        this.plans = plans;
    }

    public void processLine(String[] line)
    {
        Plan plan = null;
        int year = Integer.parseInt(line[0]);
        char decision = line[1].charAt(0);
        String property = line[2];

        plan = new Plan(year, decision, property);

        plans.add(plan);
    }


}
