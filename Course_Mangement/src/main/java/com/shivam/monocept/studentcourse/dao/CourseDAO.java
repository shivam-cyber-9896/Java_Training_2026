package com.shivam.monocept.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shivam.monocept.studentcourse.Util.DBConnection;
import com.shivam.monocept.studentcourse.model.Course;

public class CourseDAO {

      public boolean addCourse(Course course) {

        boolean status = false;

        try {

            Connection connection =
                    DBConnection.getConnection();

            String query =
            "INSERT INTO courses(course_name,duration,fees,trainer_name) VALUES(?,?,?,?)";

            PreparedStatement preparedStatement =
            		connection.prepareStatement(query);

            preparedStatement.setString(1,
                    course.getCourseName());

            preparedStatement.setString(2,
                    course.getDuration());

            preparedStatement.setDouble(3,
                    course.getFees());

            preparedStatement.setString(4,
                    course.getTrainerName());

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

   
    public List<Course> getAllCourses(){

        List<Course> courses =
                new ArrayList<>();

        try {

            Connection connection =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM courses";

            PreparedStatement preparedStatement =
            		connection.prepareStatement(query);

            ResultSet resultSet =
            		preparedStatement.executeQuery();

            while(resultSet.next()){

                Course course =
                        new Course();

                course.setCourseId(
                		resultSet.getInt("course_id"));

                course.setCourseName(
                		resultSet.getString("course_name"));

                course.setDuration(
                		resultSet.getString("duration"));

                course.setFees(
                		resultSet.getDouble("fees"));

                course.setTrainerName(
                		resultSet.getString("trainer_name"));

                courses.add(course);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch(Exception e){
        	 System.out.println("Error ="+e);
        }

        return courses;
    }

  
    public Course getCourseById(int id){

        Course course = null;

        try {

            Connection connection =
                    DBConnection.getConnection();

            String query =
            "SELECT * FROM courses WHERE course_id=?";

            PreparedStatement preparedStatement =
            		connection.prepareStatement(query);

            preparedStatement.setInt(1, id);

            ResultSet rs =
            		preparedStatement.executeQuery();

            if(rs.next()){

                course = new Course();

                course.setCourseId(
                        rs.getInt("course_id"));

                course.setCourseName(
                        rs.getString("course_name"));

                course.setDuration(
                        rs.getString("duration"));

                course.setFees(
                        rs.getDouble("fees"));

                course.setTrainerName(
                        rs.getString("trainer_name"));
            }
            
            preparedStatement.close();
            connection.close();
        } catch(Exception e){
        	 System.out.println("Error ="+e);
        }

        return course;
    }

    // UPDATE COURSE
    public boolean updateCourse(Course course){

        boolean status = false;

        try {

            Connection connection =
                    DBConnection.getConnection();

            String query =
            "UPDATE courses SET course_name=?,duration=?,fees=?,trainer_name=? WHERE course_id=?";

            PreparedStatement preparedStatement =
            		connection.prepareStatement(query);

            preparedStatement.setString(1,
                    course.getCourseName());

            preparedStatement.setString(2,
                    course.getDuration());

            preparedStatement.setDouble(3,
                    course.getFees());

            preparedStatement.setString(4,
                    course.getTrainerName());

            preparedStatement.setInt(5,
                    course.getCourseId());

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

    
    public boolean deleteCourse(int id){

        boolean status = false;

        try {

            Connection connection =
                    DBConnection.getConnection();

            String query =
            "DELETE FROM courses WHERE course_id=?";

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