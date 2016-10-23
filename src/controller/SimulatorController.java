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
    public void runSimulation(int start, int end) throws FileFormatException, IllegalArgumentException
    {

        if( start > end )
        {
            throw new IllegalArgumentException("Start year cannot be earlier than end year");
        }


        int eventYear;

        for (int currYear = start; currYear <= end; currYear++)
        {



            view.displayCompanies(currYear, propertyController.getProperties());

            eventController.handleEvent(currYear, this.propertyController);

            planController.handlePlan(currYear, this.propertyController);

            propertyController.updateProfit();


        }//End for
    }




}
