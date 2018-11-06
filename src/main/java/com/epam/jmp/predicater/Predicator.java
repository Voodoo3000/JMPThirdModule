package com.epam.jmp.predicater;

import com.epam.jmp.output.Printer;
import com.epam.jmp.entity.Person;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.function.Predicate;

public class Predicator {
    private static final Logger LOGGER = Logger.getLogger(Printer.class);
    private Printer printer = new Printer();

    /*
    * Checks if person is adult
    */
    public void isAdult(List<Person> personList) {
        LOGGER.info("\n-----Checking for adult age-----");
        Predicate<Person> predicate = person -> person.getAge() >= 21;
        for (Person p : personList) {
            printer.printAdultPerson(predicate.test(p), p);
        }
    }
}
