package model;

public class BusinessUnit extends Property
{
    private double revenue;
    private double wages;

    public BusinessUnit(double rev, double wages)
    {
        this.revenue = rev;
        this.wages = wages;
    }


    public String toString()
    {
        String toString = super.toString();
        toString = toString + "Revenue: " + this.revenue + "\n";
        toString = toString + "Wages:   " + this.wages + "\n";
        return toString;
    }

}
