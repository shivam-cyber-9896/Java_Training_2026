package com.shivam.monocept.institute.transaction;

import java.sql.Connection;

import com.shivam.monocept.institute.dao.BranchDao;
import com.shivam.monocept.institute.dao.CourcesDao;
import com.shivam.monocept.institute.dao.Registrationdao;
import com.shivam.monocept.institute.dao.StudentDao;
import com.shivam.monocept.institute.model.Student;
import com.shivam.monocept.institute.util.DBUtil;

public class AddTransaction {
	 StudentDao student = new StudentDao();
	    Registrationdao registration = new Registrationdao();
	    BranchDao branch = new BranchDao();
        CourcesDao cources = new CourcesDao();
	 public void addStudent(Student s) throws Exception {

	        if (s.getName() == null || s.getName().isEmpty())
	            throw new Exception("Name cannot be empty");

	        if (s.getAge() <= 0)
	            throw new Exception("Invalid age");

	        try (Connection connection = DBUtil.getConnection()) {

	        	connection.setAutoCommit(false);

	            try {
	                student.addStudent(s, connection);
	                connection.commit();

	            } catch (Exception e) {
	            	connection.rollback();
	                throw new Exception("Failed to add student: " + e.getMessage());
	            }
	        }
	    }

	 public void registerStudent(int studentId, int courseId, double fee) throws Exception {

		    if (fee <= 0)
		        throw new Exception("Fee must be greater than 0");

		    try (Connection connection = DBUtil.getConnection()) {

		        connection.setAutoCommit(false);

		        try {
		            
		            Student s = student.getStudentById(studentId,connection);
		            if (s == null)
		                throw new Exception("Student not found");

		            
		            int branchId = branch.getBranchId(s.getBranch(), connection);

		            // 3. Validate course
		            if (!cources.isCourseAvailable(branchId, courseId, connection)) {
		                throw new Exception("Invalid course for this branch");
		            }

		            // 4. Get course name
		            String courseName = cources.getCourseById(courseId, connection);

		            // 5. Duplicate check
		            if (registration.isDuplicate(studentId, courseName, connection))
		                throw new Exception("Duplicate registration");

		            // 6. Insert
		            registration.registerCourse(studentId, courseName, fee, connection);

		            connection.commit();

		        } catch (Exception e) {
		            connection.rollback();
		            throw new Exception("Registration failed: " + e.getMessage());
		        }
		    }
		}
}
