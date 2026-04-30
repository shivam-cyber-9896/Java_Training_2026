package com.shivam.monocept.weather;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/weather")
public class WeatherServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String city = request.getParameter("city");

        
        if (city == null || city.trim().isEmpty()) {
            out.println("<h2 style='color:red;'>Error: City name cannot be empty!</h2>");
            return;
        }

        city = city.toLowerCase();

        String temperature = "";
        String humidity = "";
        String forecast = "";

        switch (city) {
            case "delhi":
                temperature = "40°C";
                humidity = "30%";
                forecast = "Hot and Dry";
                break;

            case "mumbai":
                temperature = "32°C";
                humidity = "75%";
                forecast = "Humid with chances of rain";
                break;

            case "chandigarh":
                temperature = "35°C";
                humidity = "50%";
                forecast = "Sunny";
                break;

            default:
                out.println("<h2 style='color:red;'>Invalid City! No data available.</h2>");
                return;
        }

       
        out.println("<h1>Weather Report</h1>");
        out.println("<h2>City: " + city.toUpperCase() + "</h2>");
        out.println("<p>Temperature: " + temperature + "</p>");
        out.println("<p>Humidity: " + humidity + "</p>");
        out.println("<p>Forecast: " + forecast + "</p>");
    }
}
