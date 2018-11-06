package com.epam.jmp.operation;

import com.epam.jmp.entity.Person;

import java.util.Comparator;

@FunctionalInterface
public interface FunctionalComparator extends Comparator<Person> {
    int compare(Person p1, Person p2);
}
