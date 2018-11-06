package com.epam.jmp.output;

import com.epam.jmp.entity.Person;
import org.apache.log4j.Logger;

public class Printer {
    private static final Logger LOGGER = Logger.getLogger(Printer.class);

    public void printPersonComparison(Person p) {
        LOGGER.info(p);
    }

    public void printAdultPerson(boolean adult, Person p) {
        if (adult) LOGGER.info(p.getName() + " is adult person");
    }
}
