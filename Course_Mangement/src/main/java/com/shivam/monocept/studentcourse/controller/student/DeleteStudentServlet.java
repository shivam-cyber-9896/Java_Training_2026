package com.shivam.monocept.studentcourse.controller.student;
import java.io.IOException;

import com.shivam.monocept.studentcourse.dao.StudentDAO;
import com.shivam.monocept.studentcourse.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student/delete")
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        String idParam =
                request.getParameter("id");

        
        if(idParam == null){

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                    "/WEB-INF/views/student-delete.jsp");

            rd.forward(request, response);

            return;
        }

        // Fetch student data
        int id =
                Integer.parseInt(idParam);

        StudentDAO dao =
                new StudentDAO();

        Student student =
                dao.getStudentById(id);

        request.setAttribute(
                "student",
                student);

        RequestDispatcher rd =
                request.getRequestDispatcher(
                "/WEB-INF/views/student-delete.jsp");

        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        int id =
                Integer.parseInt(
                request.getParameter("id"));

        StudentDAO dao =
                new StudentDAO();

		/*
		 * // Check registrations if(dao.hasRegistrations(id)){
		 * 
		 * request.setAttribute( "error",
		 * "Cannot delete student. Registrations exist.");
		 * 
		 * Student student = dao.getStudentById(id);
		 * 
		 * request.setAttribute( "student", student);
		 * 
		 * RequestDispatcher rd = request.getRequestDispatcher(
		 * "/WEB-INF/views/student-delete.jsp");
		 * 
		 * rd.forward(request, response);
		 * 
		 * return; }
		 */

        dao.deleteStudent(id);

        response.sendRedirect("../student/list");
    }
}