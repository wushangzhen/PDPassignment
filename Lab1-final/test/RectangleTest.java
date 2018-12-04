package edu.neu.ccs.cs5010.lab1.shapes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTest {
  private Rectangle rec = new Rectangle(2.0, 2.0, 2.0, 2.0);
  @Test
  public void area() {
    Assert.assertEquals(rec.area(), 4.0, 1e-8);
  }

  @Test
  public void perimeter() {
    Assert.assertEquals(rec.perimeter(), 2.0 * 2.0 * 2.0, 1e-8);
  }

  @Test
  public void resize() {
  }

  @Test
  public void toString1() {
  }
}