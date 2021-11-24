package com.colections;

import java.util.Comparator;

public class Person implements Comparable<Person>
{

    public Person(String name, String lastName)    //konstruktor klasy Person
    {
        this.name=name;
        this.lastName = lastName;
    }

    private String lastName;          //pola klasy Person
    private String name;

    public String getLastName()     //getter pola lastName
    {
        return lastName;
    }

    public String getName()         //getter pola name
    {
        return name;
    }

    @Override
    public String toString()                //nadpisanie metody toString
    {
        return "imie: " + name + ", nazwisko: " + lastName;
    }

    @Override
    public int compareTo(Person o)           //nadpisanie metody CompareTo
    {
        if (this.equals(o))
            return 0;

        if (this.lastName.compareTo(o.lastName) >= 0)
            return 1;

        else return -1;
    }

    public static final Comparator<Person> comparatorLastName = new Comparator<Person>()
    {
        @Override                                 //nadpisanie metody compare
        public int compare(Person o1, Person o2)
        {
            return o1.getLastName().compareTo(o2.getLastName());
        }
    };
}
