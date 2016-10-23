package controller.factories;

import model.*;
import model.exceptions.*;
import controller.plans.*;
import controller.*;

public class PlanCreator
{
    private PropertyController propertyController;

    /**
     * Default Constructor for the PlanCreator
     * @param  propertyController The property administrator
     */
    public PlanCreator(PropertyController propertyController)
    {
        this.propertyController = propertyController;
    }

    /**
     * Creates a Plan based on a String array containing parameters
     * @param  line Parameters of a Plan as Strings
     * @return Plan A plan created using the parameters passed in
     */
    public Plan createPlan(String[] line) throws PlanException
    {
        Plan plan;
        int year        = Integer.parseInt(line[0]);
        char decision   = line[1].charAt(0);
        String property = line[2];


        try
        {
            year = Integer.parseInt(line[0]);
        }
        catch(NumberFormatException e)
        {
            throw new PlanException("Invalid Number Format");
        }

        /* Validate the property is valid prior to creating a Plan */
        validateProperty(property);

        /* Create a subclaas of Plan depending on the type,
            an exception is thrown otherwise */
        switch (decision)
        {
            case 'B':
                plan = new Buy();
                break;
            case 'S':
                plan = new Sell();
                break;
            default:
                throw new PlanException("Invalid Plan Type");
        }

        /* Set remaining fields of a Plan subclass */
        plan.setYear(year);
        plan.setProperty(property);

        return plan;
    }

    /**
     * Validate the property name of a Plan is valid
     * @param property The property String to validate
     */
    public void validateProperty(String property) throws BuySellException
    {
        /* Validate if the property exists in the Simulation */
        if ( !(propertyController.getProperties().containsKey(property)) )
        {
            throw new BuySellException("Buy/Sell Plan must have a valid property");
        }
        /* Validate that the Primary Company cannot be bought or sold */
        else if ( property.equals(this.propertyController.getPrimaryCompany().getName()) )
        {
            throw new BuySellException("Primary Company cannot be bought or sold");
        }
    }

}
