package controller;

import model.*;

import java.util.*;
import java.io.*;

public class ReadProperty extends FileReading
{
    private List<PropertyEntry> properties;

    public ReadProperty()
    {
        properties = new LinkedList<PropertyEntry>();
    }

    public List<PropertyEntry> readFile(String filename)
    {
        String[] result = new String[6];
        PropertyEntry entry = null;
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
                entry = new PropertyEntry(result);
                entry.printEntry();
                //System.out.println(line);
                // for (String val: result)
                // {
                //     System.out.print(val + ",");
                // }
                // System.out.println();
            }
            input.close();

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return properties;
    }
}
