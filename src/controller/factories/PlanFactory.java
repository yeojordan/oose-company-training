package controller.factories;

import model.*;
import controller.plans.*;
import controller.*;
public class PlanFactory
{
    private PropertyController propertyController;

    public PlanFactory(PropertyController propertyController)
    {
        this.propertyController = propertyController;
    }

    public Plan createPlan(String[] line) throws IllegalArgumentException
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
                throw new IllegalArgumentException("Invalid Plan Type");
        }

        plan.setYear(year);
        plan.setProperty(property);
        return plan;
    }


    public void validateProperty(String property)
    {
        if ( !(propertyController.getProperties().containsKey(property)) )
        {
            throw new IllegalArgumentException("Buy/Sell Plan must have a valid property");
        }
    }

}
