package model;

import java.util.*;

public class Company extends Property
{
    private Map<String, Property> owns;
    private BankAccount bank;


    public Company()
    {
        bank = new BankAccount();
        owns = new HashMap<String, Property>();
    }

    public String toString()
    {
        String toString = super.toString();
        return toString;
    }

    public void setBankValue(double monetaryValue, double profit)
    {
        bank.setMonetaryValue(monetaryValue)
    }





}
