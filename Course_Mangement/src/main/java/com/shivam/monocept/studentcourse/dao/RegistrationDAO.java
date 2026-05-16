package com.shivam.monocept.studentcourse.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shivam.monocept.studentcourse.Util.DBConnection;
import com.shivam.monocept.studentcourse.model.Registration;

public class RegistrationDAO {

    // ADD REGISTRATION
    public boolean addRegistration(
            Registration registration){

        boolean status = false;

        try {

            Connection connection =
                    DBConnection.getConnection();

            String query =
            "INSERT INTO registrations(student_id,course_id,registration_date,status) VALUES(?,?,?,?)";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(1,
                    registration.getStudentId());

            preparedStatement.setInt(2,
                    registration.getCourseId());

            preparedStatement.setString(3,
                    registration.getRegistrationDate());

            preparedStatement.setString(4,
                    registration.getStatus());

            int rows =
            		preparedStatement.executeUpdate();

            if(rows > 0){
                status = true;
            }
           
            preparedStatement.close();
            connection.close();
        } catch(Exception e){
        	 System.out.println("Error ="+e);
        }
         
        return status;
    }

    // VIEW ALL
    public List<Registration> getAllRegistrations(){

        List<Registration> registrations =
                new ArrayList<>();

        try {

            Connection connection =
                    DBConnection.getConnection();

            String query =
            "SELECT * FROM registrations";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            ResultSet resultSet =
            		preparedStatement.executeQuery();

            while(resultSet.next()){

                Registration registration =
                        new Registration();

                registration.setRegistrationId(
                		resultSet.getInt("registration_id"));

                registration.setStudentId(
                		resultSet.getInt("student_id"));

                registration.setCourseId(
                		resultSet.getInt("course_id"));

                registration.setRegistrationDate(
                		resultSet.getString("registration_date"));

                registration.setStatus(
                		resultSet.getString("status"));

                registrations.add(registration);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch(Exception e){
        	 System.out.println("Error ="+e);
        }

        return registrations;
    }

    // GET BY ID
    public Registration getRegistrationById(int id){

        Registration registration = null;

        try {

            Connection connection =
                    DBConnection.getConnection();

            String query =
            "SELECT * FROM registrations WHERE registration_id=?";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(1, id);

            ResultSet resultSet =
            		preparedStatement.executeQuery();

            if(resultSet.next()){

                registration =
                        new Registration();

                registration.setRegistrationId(
                		resultSet.getInt("registration_id"));

                registration.setStudentId(
                		resultSet.getInt("student_id"));

                registration.setCourseId(
                		resultSet.getInt("course_id"));

                registration.setRegistrationDate(
                		resultSet.getString("registration_date"));

                registration.setStatus(
                		resultSet.getString("status"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch(Exception e){
        	 System.out.println("Error ="+e);
        }

        return registration;
    }

    // UPDATE STATUS
    public boolean updateRegistration(
            Registration registration){

        boolean status = false;

        try {

            Connection connection =
                    DBConnection.getConnection();

            String query =
            "UPDATE registrations SET status=? WHERE registration_id=?";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setString(1,
                    registration.getStatus());

            preparedStatement.setInt(2,
                    registration.getRegistrationId());

            int rows =
            		preparedStatement.executeUpdate();

            if(rows > 0){
                status = true;
            }
            preparedStatement.close();
            connection.close();
        } catch(Exception e){
        	 System.out.println("Error ="+e);
        	 }

        return status;
    }

    // DELETE
    public boolean deleteRegistration(int id){

        boolean status = false;

        try {

            Connection connection =
                    DBConnection.getConnection();

            String query =
            "DELETE FROM registrations WHERE registration_id=?";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(1, id);

            int rows =
            		preparedStatement.executeUpdate();

            if(rows > 0){
                status = true;
            }
            preparedStatement.close();
            connection.close();
        } catch(Exception e){
        	 System.out.println("Error ="+e);
        }

        return status;
    }
}