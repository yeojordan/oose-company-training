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
        this.worth =  Integer (val.valueOf(params[3])).value;
        this.revenue = params[4];
        this.wages =   params[5];
    }

    public void printEntry()
    {
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Owner: " + owner);
        System.out.println("Worth: " + worth);
        System.out.println("Revenue: " + revenue);
        System.out.println("Wages  " + wages);

    }
}
