package com.shivam.monocept.studentservlet;

import java.io.IOException;
import java.util.List;

import com.shivam.monocept.student.model.Student;
import com.shivam.monocept.student.serviecs.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/students")
public class StudentListServlet extends HttpServlet {
@Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        StudentDao dao = new StudentDao();
        List<Student> list = dao.getAllStudents();
       
        request.setAttribute("students", list);

        
        RequestDispatcher rd = request.getRequestDispatcher("students.jsp");
        rd.forward(request, response);
		/*
		 * // ❗ use session (because redirect loses request data) HttpSession session =
		 * request.getSession(); session.setAttribute("students", list);
		 * 
		 * response.sendRedirect("showStudents");
		 */
        
    }
}