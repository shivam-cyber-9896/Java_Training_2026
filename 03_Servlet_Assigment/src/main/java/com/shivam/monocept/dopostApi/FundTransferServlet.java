package com.shivam.monocept.dopostApi;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/transfer")
public class FundTransferServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String source = request.getParameter("source");
        String destination = request.getParameter("destination");
        String amountStr = request.getParameter("amount");

        // 🔥 Validation function
        String error = validateTransfer(source, destination, amountStr);

        if (error != null) {
            out.println("<h2 style='color:red;'>" + error + "</h2>");
            return;
        }

        double amount = Double.parseDouble(amountStr);

        // ✅ Success Response
        out.println("<h1 style='color:green;'>Transaction Successful!</h1>");
        out.println("<p><b>From:</b> " + source + "</p>");
        out.println("<p><b>To:</b> " + destination + "</p>");
        out.println("<p><b>Amount Transferred:</b> ₹" + amount + "</p>");
    }

    // ✅ Separate validation function
    private String validateTransfer(String source, String destination, String amountStr) {

        if (source == null || source.trim().isEmpty()) {
            return "Source account is required!";
        }

        if (destination == null || destination.trim().isEmpty()) {
            return "Destination account is required!";
        }

        if (source.equals(destination)) {
            return "Source and destination accounts cannot be the same!";
        }

        double amount;
        try {
            amount = Double.parseDouble(amountStr);

            if (amount <= 0) {
                return "Amount must be greater than 0!";
            }

            if (amount > 50000) {
                return "Amount cannot exceed ₹50,000!";
            }

        } catch (Exception e) {
            return "Invalid amount!";
        }

        return null; // no error
    }
}