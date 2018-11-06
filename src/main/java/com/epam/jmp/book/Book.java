package com.epam.jmp.book;

import com.epam.jmp.author.Author;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Author> authors = new ArrayList<>();
    private int numberOfPages;

    public Book(String title, Author author, int numberOfPages) {
        this.title = title;
        this.authors.add(author);
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
