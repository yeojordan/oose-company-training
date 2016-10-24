/**
* @Author: Jordan Yeo
* @Date:   16/10/2016
* @Project: OOSE Assignment SEM 2 2016
* @Last modified by:   jordanyeo
* @Last modified time: 24/10/2016
* @Purpose: Container for Bank Account
*/


package model;

public class BankAccount extends Property
{
    private Company owner;

    /**
     * Constructor for Bank Account
     */
    public BankAccount()
    {
        super();
        owner = null;

    }

    /**
     * Set the value of the bank account
     * @param monetaryValue Value to be added to bank account
     */
    public void setValue(double monetaryValue)
    {
        double previousVal = super.getMonetaryValue();
        super.setMonetaryValue(monetaryValue + previousVal);
    }

    /**
    * Calculate the interest (profit) of the bank account
    */
    public void calculateProfit()
    {
        double profit;
        double balance = super.getMonetaryValue();
        profit = balance * 0.05;

        setValue(profit);
    }


}
