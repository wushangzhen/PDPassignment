package edu.neu.ccs.cs5010.assignment3.part2;

import java.util.List;

/**
 * A class represent theater
 */
public class Theater {

  private String name;
  private Row[] rows;
  private String[][] theaterSeat;
  private int orderSeatNumber = 0;
  private List<Integer> accessibleRowList;

  public Theater(String name, int numberOfRows, int seatNumOfARow,
      List<Integer> accessibleRowList) {
    this.name = name;
    this.theaterSeat = new String[numberOfRows][seatNumOfARow];
    this.accessibleRowList = accessibleRowList;
    initRows(numberOfRows, seatNumOfARow);
  }

  /**
   * initialize the rowsx
   * @param numberOfRows number of rows
   * @param seatNumOfARow seat number
   */
  public void initRows(int numberOfRows, int seatNumOfARow) {
    this.rows = new Row[numberOfRows];
    for (int i = 0; i < numberOfRows; i++) {
      rows[i] = new Row(i, seatNumOfARow, false);
    }
  }


  /**
   * All getters and setters
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Row[] getRows() {
    return rows;
  }

  public void setRows(Row[] rows) {
    this.rows = rows;
  }

  public String[][] getTheaterSeat() {
    return theaterSeat;
  }

  public void setTheaterSeat(String[][] theaterSeat) {
    this.theaterSeat = theaterSeat;
  }

  public int getOrderSeatNumber() {
    return orderSeatNumber;
  }

  public void setOrderSeatNumber(int orderSeatNumber) {
    this.orderSeatNumber = orderSeatNumber;
  }

  public List<Integer> getAccessibleRowList() {
    return accessibleRowList;
  }

  public void setAccessibleRowList(List<Integer> accessibleRowList) {
    this.accessibleRowList = accessibleRowList;
  }
}
