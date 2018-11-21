package com.epam.jmp.operation;

import com.epam.jmp.output.Printer;
import com.epam.jmp.entity.Person;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class Sorter {
    private static final Logger LOGGER = Logger.getLogger(Sorter.class);
    private Printer printer = new Printer();

    /*
    * Sorts list of person by name and then prints sorted list
    */
    public void sortByName(List<Person> persons) {
        LOGGER.info("\n-----Sorting by name-----");
        FunctionalComparator comparator = (p1, p2) -> p1.getName().compareTo(p2.getName());
        Collections.sort(persons, comparator);
        for (Person p : persons) {
            printer.printPersonComparison(p);
        }
    }

    /*
     * Sorts list of person by age and then prints sorted list
     */
    public void sortByAge(List<Person> persons) {
        LOGGER.info("\n-----Sorting by age-----");
        FunctionalComparator comparator = (p1, p2) -> p1.getAge().compareTo(p2.getAge());
        Collections.sort(persons, comparator);
        for (Person p : persons) {
            printer.printPersonComparison(p);
        }
    }
}
