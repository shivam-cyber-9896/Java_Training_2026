package com.shivam.monocept.institute.transaction;

import java.sql.Connection;

import com.shivam.monocept.institute.dao.BranchDao;
import com.shivam.monocept.institute.dao.CourcesDao;
import com.shivam.monocept.institute.dao.Registrationdao;
import com.shivam.monocept.institute.dao.StudentDao;
import com.shivam.monocept.institute.model.Student;
import com.shivam.monocept.institute.util.DBUtil;

public class ReadTransaction {

	StudentDao student = new StudentDao();
    Registrationdao registration = new Registrationdao();
    BranchDao branch = new BranchDao();
    CourcesDao cources = new CourcesDao();
   
    

    public void viewAllStudents() throws Exception {
        registration.getAllStudentCourseDetails()
                .forEach(System.out::println);
    }

    public void searchStudent(int id) throws Exception {

        try (Connection connection = DBUtil.getConnection()) {

            Student s = student.getStudentById(id,connection);

            if (s == null)
                throw new Exception("Student not found");

            System.out.println("Name: " + s.getName());
            System.out.println("Branch: " + s.getBranch());

            registration.getCoursesByStudent(id)
                    .forEach(System.out::println);
        }
    }

    

    
    public void highPayingStudents(double amount) throws Exception {

        if (amount < 0)
            throw new Exception("Invalid amount");

        registration.getHighPaying(amount)
                .forEach(System.out::println);
    }

    public void courseWiseCount() throws Exception {

        registration.getCourseCount()
                .forEach(System.out::println);
    }
    
    public void showCoursesByBranch(int branchId) throws Exception {

        try (Connection con = DBUtil.getConnection()) {

            con.setAutoCommit(false); 

            try {
            	cources.getCoursesByBranch(branchId, con);

                con.commit(); 

            } catch (Exception e) {
                con.rollback();
                throw new Exception("Failed to fetch courses: " + e.getMessage());
            }
        }
    }

    public void showBranches() throws Exception {

        try (Connection connection = DBUtil.getConnection()) {

            connection.setAutoCommit(false);

            try {
                branch.getAllBranches(connection);
                         
                connection.commit();

            } catch (Exception e) {
                connection.rollback();
                throw new Exception("Failed to fetch branches: " + e.getMessage());
            }
        }
    }
}