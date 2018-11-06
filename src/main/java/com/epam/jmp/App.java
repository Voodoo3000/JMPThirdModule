package com.epam.jmp;

import com.epam.jmp.author.Author;
import com.epam.jmp.book.Book;
import com.epam.jmp.supplier.InstanceSupplier;
import com.epam.jmp.list.PersonGroup;
import com.epam.jmp.predicater.Predicator;
import com.epam.jmp.operation.Sorter;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class);

    public static void main(String[] args) {

        PersonGroup personGroup = new PersonGroup();
        InstanceSupplier supplier = new InstanceSupplier();
        Sorter sorter = new Sorter();
        Predicator predicator = new Predicator();

        /*
        * Creates "personalData" map with name and age data for person
        * Uses biConsumer to put personal data to the personalData map
        */
        Map<String, Integer> personalData = new HashMap<>();
        BiConsumer<String, Integer> con = personalData::put;
        con.accept("Osama", 54);
        con.accept("Alice", 2);
        con.accept("Bruce", 79);
        con.accept("Siri", 11);
        con.accept("Carlos", 72);

        /*
        * Sends personal data to InstanceSupplier for creating person while
        * iterating on the personalData map and puts new persons to list of person
        */
        for (Map.Entry<String, Integer> integerStringEntry : personalData.entrySet()) {
            personGroup.addPersonToGroup(supplier.getNewPerson(integerStringEntry.getKey(), integerStringEntry.getValue()));
        }
        /*
        * Sorts by name and age
        */
        sorter.sortByAge(personGroup.getGroupOfPerson());
        sorter.sortByName(personGroup.getGroupOfPerson());
        /*
        * Checking for adult person
        */
        predicator.isAdult(personGroup.getGroupOfPerson());

        /*
        * Creating of authors and their books
        */
        Author author1 = supplier.getNewAuthor("Carlos Castaneda", 72);
        Book book1 = supplier.getNewBook("The Teachings of Don Juan: A Yaqui Way of Knowledge", author1 , 196);
        author1.getBooks().add(book1);
        Book book2 = supplier.getNewBook("A Separate Reality", author1, 272);
        author1.getBooks().add(book2);
        Book book3 = supplier.getNewBook("Journey to Ixtlan", author1, 268);
        author1.getBooks().add(book3);
        Author author2 = supplier.getNewAuthor("Stephen King", 71);
        Book book4 = supplier.getNewBook("It", author2, 1138);
        author2.getBooks().add(book4);
        Book book5 = supplier.getNewBook("The Shining", author2, 447);
        author2.getBooks().add(book5);
        Book book6 = supplier.getNewBook("Pet Sematary", author2, 373);
        author2.getBooks().add(book6);
        Book book7 = supplier.getNewBook("DreamCatcher", author2, 736);
        author2.getBooks().add(book7);
        Author author3 = supplier.getNewAuthor("Howard Lovecraft", 46);
        Book book8 = supplier.getNewBook("The Whisperer in Darkness", author3, 349);
        author3.getBooks().add(book8);
        Book book9 = supplier.getNewBook("The Colour Out of Space", author3, 491);
        author3.getBooks().add(book9);
        /*
        * Creating and filling the arrays
        */
        Author[]authors = new Author[]{author1, author2, author3};
        Book[]books = new Book[]{book1, book2, book3, book4, book5, book6, book7, book8, book9};

        LOGGER.info("\n-----Stream output section-----");

        /*
        * Checks if some/all book(s) have more than 400 pages
        */
        Arrays.stream(books)
                .forEach(book -> {if(book.getNumberOfPages() > 400)
                    LOGGER.info("Book " + book.getTitle() + " has more than 400 pages");});
        /*
         * Finds the books with max and min number of pages
         */
        LOGGER.info("Book with max pages: " + Arrays.stream(books)
                .max(Comparator.comparingDouble(Book::getNumberOfPages))
                .get().getTitle());
        LOGGER.info("Book with min pages: " + Arrays.stream(books)
                .min(Comparator.comparingDouble(Book::getNumberOfPages))
                .get().getTitle());
        /*
        * Filters books with only single author
        */
        Arrays.stream(books)
                .forEach(book -> {if(book.getAuthors().size() == 1)
                    LOGGER.info("Book with a single author: " + book.getTitle());});
        /*
        * Sorts the books by number of pages/title
        */
        LOGGER.info("\nSorted by quantity of pages:");
        LOGGER.info(Arrays.stream(books)
                .sorted(Comparator.comparingDouble(Book::getNumberOfPages))
                .collect(Collectors.toList()));
        LOGGER.info("\nSorted by titles:");
        LOGGER.info(Arrays.stream(books)
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList()));
        /*
        * Gets list of all titles and prints them using forEach
        */
        LOGGER.info("\nJust list of all titles:");
        Arrays.stream(books).forEach(book -> {
            LOGGER.info(book.getTitle());
        });
        /*
        * Gets distinct list of all authors
        */
        LOGGER.info("\nJust list of all authors:");
        Arrays.stream(authors).forEach(author -> {
            LOGGER.info(author.getName());
        });
    }
}
