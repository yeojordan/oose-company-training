package model;

import java.util.*;

public abstract class Property
{
    private double monetaryValue;
    private double profit;

    private String name;
    private String owner;

    public Property()
    {
        this.monetaryValue = 0;
        this.profit = 0;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public void setMonetaryValue(double value)
    {
        this.monetaryValue = value;
    }

    public String toString()
    {
        String toString = "";
        toString = toString + "Name:    " + this.name + "\n";
        toString = toString + "Owner:   " + this.owner + "\n";
        toString = toString + "Worth:   " + this.monetaryValue + "\n";

        return toString;
    }

    public String getName()
    {
        return this.name;
    }

    public String getOwner()
    {
        return this.owner;
    }

    public double getMonetaryValue()
    {
        return this.monetaryValue;
    }

    public void updateValue(boolean increaseVal)
    {

        if (increaseVal)
        {
            this.monetaryValue = this.monetaryValue * 1.05;
            System.out.println("Name:" + this.name + "\n" + "Increased Value: " + this.monetaryValue + "\n");
        }
        else
        {
            this.monetaryValue = this.monetaryValue * 0.95;
            System.out.println("Name:" + this.name + "\n" + "Decreased Value: " + this.monetaryValue + "\n");
        }

    }

    abstract void calculateProfit();

    public double getProfit()
    {
        //stub
        return 0.0;
    }

    public void setProfit(double profit)
    {
        this.profit = profit;
    }
}
