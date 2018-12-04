package edu.neu.ccs.cs5010.lab3;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnaryMinusTest {
  Num n1 = new Num(1);
  UnaryMinus unaryMinus = new UnaryMinus(n1);

  @Test
  public void eval() throws Exception {
    unaryMinus.eval(Context.emptyCtx());
  }

  @Test
  public void asString() {
    unaryMinus.asString(new ConcreteVisitor());
  }
}