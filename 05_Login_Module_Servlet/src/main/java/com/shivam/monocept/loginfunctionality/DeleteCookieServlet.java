package com.shivam.monocept.loginfunctionality;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet("/deleteCookie")
public class DeleteCookieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Cookie cookie = new Cookie("username", "");
        cookie.setMaxAge(0); 
        response.addCookie(cookie);

        response.sendRedirect("login.jsp");
    }
}