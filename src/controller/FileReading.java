package controller;

import java.util.*;
import java.io.*;

public abstract class FileReading
{

    private SimulatorController controller;

    // public FileReading(SimulatorController controller)
    // {
    //     this.controller = controller;
    // }


    // Template Method
    public void read(String filename)
    {
        String[] result = new String[6];
        // PropertyEntry entry = null;
        try
        {
            Scanner input = null;
            File file = new File(filename);

            input = new Scanner(file);

            String firstLine = input.nextLine();
            while (input.hasNextLine())
            {
                String line = input.nextLine();
                result = line.split(",", -1);
                processLine(result);
                //entry = new PropertyEntry(result);
                //entry.printEntry();

            }
            input.close();

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    //protected abstract void readFile(String filename);

    protected abstract void processLine(String[] line);
}
