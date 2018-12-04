package edu.neu.ccs.cs5010.lab1.shapes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Point2DTest {
  private Point2D point = new Point2D(3.0,4.0);
  private Point2D point2 = new Point2D(5.0,12.0);
  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void distToOrigin() {
    Assert.assertEquals(point.distToOrigin(), 5.0, 1e-8);
    Assert.assertEquals(point2.distToOrigin(), 13.0, 1e-8);
  }

  @Test
  public void getX() {
    Assert.assertEquals(point.getX(), 3.0, 1e-8);
    Assert.assertEquals(point2.getX(), 5.0, 1e-8);
  }

  @Test
  public void getY() {
    Assert.assertEquals(point.getY(), 4.0, 1e-8);
    Assert.assertEquals(point2.getY(), 12.0, 1e-8);
  }
}