package com.shivam.monocept.dopostApi;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/conference")
public class ConferenceBookingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String seatsStr = request.getParameter("seats");
        String dateStr = request.getParameter("date");
        String session = request.getParameter("session");

       
        String error = validateInput(name, email, seatsStr,  session) ;
                 error=validateDate(dateStr)  ;       
        if (error != null) {
            out.println("<h2 style='color:red;'>" + error + "</h2>");
            return;
        }

        int seats = Integer.parseInt(seatsStr);

       
        out.println("<h1 style='color:green;'>Booking Confirmed!</h1>");
        out.println("<h3>🎟 Conference Ticket</h3>");
        out.println("<p><b>Name:</b> " + name + "</p>");
        out.println("<p><b>Email:</b> " + email + "</p>");
        out.println("<p><b>Seats:</b> " + seats + "</p>");
        out.println("<p><b>Date:</b> " + dateStr + "</p>");
        out.println("<p><b>Session:</b> " + session + "</p>");
    }

    private String validateDate(String dateStr) {

        if (dateStr == null || dateStr.isEmpty()) {
            return "Date is required!";
        }

        try {
            LocalDate date = LocalDate.parse(dateStr);
            LocalDate today = LocalDate.now();

            if (date.isBefore(today)) {
                return "Date cannot be in the past!";
            }

        } catch (DateTimeParseException e) {
            return "Invalid date format! Use yyyy-MM-dd";
        }

        return null; 
    }
    private String validateInput(String name, String email, String seatsStr,  String session) {

        if (name == null || name.trim().isEmpty()) {
            return "Name is required!";
        }

        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            return "Invalid email!";
        }

        int seats;
        try {
            seats = Integer.parseInt(seatsStr);
            if (seats <= 0 || seats > 5) {
                return "You can book maximum 5 seats!";
            }
        } catch (Exception e) {
            return "Invalid number of seats!";
        }


        if (session == null || session.isEmpty()) {
            return "Please select a session type!";
        }

        return null;
    }
}
