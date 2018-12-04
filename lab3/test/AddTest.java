package edu.neu.ccs.cs5010.lab3;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddTest {
  Num n1 = new Num(1);
  Num n2 = new Num(1);
  Num n3 = new Num(2);
  Add add = new Add(n1, n2);

  @Test
  public void eval() throws Exception {
    assertEquals(add.eval(Context.emptyCtx()), n3);
  }

  @Test
  public void toStringTest() {
    assertEquals(add.toString(), "(1 + 1)");
  }

  @Test
  public void asString() {
    add.asString(new ConcreteVisitor());
  }
  @Test
  public void hashCodeTest() {
    Add addTest = new Add(n1, n2);
    assertEquals(add.hashCode(), addTest.hashCode());
  }
  @Test
  public void EqualTest() {
    Add addTest = new Add(n1, n2);
    Add addNull = new Add(null, null);
    assertTrue(add.equals(addTest));
    assertTrue(add.equals(add));
    assertFalse(add.equals(null));
    assertFalse(addNull.equals(add));
  }
}