import java.util.*;
import java.io.*;
import controller.*;
import model.*;

public class Start
{
    public static void main(String[] args)
    {

        SimulatorController controller = new SimulatorController();

        FileReading fileReader = new ReadProperty(controller);
        
        fileReader.read("propertyfile.txt");

        controller.printProperties();

        // for (PropertyEntry p : propEntries )
        // {
        //     p.printEntry();
        // }
    }
}
