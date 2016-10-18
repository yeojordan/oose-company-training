package controller.factories;

import model.*;
import controller.plans.*;

public class PlanFactory
{
    public Plan createPlan(char type)
    {
        Plan plan;
        if ( type == 'B' )
        {
            plan = new Buy();
        }
        else if( type == 'S' )
        {
            plan = new Sell();
        }
        else
        {
            throw new IllegalArgumentException("Invalid Plan Type");
        }

        return plan;
    }
}
