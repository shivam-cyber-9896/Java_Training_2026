package com.shivam.monocept.studentcourse.controller.course;

import java.io.IOException;
import java.util.List;

import com.shivam.monocept.studentcourse.dao.CourseDAO;
import com.shivam.monocept.studentcourse.model.Course;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/course/list")
public class ViewCoursesServlet extends HttpServlet {

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

        CourseDAO dao =
                new CourseDAO();

        List<Course> courses =
                dao.getAllCourses();

        request.setAttribute(
                "courses",
                courses);

        RequestDispatcher rd =
                request.getRequestDispatcher(
                "/WEB-INF/views/course-list.jsp");

        rd.forward(request, response);
    }
}