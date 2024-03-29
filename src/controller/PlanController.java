/**
* @Author: Jordan Yeo
* @Date:   21/10/2016
* @Project: OOSE Assignment SEM 2 2016
* @Last modified by:   Jordan Yeo
* @Last modified time: 24/10/2016
* @Purpose: Handles performing plans and addition of plans
*/


package controller;

import java.util.*;

import model.*;
import controller.plans.*;
import model.exceptions.*;

public class PlanController
{
    private List<Plan> planList;

    /**
     * Constructor for PlanController
     */
    public PlanController()
    {
        this.planList = new LinkedList<Plan>();
    }

    /**
     * Retrieve the list of plans
     * @return List of Plans in the PlanController
     */
    public List<Plan> getPlans()
    {
        return this.planList;
    }

    /**
     * Add a plan to the
     * @param plan [description]
     */
    public void addPlan(Plan plan) throws PlanException
    {
        /* Validates the newest plan to be added is in chronological order */
        if(planList.size() > 0)
        {
            Plan prevPlan = planList.get(planList.size() - 1);
            if ( plan.getYear() < prevPlan.getYear() || prevPlan == null )
            {
                throw new PlanException("Plans must be listed in chronological order");
            }
        }

        this.planList.add(plan);
    }

    /**
     * Handle an planbased on a given year of a simulation
     * @param  year                 The current year of the simulation
     * @param  propertyController   The property administrator
     */
    public void handlePlan(int year, PropertyController propertyController) throws FileFormatException
    {
        // Instantiate an iterator for plans
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
