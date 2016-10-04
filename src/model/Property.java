package model;

import java.util.*;

public abstract class Property
{
    private int monetaryValue;
    private int profit;

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

    public void setMonetaryValue(int value)
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

    public int getMonetaryValue()
    {
        return this.monetaryValue;
    }

}