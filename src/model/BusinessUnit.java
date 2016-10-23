package model;

import controller.observer.WageObserver;

public class BusinessUnit extends Property implements WageObserver
{
    private double revenue;
    private double wages;

    /**
     * Default Constructor for a BusinessUnit
     * @param   rev     Initial revenue for the BusinessUnit
     * @param   wages   Initial wages for the BusinessUnit
     */
    public BusinessUnit(double rev, double wages)
    {
        this.revenue = rev;
        this.wages = wages;
    }


    /**
     * Retrieve the state of the BusinessUnit
     * @return String   The state of the BusinessUnit as a String
     */
    public String toString()
    {
        String toString = super.toString();
        toString = toString + "Revenue: " + this.revenue + "\n";
        toString = toString + "Wages:   " + this.wages + "\n";
        return toString;
    }

    /**
     * Retrive the wages of the BusinessUnit
     * @return wages    The wages of the BusinessUnit
     */
    public double getWages()
    {
        return wages;
    }

    /**
     * Retrive the revnue of the BusinessUnit
     * @return reveneu    The revenue of the BusinessUnit
     */
    public double getRevenue()
    {
        return this.revenue;
    }

    /**
     * Set the wages of the BusinessUnit
     * @param wages     Wages of the BusinessUnit
     */
    public void setWages(double wages)
    {
        this.wages = wages;
    }

    /**
     * Set the revenue of the BusinessUnit
     * @param revenue     Revenue of the BusinessUnit
     */
    public void setRevenue(double revenue)
    {
        this.revenue = revenue;
    }

    /**
     * WageObserver method to be implemented
     * @param multiplier    Multiplier for wages
     */
    public void update(double multiplier)
    {
        this.wages *= multiplier;

    }

    /**
     * Calculate the profit of the BusinessUnit
     */
    public void calculateProfit()
    {
        double profit = 0.0;

        profit = this.revenue - this.wages;
    
        super.setProfit(profit);
    }


}
