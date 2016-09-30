import java.util.*;
import java.io.*;

public class ReadProperty //extends FileReading
{
    private List<PropertyEntry> properties;

    public ReadProperty()
    {
        properties = new LinkedList<PropertyEntry>();
    }

    public List<PropertyEntry> readFile(String filename)
    {
        try
        {
            Scanner input = null;
            File file = new File(filename);

            input = new Scanner(file);


            while (input.hasNextLine())
            {
                String line = input.nextLine();
                String result = line.split(",");
                
                System.out.println(line);
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
