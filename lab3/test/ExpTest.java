package edu.neu.ccs.cs5010.lab3;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExpTest {
  Num n1 = new Num(1);
  Num n2 = new Num(1);
  Exp exp = new Exp(n1, n2);

  @Test
  public void eval() throws Exception {
    exp.eval(Context.emptyCtx());
  }

  @Test
  public void asString() {
    exp.asString(new ConcreteVisitor());

  }
}