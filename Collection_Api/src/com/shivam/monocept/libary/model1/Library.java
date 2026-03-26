package com.shivam.monocept.libary.model1;



import java.util.*;


public class Library {

    private Set<Book> books = new HashSet<>();
    private Queue<Book> issueQueue = new LinkedList<>();

    public void addBook(Book book) {
        if (books.add(book)) {
            System.out.println("Book added successfully");
            return;
        } 
            System.out.println("Duplicate Book Not Allowed");
        
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void sortByTitle() {

        List<Book> list = new ArrayList<>(books);

        Collections.sort(list, new Comparator<Book>() {

            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareTo(b2.getTitle());
            }
        });

        for (Book b : list) {
            System.out.println(b);
        }
    }

    public void requestIssue(Book book) {
        issueQueue.offer(book);
        System.out.println("Book added to issue queue");
    }

    public void processIssue() {

        Book book = issueQueue.poll();

        if (book != null)
            System.out.println("Issued Book: " + book);
        else
            System.out.println("No request in queue");
    }

    public void removeBook(int id) {

        Iterator<Book> itr = books.iterator();

        while (itr.hasNext()) {
            Book b = itr.next();

            if (b.getBookId() == id) {
                itr.remove();
                System.out.println("Book Removed");
            }
        }
    }
}