package edu.neu.ccs.cs5010.lab3;
public class IllegalParameterException extends Exception{


  public IllegalParameterException() {
    System.out.println("The parameter cannot be zero!");
  }
}
