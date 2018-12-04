package edu.neu.ccs.cs5010.lab3;
/**
 *
 */
abstract class Val implements Expression, OpPart {

  abstract public Integer getVal();
  public void trace() {
    System.out.println(getVal());
  }

}
