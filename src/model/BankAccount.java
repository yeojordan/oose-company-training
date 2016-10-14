package model;

public class BankAccount extends Property
{
    private Company owner;

    public BankAccount()
    {
        super();
        owner = null;

    }

    public void setValue(double monetaryValue)
    {
        super.setMonetaryValue(monetaryValue);
    }


    public void getProfit()
    {
        double newProfit;
        // Calculate profit
        newProfit = this.getMonetaryValue() * 0.05;
        // Store profit
        //super.setProfit(profit);
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


    
    /*
        Balance > 0 : Profit = Balance * 0.05
        Balance <= 0: Profit = Balance * 0.05
    */
    public void calculateProfit()
    {
        double profit;
        double balance = super.getMonetaryValue();
        profit = balance * 0.05;

        setProfit(profit);
    }


}
