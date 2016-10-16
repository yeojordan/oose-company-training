package controller.plans;

import model.*;

public interface PlanAction
{
    public void performPlan(Plan plan, Company primaryCompany);
}
