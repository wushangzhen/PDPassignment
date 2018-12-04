package edu.neu.ccs.cs5010.assignment1.problem3;

import java.util.ArrayList;

/**
 * A class represents musician.
 */
public class Musician extends Artist {

  Musician(Name name, int age, String activeYears, ArrayList<String> genre,
      ArrayList<String> awards) throws OutOfAgeRangeException {
    super(name, age, activeYears, genre, awards);
  }
}
