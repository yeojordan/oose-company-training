package model;

import controller.observer.WageObserver;

public class BusinessUnit extends Property implements WageObserver
{
    private double revenue;
    private double wages;

    public BusinessUnit(double rev, double wages)
    {
        this.revenue = rev;
        this.wages = wages;
    }


    public String toString()
    {
        String toString = super.toString();
        toString = toString + "Revenue: " + this.revenue + "\n";
        toString = toString + "Wages:   " + this.wages + "\n";
        return toString;
    }

    public double getWages()
    {
        return wages;
    }

    public double getRevenue()
    {
        return this.revenue;
    }

    public void setWages(double wages)
    {
        this.wages = wages;
    }

    public void setRevenue(double revenue)
    {
        this.revenue = revenue;
    }

    public void update(double multiplier)
    {
        this.wages *= multiplier;

    }

    /*
        Profit = Revenue - Wages
    */
    public void calculateProfit()
    {
        double profit = 0.0;

        profit = this.revenue - this.wages;
        System.out.println("Revenue " + this.revenue + "Wages " + this.wages );
        System.out.println("BU Profit: " + profit);

        super.setProfit(profit);
    }


}
