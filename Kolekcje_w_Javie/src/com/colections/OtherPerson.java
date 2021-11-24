package com.colections;

import java.util.Objects;

public class OtherPerson extends com.colections.Person
{
    public OtherPerson(String name, String lastName)    //konstruktor klasy OtherPerson
    {
        super(name, lastName);
    }


    @Override
    public boolean equals(Object o)             //nadpisanie metody equals
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.colections.Person person = (com.colections.Person) o;
        return Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getName(), person.getName());
    }

    @Override                  //nadpisanie metody hashCode
    public int hashCode() {
        return Objects.hash(getLastName(), getName());
    }
}

