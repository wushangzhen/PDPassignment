package edu.neu.ccs.cs5010.lab3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class MulTest {
  Num n1 = new Num(1);
  Num n2 = new Num(1);
  Mul mul = new Mul(n1, n2);

  @Test
  public void eval() throws Exception {
    assertEquals(mul.eval(Context.emptyCtx()), n1);
  }

  @Test
  public void asString() {
    mul.asString(new ConcreteVisitor());
  }
}