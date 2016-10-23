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
        try
        {
            if ( args.length != 5)
            {
                throw new IllegalArgumentException("Incorrect number of command line args");
            }

            // Organise command line parameters
            String propertyFile =   args[0];
            String eventFile    =   args[1];
            String planFile     =   args[2];
            int startYear       =   Integer.parseInt(args[3]);
            int endYear         =   Integer.parseInt(args[4]);





            // Perform file reading for Property file
            fileReader = new ReadProperty(propController);
            fileReader.read(propertyFile);

            // Perform file reading for Event file
            fileReader = new ReadEvent(eventController, propController);
            fileReader.read(eventFile);


            // Perform file reading for Plan file
            fileReader = new ReadPlan(planController, propController);
            fileReader.read(planFile);


            controller = new SimulatorController(propController, eventController, planController, view);

//controller.printEvents();

            // System.out.println("Initial Values");
            // controller.printProperties();
            //controller.printBusinessUnits();

            // Run Simulation
            controller.runSimulation(startYear, endYear);

            // System.out.println("\n\n\n\n Final Values");


            // Print Models
            // controller.printProperties();
            //controller.printBusinessUnits();
            //controller.printEvents();
            // controller.printPlans();

        }
        // catch(IllegalArgumentException e)
        // {
        //     //System.out.println(e.getMessage());
        //     view.displayException(e);
        // }
        // catch(IOException e)
        // {
        //     // System.out.println(e.getMessage());
        //     view.displayException(e);
        // }
        catch(IllegalArgumentException | IOException | PropertyException | EventException | PlanException  e)
        {
            // System.out.println(e.getMessage());
            view.displayException(e);
        }
        catch(FileFormatException e)
        {
            // System.out.println(e.getMessage());
            view.displayException(e);
        }


    }
}
