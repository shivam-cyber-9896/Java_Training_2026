package com.shivam.monocept.libary.model1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
	static List<Book> books;

	static {
	    books = new ArrayList<>();

	    books.add(new Book(1, "Java Basics", "Shivam", "Programming", true, 500));
	    books.add(new Book(2, "Python Guide", "Rahul", "Programming", false, 700));
	    books.add(new Book(3, "Data Structures", "Amit", "Education", true, 900));
	    books.add(new Book(4, "Algorithms", "Shivam", "Education", true, 1200));
	    books.add(new Book(5, "Fiction Story", "Neha", "Fiction", false, 300));
	}
	

    public  static List<Book> getList(){return books;}
    public static List<Book> input() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter Book Details");

        int bookId = getValidInt(scanner, "Book ID: ");
        String title = getValidTitle(scanner);
        String author = getValidAuthor(scanner);
        String genre = getValidGenre(scanner);
        boolean available = getValidBoolean(scanner);
        double price = getValidPrice(scanner);

        books.add(new Book(bookId, title, author, genre, available, price));

        return books;
    }

    
    
    private static int getValidInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();

            if (input.matches("\\d+")) {
                return Integer.parseInt(input);
            }

            System.out.println("Invalid input! Enter numbers only.");
        }
    }

    
    private static String getValidTitle(Scanner scanner) {
        while (true) {
            System.out.print("Title: ");
            String title = scanner.nextLine().trim();

            if (!title.isEmpty()) {
                return title;
            }

            System.out.println("Title cannot be empty!");
        }
    }

   
    private static String getValidAuthor(Scanner scanner) {
        while (true) {
            System.out.print("Author: ");
            String author = scanner.nextLine().trim();

            if (author.matches("[A-Za-z ]+")) {
                return author;
            }

            System.out.println("Invalid author! Only letters allowed.");
        }
    }

    
    private static String getValidGenre(Scanner scanner) {
        while (true) {
            System.out.print("Genre: ");
            String genre = scanner.nextLine().trim();

            if (genre.matches("[A-Za-z ]+")) {
                return genre;
            }

            System.out.println("Invalid genre! Only letters allowed.");
        }
    }

    
    private static boolean getValidBoolean(Scanner scanner) {
        while (true) {
            System.out.print("Available (true/false): ");
            String input = scanner.nextLine().toLowerCase();

            if (input.matches("true|false")) {
                return Boolean.parseBoolean(input);
            }

            System.out.println("Invalid input! Enter true or false.");
        }
    }

  
    private static double getValidPrice(Scanner scanner) {
        while (true) {
            System.out.print("Price: ");
            String input = scanner.nextLine();

            if (input.matches("\\d+(\\.\\d+)?")) {
                double price = Double.parseDouble(input);

                if (price > 0) {
                    return price;
                }
            }

            System.out.println("Invalid price! Enter positive number.");
        }
    }
}
