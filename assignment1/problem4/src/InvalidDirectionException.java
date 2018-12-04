package edu.neu.ccs.cs5010.assignment1.problem4;

/**
 * An exception throws when invalid direction changes happens.
 */
public class InvalidDirectionException extends Exception {

  InvalidDirectionException() {
    System.out.println("The process of changing direction is invalid");
  }
}
