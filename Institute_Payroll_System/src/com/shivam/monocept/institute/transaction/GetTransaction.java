package com.shivam.monocept.institute.transaction;

import java.sql.Connection;

import com.shivam.monocept.institute.dao.BranchDao;
import com.shivam.monocept.institute.dao.CourcesDao;
import com.shivam.monocept.institute.dao.Registrationdao;
import com.shivam.monocept.institute.dao.StudentDao;
import com.shivam.monocept.institute.util.DBUtil;

public class GetTransaction {
	StudentDao student = new StudentDao();
    Registrationdao registration = new Registrationdao();
    BranchDao branch = new BranchDao();
    CourcesDao cources = new CourcesDao();
    
    public String getCourseName(int courseId) throws Exception {

        try (Connection con = DBUtil.getConnection()) {

            con.setAutoCommit(false);

            try {
                String course = cources.getCourseById(courseId, con);

                con.commit();

                return course;

            } catch (Exception e) {
                con.rollback();
                throw new Exception("Failed to fetch course: " + e.getMessage());
            }
        }
    }
    public String getBrenchName(int Id) throws Exception {

        try (Connection connection = DBUtil.getConnection()) {

            connection.setAutoCommit(false);

            try {
                String branchName=branch.getBranchName(Id, connection);

                connection.commit();

                return branchName;

            } catch (Exception e) {
                connection.rollback();
                throw new Exception("Failed to fetch course: " + e.getMessage());
            }
        }
    }
    public int getBranchId(String branchName) throws Exception {

        try (Connection connection = DBUtil.getConnection()) {

            int branchId = branch.getBranchId(branchName, connection);

            if (branchId == 0) {
                throw new Exception("Branch not found");
            }

            return branchId;
        }
    }
    public String getBrenchNameStudent(int Id) throws Exception {

        try (Connection connection = DBUtil.getConnection()) {

            connection.setAutoCommit(false);

            try {
                String branchName=student.getBranchName(Id, connection);

                connection.commit();

                return branchName;

            } catch (Exception e) {
                connection.rollback();
                throw new Exception("Failed to fetch course: " + e.getMessage());
            }
        }
    }
}
