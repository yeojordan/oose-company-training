import java.util.*;
import java.io.*;
import controller.*;
import model.*;

public class Start
{
    public static void main(String[] args)
    {
        ReadProperty readProp = new ReadProperty();
        List<PropertyEntry> propEntries = null;
        propEntries = readProp.readFile("propertyfile.txt");
        // for (PropertyEntry p : propEntries )
        // {
        //     p.printEntry();
        // }
    }
}
