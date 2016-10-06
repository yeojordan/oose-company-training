package controller.reading;

import java.util.*;
import java.io.*;

public abstract class FileReading
{
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
