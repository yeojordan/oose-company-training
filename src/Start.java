import java.util.*;
import java.io.*;
import controller.*;
import model.*;

public class Start
{
    public static void main(String[] args)
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
        int endYear         =   Integer.parseInt(args[4]);;

        SimulatorController controller = null;

        Map<String, Property> props = new HashMap<String, Property>();
        FileReading fileReader = new ReadProperty(props);
        fileReader.read(propertyFile);
        List<Event> events = new LinkedList<Event>();
        fileReader = new ReadEvent(events);


        fileReader.read(eventFile);
        controller = new SimulatorController(props, events);


        controller.printProperties();
        controller.printEvents();

    }
}
