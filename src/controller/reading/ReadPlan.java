/**
* @Author: Jordan Yeo
* @Date:   21/10/2016
* @Project: OOSE Assignment SEM 2 2016
* @Last modified by:   Jordan Yeo
* @Last modified time: 24/10/2016
* @Purpose: Handles the necessary parsing and delegation of creation of Plans
*/


package controller.reading;

import controller.*;
import model.*;
import model.exceptions.*;
import controller.plans.*;
import controller.factories.*;
import java.util.*;
import java.io.*;

public class ReadPlan extends FileReading
{
    private PlanController controller;
    private PropertyController propertyController;

    /**
     * Constructor to create ReadPlan, for processing a Plan file
     * @param   controller          PlanController to add store plans
     * @param   propertyController  PropertyController to assist in validating plans
     */
    public ReadPlan(PlanController controller, PropertyController propertyController)
    {
        this.controller = controller;
        this.propertyController = propertyController;
    }

    /**
     * Accepts an array of Strings containing parameters for a Plan.
     * Delegates the creation and then adds the newly created Plan to the
     * planController
     * @param line  An array of strings containing parameters for a Plan
     */
    public void processLine(String[] line) throws FileFormatException
    {
        Plan plan = null;

        // Create a new PlanCreator, giving it access to the current properties
        PlanCreator pFact = new PlanCreator(propertyController);

        // Create a new PlanCreator, giving it access to the current properties
        plan = pFact.createPlan(line);

        // Add the plan to the EventController
        controller.addPlan(plan);
    }


}
