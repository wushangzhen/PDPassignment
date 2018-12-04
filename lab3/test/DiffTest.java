package edu.neu.ccs.cs5010.lab3;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiffTest {
  Num n1 = new Num(1);
  Num n2 = new Num(1);
  Diff diff = new Diff(n1, n2);

  @Test
  public void eval() throws Exception {
    diff.eval(Context.emptyCtx());
  }

  @Test
  public void toStringTest() {
    diff.toString();
  }

  @Test
  public void asString() {
    diff.asString(new ConcreteVisitor());
  }
}