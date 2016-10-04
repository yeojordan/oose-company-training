package controller;

import model.*;

import java.util.*;
import java.io.*;

public class ReadProperty extends FileReading
{
    private SimulatorController controller;

    public ReadProperty(SimulatorController controller)
    {
        this.controller = controller;
    }

    public void processLine(String[] line)
    {
        Property prop = null;

        String name  = line[0];
        char type    = line[1].charAt(0);
        String owner = line[2];
        int worth    = valueValidation(line[3]);
        int revenue  = valueValidation(line[4]);
        int wages    = valueValidation(line[5]);

        // If entry is a Company
        if ( type == 'C' )
        {
            prop = new Company();
        }
        // If entry is a Business Unit
        else if ( type == 'B' )
        {
            prop = new BusinessUnit(revenue, wages);
        }

        // Set common class fields
        prop.setName(name);
        prop.setOwner(owner);
        prop.setMonetaryValue(worth);

        // Add to Property List in Controller
        controller.addProperty(prop);
    }


    public int valueValidation(String value)
    {
        int val;
        val = 0;
        if ( !(value.equals("")) && value != null )
        {
            val =  stringToInt(value);
        }

        return val;
    }

    // Convert String to an integer value
    public int stringToInt(String value)
    {
        Integer integerVal = new Integer(value);
        int val = integerVal.intValue();

        return val;

    }



}
