package com.shivam.monocept.dopostApi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/feedback")
public class FeedBackServletApi extends HttpServlet {

    private static List<String> feedbackList = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String productId = request.getParameter("productId");
        String ratingStr = request.getParameter("rating");
        String review = request.getParameter("review");

        String error = validateInput(productId, ratingStr, review);

        if (error != null) {
            out.println("<h3 style='color:red;'>" + error + "</h3>");
            return;
        }

        int rating = Integer.parseInt(ratingStr);

        String feedback = "Product: " + productId + ", Rating: " + rating + ", Review: " + review;
        feedbackList.add(feedback);

        out.println("<h1 style='color:green;'>Thank You for Your Feedback!</h1>");
        out.println("<p><b>Product ID:</b> " + productId + "</p>");
        out.println("<p><b>Rating:</b> " + rating + "</p>");

        out.println("<h3>All Feedback:</h3>");
        for (String fb : feedbackList) {
            out.println("<p>" + fb + "</p>");
        }
    }

  
    private String validateInput(String productId, String ratingStr, String review) {

        if (productId == null || productId.trim().isEmpty()) {
            return "Product ID is required!";
        }

        int rating;
        try {
            rating = Integer.parseInt(ratingStr);
            if (rating < 1 || rating > 5) {
                return "Rating must be between 1 and 5!";
            }
        } catch (Exception e) {
            return "Invalid rating!";
        }

        if (review == null || review.trim().isEmpty()) {
            return "Review cannot be empty!";
        }

        return null; 
    }
}