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
}
