/**
* @Author: Jordan Yeo
* @Date:   21/10/2016
* @Project: OOSE Assignment SEM 2 2016
* @Last modified by:   jordanyeo
* @Last modified time: 24/10/2016
* @Purpose: Main for Simulation
*/


import java.util.*;
import java.io.*;
import controller.reading.*;
import controller.*;
import model.*;
import model.exceptions.*;
import controller.plans.*;
import controller.events.*;
import view.*;



public class Start
{
    public static void main(String[] args)
    {
        // File Reader and Controllers
        FileReading fileReader              = null;
        SimulatorController controller      = null;
        PropertyController propController   = new PropertyController();
        PlanController planController       = new PlanController();
        EventController eventController     = new EventController();
        SimulatorView view                  = new SimulatorView();
        // 
        // String propertyFile;
        // String eventFile;
        // String planFile;
        // int startYear;
        // int endYear;

        try
        {
            if ( args.length != 5)
            {
                throw new IllegalArgumentException("Incorrect number of command line args");
            }

            // Organise command line parameters
            String propertyFile   =   args[0];
            String eventFile      =   args[1];
            String planFile       =   args[2];
            int startYear      =   Integer.parseInt(args[3]);
            int endYear        =   Integer.parseInt(args[4]);


            // Perform file reading for Property file
            fileReader = new ReadProperty(propController);
            fileReader.read(propertyFile);

            // Perform file reading for Event file
            fileReader = new ReadEvent(eventController, propController);
            fileReader.read(eventFile);

            // Perform file reading for Plan file
            fileReader = new ReadPlan(planController, propController);
            fileReader.read(planFile);

            // Create simulater controller
            controller = new SimulatorController(propController, eventController, planController, view);

            // Run simulation
            controller.runSimulation(startYear, endYear);

        }
        catch(NumberFormatException e)
        {
            view.displayException(e);
        }
        catch(IllegalArgumentException | IOException | PropertyException | EventException | PlanException  e)
        {
            view.displayException(e);
        }
        catch(FileFormatException e)
        {
            view.displayException(e);
        }
        catch(Exception e)
        {
            view.displayException(e);
        }


    }
}
