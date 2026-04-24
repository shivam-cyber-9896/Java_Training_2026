package com.shivam.monocept.institute.transaction;

import java.sql.Connection;

import com.shivam.monocept.institute.dao.BranchDao;
import com.shivam.monocept.institute.dao.CourcesDao;
import com.shivam.monocept.institute.dao.Registrationdao;
import com.shivam.monocept.institute.dao.StudentDao;
import com.shivam.monocept.institute.util.DBUtil;

public class BooleanTransaction {
	StudentDao student = new StudentDao();
    Registrationdao registration = new Registrationdao();
    BranchDao branch = new BranchDao();
    CourcesDao cources = new CourcesDao();
	
    public boolean studentExists(int id) throws Exception {

        try (Connection connection = DBUtil.getConnection()) {
            return student.isStudentExists(id, connection);
        }
    }
    public boolean courseExists(int courseId) throws Exception {

        try (Connection connection = DBUtil.getConnection()) {
        	return cources.isCourseExists(courseId, connection);
        }
    }
    public boolean branchExists(int branchId) throws Exception {

        try (Connection connection = DBUtil.getConnection()) {
            return branch.isBrenchAvailable(branchId, connection);
        }
    }
   
    }

