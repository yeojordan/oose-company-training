package controller.reading;

import controller.*;
import model.*;
import model.exceptions.*;

import java.util.*;
import java.io.*;

public class ReadProperty extends FileReading
{

    private PropertyController controller;

    public ReadProperty(PropertyController controller)
    {
        this.controller = controller;
    }

    public void processLine(String[] line) throws FileFormatException
    {
        Property prop   =   null;
        String name     =   line[0];
        char type       =   line[1].charAt(0);
        String owner    =   line[2];
        double worth = 0.0;
        double revenue = 0.0;
        double wages = 0.0;


        Map<String, Property> properties;
        properties = this.controller.getProperties();


        // Check the worth of a property is valid
        try
        {
            if (line[3] == null)
                System.out.println("DOGGO 1");
            worth = Double.parseDouble(line[3]);
        }
        catch(NumberFormatException e)
        {
            throw new PropertyException("Invalid Number Format");
        }

        // Check the property name is unique
        if (properties.containsKey(name))
        {
            throw new PropertyException("Property Name must be unique");
        }

        // Create Company or Business Unit
        // If entry is a Company
        if ( type == 'C' )
        {
            if ( !line[4].equals("") || !line[5].equals("") )
            {
                throw new PropertyException("Invalid Property File");
            }
            prop = new Company();

        }
        // If entry is a Business Unit
        else if ( type == 'B' )
        {
            // Check the revenue and wages are valid if it is a Business Unit
            try
            {
                if (line[4] == null)
                    System.out.println("DOGGO 2");

                if (line[5] == null)
                    System.out.println("DOGGO 3");

                revenue = Double.parseDouble(line[4]);
                wages   = Double.parseDouble(line[5]);
            }
            catch(NumberFormatException e)
            {
                throw new PropertyException("Invalid Number Format");
            }

            prop = new BusinessUnit(revenue, wages);
        }
        else
        {
            throw new PropertyException("Invalid Property Type");
        }


        // Set common class fields
        prop.setName(name);
        prop.setOwner(owner);
        prop.setMonetaryValue(worth);



        // properties = this.controller.getProperties();

        // Check if a property's owner is in the simulation
        if( properties.containsKey(owner) || owner.equals("") )
        {
            Company ow = (Company)(properties.get(owner));

            if (ow != null)
            {
                ow.addProperty(prop);
            }

        }
        else
        {
            throw new PropertyException("Owner must be listed before properties it owns ");
        }


        if ( prop instanceof BusinessUnit )
        {
            this.controller.addObserver((BusinessUnit)prop);
        }

        this.controller.addProperty(prop);

    }

    //
    // public double valueValidation(String value)
    // {
    //     double val;
    //     val = 0;
    //     if ( !(value.equals("")) && value != null )
    //     {
    //         val =  Double.parseDouble(value);
    //     }
    //
    //     return val;
    // }


}
