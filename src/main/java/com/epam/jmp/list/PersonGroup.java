package com.epam.jmp.list;

import com.epam.jmp.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonGroup {

    private List<Person> groupOfPerson = new ArrayList<>();

    public List<Person> getGroupOfPerson() {
        return groupOfPerson;
    }

    public void setGroupOfPerson(List<Person> groupOfPerson) {
        this.groupOfPerson = groupOfPerson;
    }

    public void addPersonToGroup(Person person) {
        this.groupOfPerson.add(person);
    }
}
