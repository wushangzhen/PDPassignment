package edu.neu.ccs.cs5010.lab1.shapes;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShapeTest {
  Point2D point = new Point2D(3.0, 4.0);
  Rectangle rec = new Rectangle(2.0, 2.0, 2.0, 2.0);

  @Test
  public void distanceFromOrigin() {
    assertEquals(point.distToOrigin(), 5.0, 1e-8);

  }

  @Test
  public void area() {
    assertEquals(rec.area(), 4.0, 1e-8);
  }

  @Test
  public void perimeter() {
    assertEquals(rec.area(), 4.0, 1e-8);
  }

  @Test
  public void resize() {
  }
}