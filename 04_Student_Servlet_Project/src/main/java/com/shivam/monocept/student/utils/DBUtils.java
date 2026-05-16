package com.shivam.monocept.student.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
	private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = "root";
    private static final String PASSWORD = "shivam@9896";

    public static Connection getConnection() throws Exception {
    	   Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
