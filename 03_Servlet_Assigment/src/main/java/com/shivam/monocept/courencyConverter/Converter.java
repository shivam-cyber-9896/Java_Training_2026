package com.shivam.monocept.courencyConverter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/convert")
public class Converter extends HttpServlet {
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String amountStr = request.getParameter("amount");
	        String from = request.getParameter("from");
	        String to = request.getParameter("to");

	        
	        if (amountStr == null || from == null || to == null ||
	            amountStr.isEmpty() || from.isEmpty() || to.isEmpty()) {

	            out.println("<h2 style='color:red;'>Error: All fields are required!</h2>");
	            return;
	        }

	        double amount;

	        try {
	            amount = Double.parseDouble(amountStr);
	            if (amount <= 0) {
	                out.println("<h2 style='color:red;'>Amount must be greater than 0!</h2>");
	                return;
	            }
	        } catch (NumberFormatException e) {
	            out.println("<h2 style='color:red;'>Invalid amount!</h2>");
	            return;
	        }

	      
	        double result = convertCurrency(amount, from, to);

	        if (result == -1) {
	            out.println("<h2 style='color:red;'>Conversion not supported!</h2>");
	            return;
	        }

	        
	        out.println("<h1>Currency Conversion Result</h1>");
	        out.println("<h2>" + amount + " " + from + " = " 
	                + String.format("%.2f", result) + " " + to + "</h2>");
	    }

	  
	    private double convertCurrency(double amount, String from, String to) {

	        double rate = 0;

	        if (from.equals("USD") && to.equals("INR")) rate = 83.0;
	        else if (from.equals("INR") && to.equals("USD")) rate = 1 / 83.0;
	        else if (from.equals("USD") && to.equals("EUR")) rate = 0.92;
	        else if (from.equals("EUR") && to.equals("USD")) rate = 1 / 0.92;
	        else if (from.equals("INR") && to.equals("EUR")) rate = 0.011;
	        else if (from.equals("EUR") && to.equals("INR")) rate = 90.0;
	        else if (from.equals(to)) rate = 1.0;
	        else return -1; // invalid case

	        return amount * rate;
	    }
}
