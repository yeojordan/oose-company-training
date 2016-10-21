package controller.reading;

import controller.*;
import model.*;

import java.util.*;
import java.io.*;

public class ReadProperty extends FileReading
{

    private PropertyController controller;

    public ReadProperty(PropertyController controller)
    {
        this.controller = controller;
    }

    public void processLine(String[] line)
    {
        Property prop   =   null;
        String name     =   line[0];
        char type       =   line[1].charAt(0);
        String owner    =   line[2];
        double worth    =   valueValidation(line[3]);
        double revenue  =   valueValidation(line[4]);
        double wages    =   valueValidation(line[5]);


        Map<String, Property> properties;
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

        properties = this.controller.getProperties();

        // Check if a property's owner is in the simulation
        if( properties.containsKey(owner) )
        {
            Company ow = (Company)(properties.get(owner));
            ow.addProperty(prop);
        }

        //properties.put(name, prop);
        if ( prop instanceof BusinessUnit )
        {
            this.controller.addObserver((BusinessUnit)prop);
        }

        this.controller.addProperty(prop);

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
