package com.shivam.monocept.institute.service;

import java.util.Scanner;

import com.shivam.monocept.institute.input.Inputhandler;
import com.shivam.monocept.institute.model.Student;
import com.shivam.monocept.institute.transaction.*;

public class StudentService {
	Scanner scanner = new Scanner(System.in);
	AddTransaction add = new AddTransaction();
	DeleteTransaction delete = new DeleteTransaction();
	ReadTransaction read = new ReadTransaction();
	UpdateTransaction update = new UpdateTransaction();
	GetTransaction get = new GetTransaction();
	Inputhandler input = new Inputhandler();
	
	BooleanTransaction vaild = new BooleanTransaction();
	int choice1 = 0;
	public void showMenu() {

		

		do {
			System.out.println("\n===== MENU =====");
			System.out.println("1. Add Student");
			System.out.println("2. Register for Course");
			System.out.println("3. View All Students with Courses");
			System.out.println("4. Search Student by ID");
			System.out.println("5. Update Student");
			System.out.println("6. Update Course Fee");
			System.out.println("7. Cancel Registration");
			System.out.println("8. Delete Student");
			System.out.println("9. High Paying Students");
			System.out.println("10. Course-wise Count");
			System.out.println("11. Exit");

			String Stchoice = scanner.nextLine();

			if (Stchoice.matches("\\d+")) {
				choice1 = Integer.parseInt(Stchoice);
			}

			try {
				switch (choice1) {

				case 1:
					System.out.print("Enter ID: ");
					int id = input.idInput(scanner);
					if (vaild.studentExists(id)) {
						System.out.println(" Invaild id ");
						break;
					}
					System.out.print("Enter Name: ");
					String name = input.nameInput(scanner);

					System.out.print("Enter Age: ");
					int age = input.ageInput(scanner);

					read.showBranches();
					System.out.print("Enter Branch No: ");

					int branchId = 0;
					String branch;
					while (true) {
						branchId = input.IntegerInput(scanner);
						if (vaild.branchExists(branchId))
							break;
						read.showBranches();
					}
					branch = get.getBrenchName(branchId);
					Student s = new Student(id, name, age, branch);
					add.addStudent(s);
					System.out.println("Student Added Successfully");
					break;

				case 2:
					System.out.print("Enter Student ID: ");
					int sid = input.idInput(scanner);
					if (!vaild.studentExists(sid)) {
						System.out.println(" Invaild id ");
						break;
					}
					String brenchname = get.getBrenchNameStudent(sid);
					int brenchId = get.getBranchId(brenchname);
					read.showCoursesByBranch(brenchId);
					System.out.print("Enter Course No: ");
					int courseID;
					while (true) {
						courseID = input.IntegerInput(scanner);
						if (vaild.courseExists(courseID))
							break;
						read.showCoursesByBranch(brenchId);
					}
					
					System.out.print("Enter Fee: ");
                  	double fee = input.feeInput(scanner);

					add.registerStudent(sid, courseID, fee);
					System.out.println("Course Registered Successfully");
					break;

				case 3:
					read.viewAllStudents();
					break;

				case 4:
					System.out.print("Enter Student ID: ");

					int searchId = input.idInput(scanner);
					read.searchStudent(searchId);
					break;

				case 5:
					System.out.print("Enter Student ID: ");
					int upId = input.idInput(scanner);
					if (!vaild.studentExists(upId)) {
						System.out.println(" Invaild id ");
						break;
					}
					System.out.print("Enter New Name: ");
					String newName = input.nameInput(scanner);
					read.showBranches();
					System.out.print("Enter New Branch: ");
					 int newBranch;
					 while (true) {
						 newBranch = input.IntegerInput(scanner);
							if (vaild.branchExists(newBranch))
								break;
							read.showBranches();
						}
						String branchNew = get.getBrenchName(newBranch);
					update.updateStudent(upId, newName, branchNew);
					System.out.println("Student Updated Successfully");
					break;

				case 6:
					System.out.println("Update Course Fee");

					System.out.print("Enter Student ID: ");
					int stuId = input.idInput(scanner);
					if (!vaild.studentExists(stuId)) {
						System.out.println(" Invaild id ");
						break;
					}
					
					System.out.print("Enter Course Name: ");
					String courseName = input.InputString(scanner);

					System.out.print("Enter New Fee: ");
					double newFee = input.feeInput(scanner);

					update.updateCourseFee(stuId, courseName, newFee);

					System.out.println("Fee updated successfully");
					break;

				case 7:
					System.out.print("Enter Student ID: ");
					int delId = input.idInput(scanner);
					if (!vaild.studentExists(delId)) {
						System.out.println(" Invaild id ");
						break;
					}
					System.out.print("Enter Course: ");
					String delCourse = input.InputString(scanner);

					delete.cancelRegistration(delId, delCourse);
					System.out.println("Registration Cancelled");
					break;

				case 8:
					System.out.print("Enter Student ID: ");
					int deleteId = input.idInput(scanner);
					if (!vaild.studentExists(deleteId)) {
						System.out.println(" Invaild id ");
						break;
					}
					delete.deleteStudent(deleteId);
					System.out.println("Student Deleted");
					break;

				case 9:
					System.out.print("Enter Minimum Amount: ");
					double amt = input.feeInput(scanner);

					read.highPayingStudents(amt);
					break;

				case 10:
					read.courseWiseCount();
					break;

				case 11:
					System.out.println("System Exiting... Bye Bye ");
					break;

				default:
					System.out.println("Enter a valid choice");
				}

			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}

		} while (choice1 != 11);
	}
}
