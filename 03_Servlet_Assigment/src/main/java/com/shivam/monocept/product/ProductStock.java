package com.shivam.monocept.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/stock")
public class ProductStock extends HttpServlet {
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String productId = request.getParameter("productId");

	        
	        if (productId == null || productId.trim().isEmpty()) {
	            out.println("Product ID is required!");
	            return;
	        }

	      
	        Map<String, String> product = getProductDetails(productId);

	        if (product == null) {
	            out.println("<h2 style='color:red;'>Product not found!</h2>");
	            return;
	        }

	        int stock = Integer.parseInt(product.get("stock"));
	        String availability = (stock > 0) ? "In Stock" : "Out of Stock";

	       
	        out.println("<h1>Product Stock Details</h1>");
	        out.println("<h2>Product ID: " + productId + "</h2>");
	        out.println("<p><b>Name:</b> " + product.get("name") + "</p>");
	        out.println("<p><b>Stock Count:</b> " + stock + "</p>");
	        out.println("<p><b>Availability:</b> " + availability + "</p>");
	    }

	    
	    private Map<String, String> getProductDetails(String productId) {

	        Map<String, Map<String, String>> inventory = new HashMap<>();

	        
	        Map<String, String> p1 = new HashMap<>();
	        p1.put("name", "Laptop");
	        p1.put("stock", "10");
	        inventory.put("1001", p1);

	        // Product 2
	        Map<String, String> p2 = new HashMap<>();
	        p2.put("name", "Smartphone");
	        p2.put("stock", "0");
	        inventory.put("1002", p2);

	       
	        Map<String, String> p3 = new HashMap<>();
	        p3.put("name", "Headphones");
	        p3.put("stock", "25");
	        inventory.put("1023", p3);

	        return inventory.get(productId);
	    }
}
