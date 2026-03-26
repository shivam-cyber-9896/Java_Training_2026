package com.shivam.monocept.libary.model1;

public class Magazine extends Book {

    private int issueNumber;

    public Magazine(int id, String title, String author, int issueNumber) {
        super(id, title, author);
        this.issueNumber = issueNumber;
    }

    @Override
    public String toString() {
        return "Magazine -> " + super.toString() + " Issue: " + issueNumber;
    }
}