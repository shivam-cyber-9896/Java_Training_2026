package com.shivam.monocept.institute.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/institute";
    private static final String USER = "root";
    private static final String PASSWORD = "shivam@9896";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}