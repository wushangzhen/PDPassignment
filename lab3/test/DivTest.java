package edu.neu.ccs.cs5010.lab3;

import static org.junit.Assert.*;

import org.junit.Test;

public class DivTest {
  Num n1 = new Num(1);
  Num n2 = new Num(1);
  Div div = new Div(n1, n2);

  @Test
  public void eval() throws Exception{
    div.eval(Context.emptyCtx());
  }

  @Test
  public void asString() {
    div.asString(new ConcreteVisitor());
  }
}