package com.shivam.monocept.institute.transaction;

import java.sql.Connection;

import com.shivam.monocept.institute.dao.BranchDao;
import com.shivam.monocept.institute.dao.CourcesDao;
import com.shivam.monocept.institute.dao.Registrationdao;
import com.shivam.monocept.institute.dao.StudentDao;
import com.shivam.monocept.institute.util.DBUtil;

public class DeleteTransaction {
	StudentDao student = new StudentDao();
    Registrationdao registration = new Registrationdao();
    BranchDao branch = new BranchDao();
    CourcesDao cources = new CourcesDao();

    public void cancelRegistration(int studentId, String course) throws Exception {

        try (Connection connection = DBUtil.getConnection()) {

            connection.setAutoCommit(false);

            try {
                registration.deleteRegistration(studentId, course, connection);
                connection.commit();

            } catch (Exception e) {
                connection.rollback();
                throw new Exception("Cancellation failed: " + e.getMessage());
            }
        }
    }

    public void deleteStudent(int studentId) throws Exception {

        try (Connection connection = DBUtil.getConnection()) {

        	connection.setAutoCommit(false);

            try {
                if (student.getStudentById(studentId,connection) == null)
                    throw new Exception("Student not found");

                registration.deleteAllRegistrations(studentId, connection);
                student.deleteStudent(studentId, connection);

                connection.commit();

            } catch (Exception e) {
            	connection.rollback();
                throw new Exception("Delete failed: " + e.getMessage());
            }
        }
    }
}
