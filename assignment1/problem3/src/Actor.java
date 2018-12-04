package edu.neu.ccs.cs5010.assignment1.problem3;

import java.util.ArrayList;

/**
 * An class represents Actor.
 */
public class Actor extends ThoseHasProductions {

  Actor(Name name, int age, String activeYears, ArrayList<String> genre,
      ArrayList<String> awards, ArrayList<String> movies, ArrayList<String> series,
      ArrayList<String> multimedia) throws OutOfAgeRangeException {
    super(name, age, activeYears, genre, awards, movies, series, multimedia);
  }
}
