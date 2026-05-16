package com.shivam.monocept.studentcourse.controller.student;

import java.io.IOException;

import com.shivam.monocept.studentcourse.dao.StudentDAO;
import com.shivam.monocept.studentcourse.model.Student;
import com.shivam.monocept.studentcourse.validation.InputValidation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student/edit")
public class UpdateStudentServlet extends HttpServlet {

    // LOAD EXISTING STUDENT DATA
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        // Session Validation
        if(session == null ||
           session.getAttribute("loggedInUser") == null){

            response.sendRedirect("../login");
            return;
        }

        String idParam =
                request.getParameter("id");

        
        if(idParam == null){

            request.setAttribute(
                    "error",
                    "Please Enter Student ID");

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                    "/WEB-INF/views/student-update.jsp");

            rd.forward(request, response);

            return;
        }

        int id;

        try {

            id = Integer.parseInt(idParam);

        } catch(NumberFormatException e){

            request.setAttribute(
                    "error",
                    "Invalid Student ID");

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                    "/WEB-INF/views/student-update.jsp");

            rd.forward(request, response);

            return;
        }

        StudentDAO dao =
                new StudentDAO();

        Student student =
                dao.getStudentById(id);

        // Student Not Found
        if(student == null){

            request.setAttribute(
                    "error",
                    "Student Not Found");

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                    "/WEB-INF/views/student-update.jsp");

            rd.forward(request, response);

            return;
        }

        // Send Student Data To JSP
        request.setAttribute(
                "student",
                student);

        RequestDispatcher rd =
                request.getRequestDispatcher(
                "/WEB-INF/views/student-update.jsp");

        rd.forward(request, response);
    }

    // UPDATE STUDENT
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        // Session Validation
        if(session == null ||
           session.getAttribute("loggedInUser") == null){

            response.sendRedirect("../login");
            return;
        }

        int id =
                Integer.parseInt(
                request.getParameter("id"));

        String name =
                request.getParameter("studentName");

        String email =
                request.getParameter("email");

        String phone =
                request.getParameter("phone");

        int age =
                Integer.parseInt(
                request.getParameter("age"));

        String city =
                request.getParameter("city");

        // Validation
        String error =
                InputValidation.validateStudent(
                name,
                email,
                phone,
                age,
                city);

        // Validation Failed
        if(error != null){

            Student student =
                    new Student(
                    name,
                    email,
                    phone,
                    age,
                    city);

            student.setStudentId(id);

            request.setAttribute(
                    "student",
                    student);

            request.setAttribute(
                    "error",
                    error);

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                    "/WEB-INF/views/student-update.jsp");

            rd.forward(request, response);

            return;
        }

        // Update Student
        Student student =
                new Student(
                name,
                email,
                phone,
                age,
                city);

        student.setStudentId(id);

        StudentDAO dao =
                new StudentDAO();

        boolean status =
                dao.updateStudent(student);

        // Update Success
        if(status){

            response.sendRedirect(
                    "../student/list");

        } else {

            request.setAttribute(
                    "error",
                    "Failed To Update Student");

            request.setAttribute(
                    "student",
                    student);

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                    "/WEB-INF/views/student-update.jsp");

            rd.forward(request, response);
        }
    }
}