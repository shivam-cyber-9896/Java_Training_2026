package com.shivam.monocept.studentcourse.controller.student;

import java.io.IOException;
import java.util.List;

import com.shivam.monocept.studentcourse.dao.StudentDAO;
import com.shivam.monocept.studentcourse.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student/list")
public class ViewStudentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if(session == null ||
           session.getAttribute("loggedInUser") == null){

            response.sendRedirect("../login");
            return;
        }

        StudentDAO dao =
                new StudentDAO();

        List<Student> students =
                dao.getAllStudents();

        request.setAttribute(
                "students",
                students);

        RequestDispatcher rd =
                request.getRequestDispatcher(
                "/WEB-INF/views/student-list.jsp");

        rd.forward(request, response);
    }
}