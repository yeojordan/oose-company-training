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
        toString = toString + "Bank Balance: " + bank.getMonetaryValue() + "\n";
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

        System.out.println("Company Name: " + getName() +"\nBank Balance before interest "); //+ bank.getMonetaryValue() + "\n\n");
        System.out.printf("%f\n\n", bank.getMonetaryValue() );




        bank.calculateProfit();
        System.out.println("Company Name: " + getName() +"\nBank Balance after interest "); //+ bank.getMonetaryValue() + "\n\n");

        System.out.printf("%f\n\n", bank.getMonetaryValue() );
        if (owns != null)
        {

            for ( Property owned : owns.values() )
            {
                owned.calculateProfit();
                totalProfit += owned.getProfit();
            }
        }

        System.out.println("Profit from owned properties: " + totalProfit +"\n\n");
        // If sum of profit of what company owns <= 0
        if (totalProfit <= 0.0)
        {
            bank.setValue(totalProfit);

        }
        // If the profit > 0
        else
        {
            // Update company's profit
            setProfit(totalProfit*0.5);

            // Update company's bank account
            bank.setValue(totalProfit*0.5);
        }

    }

    public boolean checkOwnership(String property)
    {
        return owns.containsKey(property);
    }


    public void removeProperty(Property property)
    {
        String propertyName = property.getName();
        if( checkOwnership(propertyName) )
        {
            owns.remove(propertyName);
        }

        // Check if the property was removed correctly.
        if( owns.containsKey(propertyName))
        {
            throw new IllegalStateException("Property not removed from ownership");
        }
    }

    public void updateBank(double value)
    {
        bank.setValue(value);
    }

    public void calculateInterest()
    {
        bank.calculateProfit();
    }

    public double getBankBalance()
    {

        return bank.getMonetaryValue();
    }
}
