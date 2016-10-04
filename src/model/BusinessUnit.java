package model;

public class BusinessUnit extends Property
{
    private int revenue;
    private int wages;

    public BusinessUnit(int rev, int wages)
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
