/**
* @Author: Jordan Yeo
* @Date:   21/10/2016
* @Project: OOSE Assignment SEM 2 2016
* @Last modified by:   jordanyeo
* @Last modified time: 24/10/2016
* @Purpose: Controls the timing of the entire simulation
*/


package controller;

import java.util.*;

import model.*;
import model.exceptions.*;
import view.*;

import controller.observer.*;
import controller.plans.*;
import controller.events.*;
import controller.*;

public class SimulatorController
{

    private PropertyController propertyController;
    private EventController eventController;
    private PlanController planController;
    private SimulatorView view;


    /**
     * Constructor for the SimulatorController
     * @param   propertyController  Administrator for all properties
     * @param   eventController     Administrator for all events
     * @param   planController      Administrator for all plans
     * @param   view                View for the simulation
     */
    public SimulatorController(PropertyController propertyController,
                               EventController eventController,
                               PlanController planController,
                               SimulatorView view)
    {


        this.propertyController = propertyController;

        this.eventController    = eventController;

        this.planController     = planController;

        this.view               = view;



    }

    /**
    * Delegates the necessary tasks for the simulation to be executed
    * @param start  The start year of the simulation
    * @param end    The final year of the simulation
    */
    public void runSimulation(int start, int end) throws FileFormatException, IllegalArgumentException
    {

        /* Prevent the simulation from running if the start or end year is invalid */
        if( start > end )//|| start < 0 || end < 0 )
        {
            throw new IllegalArgumentException("Invalid year for start or end of simulation");
        }


        for (int currYear = start; currYear <= end; currYear++)
        {

            /* Display current state of companies for the given year */
            view.displayCompanies(currYear, propertyController.getProperties());

            /* Delegate event handling to the EventController for the given year */
            eventController.handleEvent(currYear, this.propertyController);

            /* Delegate plan handling to the EventController for the given year */
            planController.handlePlan(currYear, this.propertyController);

            /* Calculate profit for all properties in the simulation based on
               the events and plans of the year */
            propertyController.updateProfit();

        }
    }




}
