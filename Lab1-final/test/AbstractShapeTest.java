package edu.neu.ccs.cs5010.lab1.shapes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class AbstractShapeTest {
  Point2D point = new Point2D(3.0, 4.0);
  Circle circle = new Circle(point.getX(), point.getY(), 2.0);
  Circle circle2 = new Circle(point.getX(), point.getY(), 2.0);
  @Test
  public void distanceFromOrigin() {
    Assert.assertEquals(point.distToOrigin(), 5.0, 1e-8);
  }

  @Test
  public void compareTo() {
    Assert.assertEquals(circle.compareTo(circle2), 0, 1e-8);
  }
}