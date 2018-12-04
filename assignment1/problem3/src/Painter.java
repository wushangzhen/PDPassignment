package edu.neu.ccs.cs5010.assignment1.problem3;

import java.util.ArrayList;

/**
 * A class represents painters.
 */
public class Painter extends Artist {

  Painter(Name name, int age, String activeYears, ArrayList<String> genre,
      ArrayList<String> awards) throws OutOfAgeRangeException {
    super(name, age, activeYears, genre, awards);
  }
}
