package edu.neu.ccs.cs5010.lab1.shapes;

/**
 * This class represents a 2D point. This point is denoted in Cartesian coordinates as (x,y).
 */
public class Point2D {

  private double xcoor;
  private double ycoor;

  /**
   * Construct a 2d point with the given coordinates.
   *
   * @param xcoor the x-coordinate of this point
   * @param ycoor the y-coordinate of this point
   */
  public Point2D(double xcoor, double ycoor) {
    this.xcoor = xcoor;
    this.ycoor = ycoor;
  }

  /**
   * Compute and return the Euclidean distance of this point to the origin.
   *
   * @return the euclidean distance
   */

  public double distToOrigin() {
    return Math.sqrt(xcoor * xcoor
        + ycoor * ycoor);
  }

  /**
   * Return the x-coordinate of this point.
   *
   * @return x-coordinate of this point
   */
  public double getX() {
    return xcoor;
  }

  /**
   * Return the y-coordinate of this point.
   *
   * @return y-coordinate of this point
   */
  public double getY() {
    return ycoor;
  }
}