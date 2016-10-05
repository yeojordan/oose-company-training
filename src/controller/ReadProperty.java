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
        Property prop   = null;
        String name     = line[0];
        char type       = line[1].charAt(0);
        String owner    = line[2];
        double worth    = valueValidation(line[3]);
        double revenue  = valueValidation(line[4]);
        double wages    = valueValidation(line[5]);

        // If entry is a Company
        if ( type == 'C' )
        {
            if ( !line[4].equals("") || !line[5].equals("") )
            {
                throw new IllegalArgumentException("Invalid Property File");
            }
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


    public double valueValidation(String value)
    {
        double val;
        val = 0;
        if ( !(value.equals("")) && value != null )
        {
            val =  Double.parseDouble(value);
        }

        return val;
    }


}
