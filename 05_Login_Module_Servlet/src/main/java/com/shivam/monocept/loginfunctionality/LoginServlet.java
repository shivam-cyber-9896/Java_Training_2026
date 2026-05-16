package com.shivam.monocept.loginfunctionality;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String username = request.getParameter("username");
     String password = request.getParameter("password");
     String remember = request.getParameter("remember");

     
     if (remember != null) {
         Cookie cookie = new Cookie("username", username);

        
         cookie.setMaxAge(86400);

         response.addCookie(cookie);
     } else {
         
         Cookie cookie = new Cookie("username", "");
         cookie.setMaxAge(0);
         response.addCookie(cookie);
     }

     if (username.equals(username) && password.equals(password)) {

         HttpSession session = request.getSession();
         System.out.println(session.getId());
         session.setAttribute("user", username);
         
          
         session.setMaxInactiveInterval(10);
        
         
         response.sendRedirect("dashboard.jsp");
           return;

     } 
         response.sendRedirect("login.jsp?error=invalid");
     
}
}
