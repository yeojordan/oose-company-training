package model;

public class Plan
{
    private int year;
    private char decision;
    private String property;

    public Plan(int year, char decision, String property)
    {
        this.year     = year;
        this.decision = decision;
        this.property = property;
    }

    public String toString()
    {
        String toString = "";
        toString = toString + "Year:     "+ year + "\n";
        toString = toString + "Buy/Sell: "+ decision + "\n";
        toString = toString + "Property: "+ property + "\n";

        return toString;
    }

    public int getYear()
    {
        return this.year;
    }

    public char getDecision()
    {
        return this.decision;
    }

    public String getProperty()
    {
        return this.property;
    }
    
}
