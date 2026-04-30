package com.shivam.monocept.MovieRateing;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/rating")
public class MovieRateing extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String movieName = request.getParameter("movieName");

    // Validation
    if (movieName == null || movieName.trim().isEmpty()) {
        out.println("<h2 style='color:red;'>Movie name is required!</h2>");
        return;
    }

    
    Map<String, String> movie = getMovieDetails(movieName);

    if (movie == null) {
        out.println("<h2 style='color:red;'>Movie not found!</h2>");
        return;
    }

    
    out.println("<h1>Movie Rating Summary</h1>");
    out.println("<h2>Movie: " + movieName + "</h2>");
    out.println("<p><b>Rating:</b> " + movie.get("rating") + "</p>");
    out.println("<p><b>Genre:</b> " + movie.get("genre") + "</p>");
    out.println("<p><b>Review:</b> " + movie.get("review") + "</p>");
}


private Map<String, String> getMovieDetails(String movieName) {

    Map<String, Map<String, String>> movieData = new HashMap<>();

    Map<String, String> inception = new HashMap<>();
    inception.put("rating", "8.8/10");
    inception.put("genre", "Sci-Fi / Thriller");
    inception.put("review", "Mind-bending and visually stunning.");
    movieData.put("inception", inception);

   
    Map<String, String> interstellar = new HashMap<>();
    interstellar.put("rating", "8.6/10");
    interstellar.put("genre", "Sci-Fi / Drama");
    interstellar.put("review", "Emotional and scientifically engaging.");
    movieData.put("interstellar", interstellar);

    
    Map<String, String> avatar = new HashMap<>();
    avatar.put("rating", "7.8/10");
    avatar.put("genre", "Action / Fantasy");
    avatar.put("review", "Visually rich with strong world-building.");
    movieData.put("avatar", avatar);

    return movieData.get(movieName.toLowerCase());
}
}
