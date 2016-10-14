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
        bank.setMonetaryValue(monetaryValue);
    }


    public void addProperty(Property property)
    {
        String name = null;

        // Check if the property is a Company or Business Unit before
        // adding it to the map of properties owned by the Company
        if (property instanceof Company )
        {
            name = ((Company)property).getName();

        }
        else if ( property instanceof BusinessUnit)
        {
            name = ((BusinessUnit)property).getName();
        }

        // Insert only if the current key is not already used.
        if ( !((this.owns).containsKey(name)) )
        {
            (this.owns).put(name, property);
        }

    }

    /*
        Profit is half of the profit from the properties the company owns
        If you don't own anything. Profit = 0.0
    */

    public void calculateProfit()
    {
        double totalProfit = 0.0;
        if (owns != null)
        {
            for ( Property owned : owns.values() )
            {
                owned.calculateProfit();
                totalProfit += owned.getProfit();
            }
        }

        // If sum of profit of what company owns < 0
        if (totalProfit <= 0.0)
        {
            totalProfit = 0.0;
        }

        // Update company's profit
        setProfit(totalProfit*0.5);

        // Update company's bank account
        bank.setValue(totalProfit*0.5);
    }



    public void buy(String property, )
    {
        
    }

    public void sell(String property)
    {

    }


}
