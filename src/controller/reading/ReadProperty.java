/**
* @Author: Jordan Yeo
* @Date:   21/10/2016
* @Project: OOSE Assignment SEM 2 2016
* @Last modified by:   Jordan Yeo
* @Last modified time: 24/10/2016
* @Purpose: Handles the necessary parsing and delegation of creation of Properties
*/


package controller.reading;

import controller.*;
import model.*;
import model.exceptions.*;

import java.util.*;
import java.io.*;

public class ReadProperty extends FileReading
{

    private PropertyController controller;

    /**
     * Constructor to create ReadProperty, for processing a Property file
     * @param   controller  PropertyController to store properties
     */
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
        double worth;
        double revenue;
        double wages;


        Map<String, Property> properties;
        properties = this.controller.getProperties();


        // Check the worth of a property is valid
        try
        {
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
        if ( type == 'C' )
        {
            // Validate there is no value for revenue or wages
            if ( !line[4].equals("") || !line[5].equals("") )
            {
                throw new PropertyException("Invalid Property File");
            }
            prop = new Company();

        }
        else if ( type == 'B' )
        {
            // Check the revenue and wages are valid if it is a Business Unit
            try
            {
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
        if (owner.equals(""))
        {
            prop.setOwner("-");
        }

        prop.setMonetaryValue(worth);



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

        // Add the property to the list of WageObservers if it is a BusinessUnit
        if ( prop instanceof BusinessUnit )
        {
            this.controller.addObserver((BusinessUnit)prop);
        }

        // Add the property to the map of properties
        this.controller.addProperty(prop);

    }

}
