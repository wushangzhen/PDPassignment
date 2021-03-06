package edu.neu.ccs.cs5010.assignment1.problem3;

import java.util.ArrayList;

/**
 * A class represents dancers.
 */
public class Dancer extends ThoseHasProductions {

  Dancer(Name name, int age, String activeYears, ArrayList<String> genre,
      ArrayList<String> awards, ArrayList<String> movies, ArrayList<String> series,
      ArrayList<String> multimedia) throws OutOfAgeRangeException {
    super(name, age, activeYears, genre, awards, movies, series, multimedia);
  }
}
