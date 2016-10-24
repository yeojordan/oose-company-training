package model;

import java.util.*;

public abstract class Property
{
    private double monetaryValue;
    private double profit;

    private String name;
    private String owner;

    /**
     * Constructor for Property
     */
    public Property()
    {
        this.monetaryValue = 0;
        this.profit = 0;
    }

    /**
     * Set the name of the Property
     * @param name   Name of the property
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Set the name of the owner of a property
     * @param owner   Name of the owner of a property
     */
    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    /**
     * Set the value of a property
     * @param value  Value of a property
     */
    public void setMonetaryValue(double value)
    {
        this.monetaryValue = value;
    }

    /**
     * Retrieve the state of the Property
     * @return String   A string representation of the state of the property
     */
    public String toString()
    {
        String toString = "";
        toString = toString + "Name:         " + this.name + "\n";
        toString = toString + "Owner:        " + this.owner + "\n";
        toString = toString + "Worth:        " + this.monetaryValue + "\n";

        return toString;
    }

    /**
     * Retrieve the name of the property
     * @return name     Name of the property
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Retrieve the name of the owner of the property
     * @return owner     Name of the property's owner
     */
    public String getOwner()
    {
        return this.owner;
    }

    /**
     * Retrieve the value of the property
     * @return monetaryValue    The value of the property
     */
    public double getMonetaryValue()
    {
        return this.monetaryValue;
    }

    /**
     * Abstract method to be overwritten by subclasses
     */
    public abstract void calculateProfit();


    /**
     * Retrieve the profit of the Property
     * @return profit   Property's profit
     */
    public double getProfit()
    {
        return this.profit;
    }

    /**
     * Set the profit of the Properyy
     * @param profit [description]
     */
    public void setProfit(double profit)
    {
        this.profit = profit;
    }
}
