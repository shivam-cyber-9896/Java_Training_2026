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

@WebServlet("/course/edit")
public class UpdateCourseServlet extends HttpServlet {

    // FETCH COURSE BY ID
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

        String idParam =
                request.getParameter("id");

        // FIRST TIME OPEN PAGE
        if(idParam == null){

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                    "/WEB-INF/views/course-update.jsp");

            rd.forward(request, response);

            return;
        }

        int id =
                Integer.parseInt(idParam);

        CourseDAO dao =
                new CourseDAO();

        Course course =
                dao.getCourseById(id);

        // COURSE NOT FOUND
        if(course == null){

            request.setAttribute(
                    "error",
                    "Course Not Found");

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                    "/WEB-INF/views/course-update.jsp");

            rd.forward(request, response);

            return;
        }

        request.setAttribute(
                "course",
                course);

        RequestDispatcher rd =
                request.getRequestDispatcher(
                "/WEB-INF/views/course-update.jsp");

        rd.forward(request, response);
    }

    // UPDATE COURSE
    @Override
    protected void doPost(HttpServletRequest request,
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

        int id =
                Integer.parseInt(
                request.getParameter("id"));

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

        Course course =
                new Course(
                courseName,
                duration,
                fees,
                trainerName);

        course.setCourseId(id);

        // VALIDATION FAILED
        if(error != null){

            request.setAttribute(
                    "course",
                    course);

            request.setAttribute(
                    "error",
                    error);

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                    "/WEB-INF/views/course-update.jsp");

            rd.forward(request, response);

            return;
        }

        CourseDAO dao =
                new CourseDAO();

        boolean status =
                dao.updateCourse(course);

        // UPDATE SUCCESS
        if(status){

            response.sendRedirect(
                    "../course/list");

        } else {

            request.setAttribute(
                    "course",
                    course);

            request.setAttribute(
                    "error",
                    "Failed To Update Course");

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                    "/WEB-INF/views/course-update.jsp");

            rd.forward(request, response);
        }
    }
}