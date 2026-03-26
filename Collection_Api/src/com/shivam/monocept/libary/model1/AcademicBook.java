package com.shivam.monocept.libary.model1;

public class AcademicBook extends Book {

    private String subject;

    public AcademicBook(int id, String title, String author, String subject) {
        super(id, title, author);
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "AcademicBook -> " + super.toString() + " Subject: " + subject;
    }
}