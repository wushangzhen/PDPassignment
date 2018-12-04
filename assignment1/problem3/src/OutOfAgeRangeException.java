package edu.neu.ccs.cs5010.assignment1.problem3;

/**
 * An Exception throws when age is out of range.
 */
public class OutOfAgeRangeException extends Exception {

  OutOfAgeRangeException() {
    System.out.println("The age is not in [0, 128]");
  }


}
