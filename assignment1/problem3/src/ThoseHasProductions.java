package edu.neu.ccs.cs5010.assignment1.problem3;

import java.util.ArrayList;

/**
 * A class of those who has productions.
 */
public abstract class ThoseHasProductions extends Artist {

  private ArrayList<String> movies;
  private ArrayList<String> series;
  private ArrayList<String> multiMedias;

  ThoseHasProductions(Name name, int age, String activeYears,
      ArrayList<String> genre, ArrayList<String> awards,
      ArrayList<String> movies, ArrayList<String> series,
      ArrayList<String> multiMedias) throws OutOfAgeRangeException {
    super(name, age, activeYears, genre, awards);
    this.movies = movies;
    this.series = series;
    this.multiMedias = multiMedias;
  }

  public ArrayList<String> getMovies() {
    return movies;
  }

  public void setMovies(ArrayList<String> movies) {
    this.movies = movies;
  }

  public ArrayList<String> getSeries() {
    return series;
  }

  public void setSeries(ArrayList<String> series) {
    this.series = series;
  }

  public ArrayList<String> getMultiMedias() {
    return multiMedias;
  }

  public void setMultiMedias(ArrayList<String> multiMedias) {
    this.multiMedias = multiMedias;
  }
}
