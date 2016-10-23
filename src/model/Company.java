package model;

import java.util.*;
import java.text.*;

public class Company extends Property
{
    private Map<String, Property> owns;
    private BankAccount bank;

    /**
     * Default Constructor for Company
     */
    public Company()
    {
        bank = new BankAccount();
        owns = new HashMap<String, Property>();
    }

    /**
     * Retrieve the state of the Company
     * @return String   The state of the Company as a String
     */
    public String toString()
    {
        DecimalFormat df = new DecimalFormat("0.00");
        String toString = super.toString();
        toString = toString + "Bank Balance: " + df.format(bank.getMonetaryValue()) + "\n";
        return toString;
    }

    /**
     * Add a property to the map of properties the Company owns
     * @param property  Property to be added
     */
    public void addProperty(Property property)
    {
        String name = null;

        name = property.getName();

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

    /**
     * [calculateProfit description]
     */
    public void calculateProfit()
    {
        double totalProfit = 0.0;

        //  bank.calculateProfit();

        if (owns != null)
        {


            for ( Property owned : owns.values() )
            {

                owned.calculateProfit();

                totalProfit += owned.getProfit();
            }

        }

       // If sum of profit of what company owns <= 0
        if (totalProfit <= 0.0)
        {
            bank.setValue(totalProfit);

        }
        // If the profit > 0
        else
        {
            // Update company's bank account
            bank.setValue(totalProfit*0.5);
        }

        /* Calculate interest on the bank balance */
        bank.calculateProfit();

    }

    /**
     * Check if the property is currently owned by the Company
     * @param  property     Property to check ownership of
     * @return True or False depending on if the company is in
     * possession of the property
     */
    public boolean checkOwnership(String property)
    {
        return owns.containsKey(property);
    }

    /**
     * Remove the property from the ownership of the Company
     * @param property      Propery to be removed
     */
    public void removeProperty(Property property)
    {

        String propertyName = property.getName();
        /* Check if the property is currently owned by the company */
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

    /**
     * Update the bank account balance of the Company
     * @param value     Value to add to the bank balance
     */
    public void updateBank(double value)
    {
        bank.setValue(value);
    }

    /**
     * Calculate Interest on the BankAccount of the Company
     */
    public void calculateInterest()
    {
        bank.calculateProfit();
    }

    /**
     * Retreive the bank balance of the Company's BankAccount
     * @return [description]
     */
    public double getBankBalance()
    {
        return bank.getMonetaryValue();
    }


}
