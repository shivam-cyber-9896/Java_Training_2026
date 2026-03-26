package com.shivam.monocept.libary.model1.test;

import java.util.Scanner;

import com.shivam.monocept.libary.model1.AcademicBook;
import com.shivam.monocept.libary.model1.Library;
import com.shivam.monocept.libary.model1.Magazine;
import com.shivam.monocept.libary.model1.Book;


public class LibraryTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Library library = new Library();

		int choice;

		do {

			System.out.println("\n===== Library Menu =====");
			System.out.println("1. Add Academic Book");
			System.out.println("2. Add Magazine");
			System.out.println("3. Display All Books");
			System.out.println("4. Sort Books By Title");
			System.out.println("5. Request Issue Book");
			System.out.println("6. Process Issue");
			System.out.println("7. Remove Book");
			System.out.println("8. Exit");

			System.out.print("Enter choice: ");
			choice = scanner.nextInt();
             scanner.nextLine();
			switch (choice) {

			case 1:

				System.out.println("Enter Book ID:");
				String idInput = scanner.nextLine();

				while (idInput.trim().isBlank() || !idInput.matches("\\d+"))
				{
				    System.out.println("Invalid Book ID (Numbers only). Enter again:");
				    idInput = scanner.nextLine();
				}

				int id = Integer.parseInt(idInput);


				System.out.println("Enter Title:");
				String title = scanner.nextLine();

				while (title.trim().isBlank() || !title.matches("[A-Za-z ]+"))
				{
				    System.out.println("Invalid Title (Only letters allowed). Enter again:");
				    title = scanner.nextLine();
				}


				System.out.println("Enter Author:");
				String author = scanner.nextLine();

				while (author.trim().isBlank() || !author.matches("[A-Za-z ]+"))
				{
				    System.out.println("Invalid Author Name. Enter again:");
				    author = scanner.nextLine();
				}


				System.out.println("Enter Subject:");
				String subject = scanner.nextLine();

				while (subject.trim().isBlank() || !subject.matches("[A-Za-z ]+"))
				{
				    System.out.println("Invalid Subject. Enter again:");
				    subject = scanner.nextLine();
				}

				library.addBook(new AcademicBook(id, title, author, subject));

				break;


				case 2:

				System.out.println("Enter Book ID:");
				String idInput1 = scanner.nextLine();

				while (idInput1.trim().isBlank() || !idInput1.matches("\\d+"))
				{
				    System.out.println("Invalid Book ID (Numbers only). Enter again:");
				    idInput1 = scanner.nextLine();
				}

				int id1 = Integer.parseInt(idInput1);


				System.out.println("Enter Title:");
				String mtitle = scanner.nextLine();

				while (mtitle.trim().isBlank() || !mtitle.matches("[A-Za-z ]+"))
				{
				    System.out.println("Invalid Title. Enter again:");
				    mtitle = scanner.nextLine();
				}


				System.out.println("Enter Author:");
				String mauthor = scanner.nextLine();

				while (mauthor.trim().isBlank() || !mauthor.matches("[A-Za-z ]+"))
				{
				    System.out.println("Invalid Author Name. Enter again:");
				    mauthor = scanner.nextLine();
				}


				System.out.println("Enter Issue Number:");
				String issueNo = scanner.nextLine();

				while (issueNo.trim().isBlank() || !issueNo.matches("\\d+"))
				{
				    System.out.println("Invalid Issue Number (Numbers only). Enter again:");
				    issueNo = scanner.nextLine();
				}

				int issue = Integer.parseInt(issueNo);

				library.addBook(new Magazine(id1, mtitle, mauthor, issue));

				break;

			case 3:

				library.displayBooks();
				break;

			case 4:

				library.sortByTitle();
				break;

			case 5:

				System.out.println("Enter Book ID to request:");
				String idInput2 = scanner.nextLine();

				while (idInput2.trim().isBlank() || !idInput2.matches("\\d+"))
				{
				    System.out.println("Invalid Book ID (Numbers only). Enter again:");
				    idInput = scanner.nextLine();
				}

				
				int rid = Integer.parseInt(idInput2);

				Book reqBook = new AcademicBook(rid, "Temp", "Temp", "Temp");
				library.requestIssue(reqBook);

				break;

			case 6:

				library.processIssue();
				break;

			case 7:

				System.out.println("Enter Book ID to remove:");
				String idInput3 = scanner.nextLine();

				while (idInput3.trim().isBlank() || !idInput3.matches("\\d+"))
				{
				    System.out.println("Invalid Book ID (Numbers only). Enter again:");
				    idInput = scanner.nextLine();
				}

				
				int removeId = Integer.parseInt(idInput3);

				library.removeBook(removeId);

				break;

			case 8:

				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid Choice");

			}

		} while (choice != 8);

		scanner.close();
	}
}
