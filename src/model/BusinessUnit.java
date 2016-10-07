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

    public void updateWages(boolean increaseWages)
    {
        if (increaseWages)
        {
            this.wages = this.wages * 1.05;
            System.out.println("Name:" + this.getName() + "\n" + "Increased Wages: " + wages + "\n");
        }
        else
        {
            this.wages = this.wages * 0.95;
            System.out.println("Name:" + this.getName() + "\n" + "Decreased Wages: " + wages + "\n");
        }
    }

}
