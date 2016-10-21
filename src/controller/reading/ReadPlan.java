package controller.reading;

import controller.*;
import model.*;
import controller.plans.*;
import controller.factories.*;
import java.util.*;
import java.io.*;

public class ReadPlan extends FileReading
{
    private PlanController controller;
    private PropertyController propertyController;

    public ReadPlan(PlanController controller, PropertyController propertyController)
    {
        this.controller = controller;
        this.propertyController = propertyController;
    }

    public void processLine(String[] line) throws IllegalArgumentException
    {
        Plan plan = null;

        PlanFactory pFact = new PlanFactory(propertyController);

        plan = pFact.createPlan(line);

        //plan = new Plan(year, decision, property);

        controller.addPlan(plan);
    }


}
