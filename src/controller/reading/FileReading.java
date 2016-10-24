/**
* @Author: Jordan Yeo
* @Date:   05/10/2016
* @Project: OOSE Assignment SEM 2 2016
* @Last modified by:   Jordan Yeo
* @Last modified time: 24/10/2016
* @Purpose: An abstract class for File Reading, as each file will need to be
*           processed differently. However, there are common steps between each.
*/


package controller.reading;

import java.util.*;
import java.io.*;
import model.exceptions.*;

public abstract class FileReading
{
    /**
     * Opens the file, reads a line, delegates processing to subclass and
     * finally closes the file.
     * @param filename  The name of the file to be read from
     */
    public void read(String filename) throws FileFormatException, IOException
    {
        String[] result = new String[6];
        Scanner input = null;
        // PropertyEntry entry = null;
        try
        {
            File file = new File(filename);
            input = new Scanner(file);

            /* Retrieve the first line from the file */
            String line = input.nextLine();

            /* Reading each subsequent line from a file*/
            while (input.hasNextLine())
            {

                line = input.nextLine();

                /* Store the line as an aray of Strings */
                result = line.split(",", -1);

                /* Call the template method from a subclass */
                processLine(result);
            }
        }
        catch(IOException e)
        {
            throw new IOException("Error occurred in file reading ");
        }
        catch(FileFormatException e)
        {
            throw new FileFormatException("Error in file parsing.\n", e);
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


    /**
     * Template method to be implemted by subclasses. To perform processing
     * on the line read from a file
     * @param line An array of strings containing the line from a file
     */
    abstract void processLine(String[] line) throws FileFormatException;
}
