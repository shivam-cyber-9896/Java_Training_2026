package com.shivam.monocept.cartservlet;

import java.io.IOException;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String[] selectedProducts = request.getParameterValues("product");

        HttpSession session = request.getSession();

       
        List<String> cart = (List<String>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        if (selectedProducts != null) {
            for (String p : selectedProducts) {
                cart.add(p);
            }
        }

        session.setAttribute("cart", cart);

        response.sendRedirect("productlist.jsp");
    }
}