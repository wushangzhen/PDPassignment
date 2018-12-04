package edu.neu.ccs.cs5010.lab1.shapes;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircleTest {
  private Circle circle = new Circle(2.0, 2.0, 2.0);

  @Test
  public void area() {
    assertEquals(circle.area(), 2.0 * 2.0 * Math.PI, 1e-8);
  }

  @Test
  public void perimeter() {
    assertEquals(circle.perimeter(), 2.0 * 2.0 * Math.PI, 1e-8);
  }

  @Test
  public void resize() {
    //assertEquals(circle.resize(2), new Circle(2.0, 2.0, Math.sqrt(2.0) * 2.0));
  }

  @Test
  public void toString1() {
    //assertEquals(circle.toString(), "Circle: center (2.0,2.0) radius 2.0");
  }
}