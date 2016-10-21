package controller.reading;

import java.util.*;
import java.io.*;

public abstract class FileReading
{
    // Template Method
    public void read(String filename) throws IllegalArgumentException, IOException
    {
        String[] result = new String[6];
        Scanner input = null;
        // PropertyEntry entry = null;
        try
        {

            File file = new File(filename);

            input = new Scanner(file);

            String firstLine = input.nextLine();
            while (input.hasNextLine())
            {
                String line = input.nextLine();
                result = line.split(",", -1);
                processLine(result);
            }


        }
        catch(IOException e)
        {
            throw new IOException("Error occurred in file reading ");
        }
        catch(IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Error in file parsing. " + e.getMessage() );
        }
        finally
        {
            // try
            // {
                input.close();
            // }
            // catch(IOException e)
            // {
            //     throw new IOException("File Stream failed to close");
            // }

        }
    }

    //protected abstract void readFile(String filename);

    abstract void processLine(String[] line);
}
