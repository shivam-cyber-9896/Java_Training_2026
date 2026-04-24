package com.shivam.monocept.institute.transaction;

import java.sql.Connection;

import com.shivam.monocept.institute.dao.BranchDao;
import com.shivam.monocept.institute.dao.CourcesDao;
import com.shivam.monocept.institute.dao.Registrationdao;
import com.shivam.monocept.institute.dao.StudentDao;
import com.shivam.monocept.institute.model.Student;
import com.shivam.monocept.institute.util.DBUtil;

public class UpdateTransaction {
	StudentDao student = new StudentDao();
    Registrationdao registration = new Registrationdao();
    BranchDao branch = new BranchDao();
    CourcesDao cources = new CourcesDao();
    
    public void updateStudent(int id, String name, String branch) throws Exception {

        if (name == null || name.isEmpty())
            throw new Exception("Name cannot be empty");

        try (Connection connection = DBUtil.getConnection()) {

        	connection.setAutoCommit(false);

            try {
                Student s = student.getStudentById(id,connection);

                if (s == null)
                    throw new Exception("Student not found");

                s.setName(name);
                s.setBranch(branch);

                student.updateStudent(s, connection);

                connection.commit();

            } catch (Exception e) {
                connection.rollback();
                throw new Exception("Update failed: " + e.getMessage());
            }
        }
    }
    
    public void updateCourseFee(int studentId, String course, double fee) throws Exception {

        if (fee <= 0)
            throw new Exception("Fee must be positive");

        try (Connection connection = DBUtil.getConnection()) {

            connection.setAutoCommit(false);

            try {
                registration.updateFee(studentId, course, fee, connection); 

                connection.commit();

            } catch (Exception e) {
                connection.rollback(); 
                throw new Exception("Fee update failed: " + e.getMessage());
            }
        }
    }
}
