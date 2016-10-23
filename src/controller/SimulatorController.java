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
    public void runSimulation(int start, int end) throws EventException, PlanException, PropertyException, IllegalArgumentException
    {

        if( start > end )
        {
            throw new IllegalArgumentException("Start year cannot be earlier than end year");
        }


        int eventYear;

        for (int currYear = start; currYear <= end; currYear++)
        {

            System.out.println("\n\n\n\n");
            System.out.println("YEAR: " + currYear);

            view.displayProperties(propertyController.getProperties());

            eventController.handleEvent(currYear, this.propertyController);

            planController.handlePlan(currYear, this.propertyController);

            propertyController.updateProfit();


        }//End for
    }

    public void printBusinessUnits()
    {
        view.displayBusinessUnits(this.propertyController.getProperties());
    }

    public void printEvents()
    {
        view.displayEvents(this.eventController.getEvents());
    }

    public void printPlans()
    {
        view.displayPlans(this.planController.getPlans());
    }




}
