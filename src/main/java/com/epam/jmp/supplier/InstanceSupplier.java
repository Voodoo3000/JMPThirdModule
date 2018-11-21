package com.epam.jmp.supplier;

import com.epam.jmp.entity.Author;
import com.epam.jmp.entity.Book;
import com.epam.jmp.entity.Person;

import java.util.function.Supplier;

/*
 * New instance supplier
 */
public class InstanceSupplier {

    /*
     * Returns new person created by supplier interface
     */
    public Person getNewPerson(String name, Integer age) {
        Supplier<Person> supplier = () -> new Person(name, age);
        return supplier.get();
    }

    /*
     * Returns new author created by supplier interface
     */
    public Author getNewAuthor(String name, Integer age) {
        Supplier<Author> supplier = () -> new Author(name, age);
        return supplier.get();
    }

    /*
     * Returns new book created by supplier interface
     */
    public Book getNewBook(String title, Author author, Integer numberOfPages) {
        Supplier<Book> supplier = () -> new Book(title, author, numberOfPages);
        return supplier.get();
    }
}
