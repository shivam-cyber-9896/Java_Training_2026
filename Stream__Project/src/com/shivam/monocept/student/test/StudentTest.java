package com.shivam.monocept.student.test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.shivam.monocept.student.model1.Input;
import com.shivam.monocept.student.model1.Student;

public class StudentTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Student> student = Input.addHardcodedStudents();
		int choice = 0;
		do {
			System.out.println("Student control Menu");
            System.out.println("1. Adding student");
            System.out.println("2. Passed Student");
            System.out.println("3. Top 3 Student");
            System.out.println("4. Sort By Section");
            System.out.println("5.  Count By Section");
            System.out.println("6.  Average Marks By Section");
            System.out.println("7.  Names All uperrCase");
            System.out.println("8.  Any Student Socred Full Marks ");
            System.out.println("9. System Exinting");
            

            while (true) {
                System.out.print("Enter your choice: ");
                String input = scanner.nextLine();

                if (input.matches("\\d+")) {
                    choice = Integer.parseInt(input);
                    break;
                }

                System.out.println("Invalid choice! Enter numbers only.");
            }
			switch (choice) {
			case 1:
				student=Input.input();
				break;
			case 2:
				System.out.println("Passed student");
				student.stream().filter(m -> m.getMarks() > 40).forEach(System.out::println);
				break;

			case 3:
				System.out.println("Top 3 Student");
				List<Student> top3 = student.stream().sorted((a, b) -> b.getMarks() - a.getMarks()).limit(3).toList();

				top3.forEach(System.out::println);
				break;
			case 4:
				Map<String, List<Student>> groupBySection = student.stream()
						.collect(Collectors.groupingBy(Student::getSection));
				groupBySection.forEach((sec, list) -> System.out.println(sec + " " + list));
				break;
			case 5:
				Map<String, Long> countBySection = student.stream()
						.collect(Collectors.groupingBy(Student::getSection, Collectors.counting()));

				System.out.println(countBySection);
				break;
			case 6:
				Map<String, Double> avgMarks = student.stream().collect(
						Collectors.groupingBy(Student::getSection, Collectors.averagingInt(Student::getMarks)));

				System.out.println(avgMarks);
				break;
			case 7:
				List<String> namesUpper = student.stream().map(s -> s.getName().toUpperCase()).toList();

				System.out.println(namesUpper);
				break;
			case 8:
				boolean hasFullMarks = student.stream().anyMatch(s -> s.getMarks() == 100);

				System.out.println(hasFullMarks);
				break;
			case 9:
               System.out.println("Exiting system");
               break;
			default:
				System.out.println("Invaild input Plese Enter 1-9");
			}

		} while (choice != 9);
	}

}
