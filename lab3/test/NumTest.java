package edu.neu.ccs.cs5010.lab3;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumTest {
  Num n1 = new Num(1);
  Num n2 = new Num(1);


  @Test
  public void eval() {
    n1.eval(Context.emptyCtx());
  }

  @Test
  public void trace() {
    n1.trace();
  }

  @Test
  public void hashCodeTest() {
  }

  @Test
  public void equals() {
  }

  @Test
  public void toStringTest() {
    n1.toString();
  }

  @Test
  public void getVal() {
    n1.getVal();
  }

  @Test
  public void asString() {
    n1.asString(new ConcreteVisitor());
  }
}