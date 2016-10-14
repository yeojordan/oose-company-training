import java.util.*;
import java.io.*;
import controller.reading.*;
import controller.*;
import model.*;

public class Start
{
    public static void main(String[] args)
    {
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


            // Initialise models
            Map<String, Property> props     = new HashMap<String, Property>();
            List<Event> events              = new LinkedList<Event>();
            List<Plan> plans                = new LinkedList<Plan>();

            // File Reader and Controller
            FileReading fileReader          = null;
            SimulatorController controller  = null;

            // Perform file reading for Property file
            fileReader = new ReadProperty(props);
            fileReader.read(propertyFile);

            // Perform file reading for Event file
            fileReader = new ReadEvent(events);
            fileReader.read(eventFile);

            // Perform file reading for Plan file
            fileReader = new ReadPlan(plans);
            fileReader.read(planFile);

            // Create controller with models
            controller = new SimulatorController(props, events, plans);


            System.out.println("Initial Values");
            controller.printProperties();
            //controller.printBusinessUnits();

            // Run Simulation
            controller.runSimulation(startYear, endYear);

            System.out.println("\n\n\n\n Final Values");


            // Print Models
            controller.printProperties();
            //controller.printBusinessUnits();
            //controller.printEvents();
            //controller.printPlans();

        }
        catch(IllegalArgumentException e)
        {

            System.out.println(e.getMessage());
        }


    }
}
