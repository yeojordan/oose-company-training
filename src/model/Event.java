package model;


public class Event //implements Iterable
{
    private int year;
    private String event;
    private String property;

    public Event(int year, String event, String property)
    {
        this.year = year;
        this.event = event;
        this.property = property;
    }

    public String toString()
    {
        String toString = "";
        toString = toString + "Year:      " + year + "\n";
        toString = toString + "Event:     " + event + "\n";
        toString = toString + "Property:  " + property + "\n";

        return toString;
    }

    public int getYear()
    {
        return this.year;
    }

    public String getEvent()
    {
        return this.event;
    }

    public String getProperty()
    {
        return this.property;
    }

}
