package com.shivam.monocept.studentcourse.controller.course;

import java.io.IOException;

import com.shivam.monocept.studentcourse.dao.CourseDAO;
import com.shivam.monocept.studentcourse.model.Course;
import com.shivam.monocept.studentcourse.validation.CourseValidation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/course/add")
public class AddCourseServlet extends HttpServlet {

    // OPEN COURSE FORM
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        // SESSION VALIDATION
        if(session == null ||
           session.getAttribute("loggedInUser") == null){

            response.sendRedirect("../login");
            return;
        }

        RequestDispatcher rd =
                request.getRequestDispatcher(
                "/WEB-INF/views/course-form.jsp");

        rd.forward(request, response);
    }

    // ADD COURSE
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        String courseName =
                request.getParameter("courseName");

        String duration =
                request.getParameter("duration");

        double fees =
                Double.parseDouble(
                request.getParameter("fees"));

        String trainerName =
                request.getParameter("trainerName");

        // VALIDATION
        String error =
                CourseValidation.validateCourse(
                courseName,
                duration,
                fees,
                trainerName);

        // VALIDATION FAILED
        if(error != null){

            request.setAttribute(
                    "error",
                    error);

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                    "/WEB-INF/views/course-form.jsp");

            rd.forward(request, response);

            return;
        }

        // CREATE COURSE OBJECT
        Course course =
                new Course(
                courseName,
                duration,
                fees,
                trainerName);

        CourseDAO dao =
                new CourseDAO();

        boolean status =
                dao.addCourse(course);

        // SUCCESS
        if(status){

            response.sendRedirect(
                    "../course/list");

        } else {

            request.setAttribute(
                    "error",
                    "Failed To Add Course");

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                    "/WEB-INF/views/course-form.jsp");

            rd.forward(request, response);
        }
    }
}