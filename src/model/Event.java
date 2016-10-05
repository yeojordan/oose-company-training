package model;

public class Event
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
        toString = toString + "Year:  " + year + "\n";
        toString = toString + "Event: " + event + "\n";
        toString = toString + "Year:  " + property + "\n";

        return toString;
    }

}
