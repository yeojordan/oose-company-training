package model;

import java.util.*;

public class Company extends Property
{
    private List<Property> owns;
    private BankAccount bank;


    public Company()
    {
        bank = new BankAccount();
        owns = new LinkedList<Property>();
    }

    public String toString()
    {
        String toString = super.toString();

        return toString;
    }
}
