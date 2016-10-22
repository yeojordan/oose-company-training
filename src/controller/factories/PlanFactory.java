package controller.factories;

import model.*;
import model.exceptions.*;
import controller.plans.*;
import controller.*;

public class PlanFactory
{
    private PropertyController propertyController;

    public PlanFactory(PropertyController propertyController)
    {
        this.propertyController = propertyController;
    }

    public Plan createPlan(String[] line) throws PlanException
    {
        Plan plan;
        int year = Integer.parseInt(line[0]);
        char decision = line[1].charAt(0);
        String property = line[2];

        validateProperty(property);
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

        plan.setYear(year);
        plan.setProperty(property);
        return plan;
    }


    public void validateProperty(String property) throws BuySellException
    {
        if ( !(propertyController.getProperties().containsKey(property)) )
        {
            throw new BuySellException("Buy/Sell Plan must have a valid property");
        }
        else if ( property.equals(this.propertyController.getPrimaryCompany().getName()) )
        {
            throw new BuySellException("Primary Company cannot be bought or sold");
        }
    }

}
