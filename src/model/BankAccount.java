package model;

public class BankAccount extends Property
{
    private Company owner;

    public BankAccount()
    {
        owner = null;
        super();
    }

    public void setValue(double monetaryValue)
    {
        super.setMonetaryValue(monetaryValue);
    }

    public void getProfit(double profit)
    {

        // Calculate profit

        // Store profit
        super.setProfit(profit);
    }

    // public int getValue()
    // {
    //     return this.monetaryValue;
    // }
    //
    // public int getProfit()
    // {
    //     return this.profit;
    // }
    //
    // public String toString()
    // {
    //     String toString = "Balance :" + this.monetaryValue + "\n" + "Profit: "
    //     + this.profit;
    //
    //     return toString;
    // }

}
