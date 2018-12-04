package edu.neu.ccs.cs5010.lab3;

import static org.junit.Assert.*;

import org.junit.Test;

public class DefineTest {
  Define define = new Define(new Var("x"), new Num(1));

  @Test
  public void eval() throws Exception{
    define.eval(Context.emptyCtx());
  }

  @Test
  public void trace() {
    define.trace();
  }
}