package com.shivam.monocept.studentcourse.controller.course;

import java.io.IOException;

import com.shivam.monocept.studentcourse.dao.CourseDAO;
import com.shivam.monocept.studentcourse.model.Course;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/course/delete")
public class DeleteCourseServlet extends HttpServlet {

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
                    "/WEB-INF/views/course-delete.jsp");

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
                    "/WEB-INF/views/course-delete.jsp");

            rd.forward(request, response);

            return;
        }

        request.setAttribute(
                "course",
                course);

        RequestDispatcher rd =
                request.getRequestDispatcher(
                "/WEB-INF/views/course-delete.jsp");

        rd.forward(request, response);
    }

    // DELETE COURSE
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

        CourseDAO dao =
                new CourseDAO();

        boolean status =
                dao.deleteCourse(id);

        if(status){

            response.sendRedirect(
                    "../course/list");

        } else {

            request.setAttribute(
                    "error",
                    "Failed To Delete Course");

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                    "/WEB-INF/views/course-delete.jsp");

            rd.forward(request, response);
        }
    }
}