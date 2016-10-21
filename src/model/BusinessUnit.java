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
            //System.out.println("Name:" + this.getName() + "\n" + "Increased Wages: " + wages + "\n");
        //
        // else
        // {
        //     this.wages = this.wages * 0.95;
        //     System.out.println("Name:" + this.getName() + "\n" + "Decreased Wages: " + wages + "\n");
        // }
    }

    // public void updateRevenue(boolean increaseRev)
    // {
    //     if (increaseRev)
    //     {
    //         this.revenue = this.revenue * 1.05;
    //         System.out.println("Name:" + this.getName() + "\n" + "Increased Revenue: " + revenue + "\n");
    //     }
    //     else
    //     {
    //         this.revenue = this.revenue * 0.95;
    //         System.out.println("Name:" + this.getName() + "\n" + "Decreased Revenue: " + revenue + "\n");
    //     }
    // }

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
