package com.shivam.monocept.libary.model1;

public abstract class Book {

    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

   
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;

        Book other = (Book) obj;
        return this.bookId == other.bookId;
    }

    @Override
    public String toString() {
        return "ID: " + bookId + " Title: " + title + " Author: " + author;
    }
}