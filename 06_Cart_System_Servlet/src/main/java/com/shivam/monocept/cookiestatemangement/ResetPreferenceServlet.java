package com.shivam.monocept.cookiestatemangement;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet("/resetPref")
public class ResetPreferenceServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Cookie c1 = new Cookie("theme","");
        Cookie c2 = new Cookie("language","");
        Cookie c3 = new Cookie("font","");

        c1.setMaxAge(0);
        c2.setMaxAge(0);
        c3.setMaxAge(0);

        response.addCookie(c1);
        response.addCookie(c2);
        response.addCookie(c3);

        response.sendRedirect("home.jsp");
    }
}