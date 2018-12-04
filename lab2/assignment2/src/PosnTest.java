package edu.neu.ccs.cs5010.lab2.assignment2;

import org.junit.Assert;
import org.junit.Test;

public class PosnTest {
  private final Integer X = 1;
  private final Integer ExpectedX = 1;
  private final Integer Y = 1;
  private final Integer ExpectedY = 1;
  Posn posn = new Posn(X, Y);

  @Test
  public void getX() {
    Assert.assertEquals(posn.getX(), ExpectedX);
  }

  @Test
  public void getY() {
    Assert.assertEquals(posn.getY(), ExpectedY);
  }

  @Test
  public void equals() {
    Assert.assertTrue(posn.equals(posn));
    Assert.assertFalse(posn.equals(null));
    Assert.assertFalse(posn.equals(X));
    Posn posnTest = new Posn(X, Y);
    Posn posnTestForNullX = new Posn(null, Y);
    Assert.assertFalse(posnTestForNullX.equals(posn));
    Posn posnTestForNullY = new Posn(X, null);
    Assert.assertFalse(posnTestForNullY.equals(posn));
    Assert.assertFalse(posn.equals(posnTestForNullX));
    Assert.assertFalse(posn.equals(posnTestForNullY));
    Posn posnTestForNull = new Posn(null, null);
    Assert.assertFalse(posn.equals(posnTestForNull));
    Assert.assertTrue(posn.equals(posnTest));
    Posn posnTestForTransitive = new Posn(X, Y);
    Posn posn2 = new Posn(2, 2);
    Assert.assertFalse(posn.equals(posn2));
    Posn posn3 = new Posn(1, 100);
    Assert.assertFalse(posn.equals(posn3));
    Assert.assertTrue(posn.equals(posnTest) && posnTest.equals(posnTest));
    // Symmetric
    Assert.assertTrue(posn.equals(posn)); // reflexive
    if (posn.equals(posnTest)) {
      if (posnTest.equals(posnTestForTransitive)) {
        Assert.assertTrue(posn.equals(posnTestForTransitive));
      }
    }
    Assert.assertFalse(posn.equals(null));
    for (int i = 0; i < 10; i++) {
      posn.equals(posnTest);
    }
    getX();
    getY();
  }

  @Test
  public void hashCodeTest() {
    Posn posnTest = new Posn(X, Y);
    if (posn.equals(posnTest)) {
      Assert.assertTrue(posn.hashCode() == posnTest.hashCode());
    }
    final Integer DX = 2;
    Posn posnTestForFalse = new Posn(DX, Y);
    if (posn.equals(posnTestForFalse)) {
      Assert.assertFalse(posn.hashCode() == posnTestForFalse.hashCode());
    }
    Posn posn1 = new Posn(null, null);
    Assert.assertFalse(posn.hashCode() == posn1.hashCode());
  }

  @Test
  public void toStringTest() {
    final String STRING = "Posn{" + "x=" + X + ", y=" + Y + '}';
    Assert.assertEquals(posn.toString(), STRING);
  }
}