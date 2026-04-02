package com.shivam.monocept.libary.test;

import java.util.*;
import java.util.stream.Collectors;

import com.shivam.monocept.libary.model1.Book;
import com.shivam.monocept.libary.model1.Input;



public class BookTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Book> books=Input.getList();

        while (true) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Adding Books");
            System.out.println("2. Get All Available Books");
            System.out.println("3. Group Books by Genre");
            System.out.println("4. Count Books Genre-wise");
            System.out.println("5. Most Expensive Book");
            System.out.println("6. Sorted Titles by Price");
            System.out.println("7. Check Any Unavailable Book");
            System.out.println("8. Unique Authors");
            System.out.println("9. Add New Book");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            String input = scanner.nextLine();

            if (!input.matches("\\d+")) {
                System.out.println("Invalid input!");
                continue;
            }

            int choice = Integer.parseInt(input);

            switch (choice) {
            case 1:
            	books= Input.input(); 

            	break;
                case 2:
                    books.stream()
                            .filter(Book::isAvailable)
                            .forEach(System.out::println);
                    break;

                case 3:
                    Map<String, List<Book>> byGenre = books.stream()
                            .collect(Collectors.groupingBy(Book::getGenre));
                    byGenre.forEach((k, v) -> System.out.println(k + " -> " + v));
                    break;

                case 4:
                    Map<String, Long> count = books.stream()
                            .collect(Collectors.groupingBy(
                                    Book::getGenre,
                                    Collectors.counting()
                            ));
                    System.out.println(count);
                    break;

                case 5:
                    books.stream()
                            .max(Comparator.comparing(Book::getPrice))
                            .ifPresent(System.out::println);
                    break;

                case 6:
                    books.stream()
                            .sorted(Comparator.comparing(Book::getPrice))
                            .map(Book::getTitle)
                            .forEach(System.out::println);
                    break;

                case 7:
                    boolean hasUnavailable = books.stream()
                            .anyMatch(b -> !b.isAvailable());
                    System.out.println(hasUnavailable);
                    break;

                case 8:
                    Set<String> authors = books.stream()
                            .map(Book::getAuthor)
                            .collect(Collectors.toSet());
                    System.out.println(authors);
                    break;

                case 9:
                    books = Input.input(); // add new book
                    System.out.println("Book Added!");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}