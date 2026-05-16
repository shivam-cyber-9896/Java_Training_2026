package com.shivam.monocept.leaveServlet;



import java.io.IOException;

import com.shivam.monocept.vaildation.inputVailidation;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/leave")
public class LeaveSystemServlet extends HttpServlet {

    
    public void init() {
        System.out.println("Leave Servlet Initialized");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String dept = request.getParameter("dept");
        String type = request.getParameter("type");
        String daysStr = request.getParameter("days");
        String reason = request.getParameter("reason");

        int days = 0;
        try {
            days = Integer.parseInt(daysStr);
        } catch (Exception e) {}

        String error = inputVailidation.validate(name, id, dept, type, days, reason);
       
        if (error != null) {
        	 request.setAttribute("error", error);

        	    request.setAttribute("name", name);
        	    request.setAttribute("id", id);
        	    request.setAttribute("dept", dept);
        	    request.setAttribute("type", type);
        	    request.setAttribute("days", daysStr);
        	    request.setAttribute("reason", reason);

        	    RequestDispatcher rd = request.getRequestDispatcher("leaveForm.jsp");
        	    rd.forward(request, response);
        	    return;
        }

        
        String approvalMessage;
        if (days > 5) {
            approvalMessage = "This leave request requires manager approval";
        } else {
            approvalMessage = "This leave request can be processed normally";
        }

        request.setAttribute("name", name);
        request.setAttribute("id", id);
        request.setAttribute("dept", dept);
        request.setAttribute("type", type);
        request.setAttribute("days", days);
        request.setAttribute("reason", reason);
        request.setAttribute("approval", approvalMessage);

        RequestDispatcher rd = request.getRequestDispatcher("review.jsp");
        rd.forward(request, response);
    }

    public void destroy() {
        System.out.println("Leave Servlet Destroyed");
    }
}