package com.shivam.monocept.cookiestatemangement;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet("/savePref")
public class SavePreferenceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String theme = request.getParameter("theme");
        String language = request.getParameter("language");
        String font = request.getParameter("font");

        Cookie c1 = new Cookie("theme", theme);
        Cookie c2 = new Cookie("language", language);
        Cookie c3 = new Cookie("font", font);

        c1.setMaxAge(86400);
        c2.setMaxAge(86400);
        c3.setMaxAge(86400);

        response.addCookie(c1);
        response.addCookie(c2);
        response.addCookie(c3);

        response.sendRedirect("home.jsp");
    }
}