package controller;

import java.util.*;

import model.*;
import controller.plans.*;

public class PlanController
{
    private List<Plan> planList;

    public PlanController()
    {
        this.planList = new LinkedList<Plan>();
    }

    public List<Plan> getPlans()
    {
        return this.planList;
    }

    public void addPlan(Plan plan)
    {
        this.planList.add(plan);
    }

    /*
        1. Get a year
        2. Create an iterator
        3. Retrieve event
        4. Check the year matches
        5. Remove event
        6. retrieve next event
        7. If event doesn't match DONT REMOVE from list

    */
    public void handlePlan(int year,PropertyController propertyController)
    {
        Iterator<Plan> planIterator = this.planList.iterator();
        Plan plan = null;

        // If there are more plans
        if (planIterator.hasNext() )
        {
            // Retrieve next plan
            plan = planIterator.next();

            // Check the plan matches the year
            while ( plan != null && plan.getYear() == year)
            {
                // Remove the plan from the list
                planIterator.remove();

                // Perform the event
                plan.performPlan(propertyController.getProperties(), propertyController.getPrimaryCompany());

                // Check if there are any more plans in the list
                plan = null;
                if (planIterator.hasNext() )
                {
                    // Retrieve the next iterator
                    plan = planIterator.next();
                }
                
            }

        }


    }
}
