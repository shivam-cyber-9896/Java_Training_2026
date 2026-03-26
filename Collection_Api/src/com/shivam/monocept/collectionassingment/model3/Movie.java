package com.shivam.monocept.collectionassingment.model3;

import java.util.Comparator;

public class Movie implements Comparator<Movie> {
       String MovieTitle;
       int year;
       public Movie(String MovieTitle,int year)
       {
    	   this.year=year;
    	   this.MovieTitle=MovieTitle;
       }
       
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Movie [MovieTitle=" + MovieTitle + ", year=" + year + "]";
	}

	public String getMovieTitle() {
		return MovieTitle;
	}

	   public int getYear() {
		   return year;
	   }

	   
	@Override
	public int compare(Movie o1, Movie o2) {
		int yearCompare=o2.getYear()-o1.getYear();
		if(yearCompare!=0)
			return yearCompare;
		return o1.getMovieTitle().compareTo(o2.getMovieTitle());
	}

}
