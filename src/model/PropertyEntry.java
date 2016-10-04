package model;

public class PropertyEntry
{
    private String name;
    private char type;
    private String owner;
    private int worth;
    private int revenue;
    private int wages;

    public PropertyEntry(String name, char type, String owner, int worth, int revenue, int wages)
    {
        this.name = name;
        this.type = type;
        this.owner =  owner;
        this.worth =  worth;
        this.revenue = revenue;
        this.wages =   wages;
    }

    public PropertyEntry(String[] params)
    {
        this.name = params[0];
        this.type = params[1].charAt(0);
        this.owner =  params[2];
        this.worth = valueValidation(params[3]);
        this.revenue = valueValidation(params[4]);
        this.wages = valueValidation(params[5]);
    }


    public int valueValidation(String value)
    {
        int val;
        val = 0;
        if ( !(value.equals("")) && value != null )
        {
            val =  stringToInt(value);
        }

        return val;
    }


    // Convert String to an integer value
    public int stringToInt(String value)
    {
        Integer integerVal = new Integer(value);
        int val = integerVal.intValue();

        return val;

    }

    public void printEntry()
    {
        System.out.println("Name:    " + name);
        System.out.println("Type:    " + type);
        System.out.println("Owner:   " + owner);
        System.out.println("Worth:   " + worth);
        System.out.println("Revenue: " + revenue);
        System.out.println("Wages    " + wages + "\n");

    }
}
