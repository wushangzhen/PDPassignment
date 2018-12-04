package edu.neu.ccs.cs5010.assignment3.part2;

import java.util.ArrayList;

public class Row extends ArrayList<Seat> {

  private int rowNum;
  private boolean isAccessible;

  public Row(int rowNum, int number, boolean isAccessible) {
    this.rowNum = rowNum;
    this.ensureCapacity(number);
    this.isAccessible = isAccessible;
    this.init(number);
  }

  /**
   * Initialize the seats
   * @param number number of seats
   */
  public void init(int number) {
    for (char i = 'A'; i < 'A' + number; i++) {
      this.add(new Seat(String.valueOf(i), null));
    }
  }

  /**
   * rowNum getters.
   * @param rowNum number of rows
   */
  public void setRowNum(int rowNum) {
    this.rowNum = rowNum;
  }

  public boolean isAccessible() {
    return isAccessible;
  }

  public void setAccessible(boolean accessible) {
    isAccessible = accessible;
  }

  public int getRowNum() {
    return rowNum;
  }

  /**
   * Overrided the method to compare rows
   * @param o Object value
   * @return whether they are equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Row row = (Row) o;
    if (this.size() == row.size()) {
      int n = this.size();
      boolean equal = true;
      for (int i = 0; i < n; i++) {
        equal = this.get(i).equals(row.get(i));
        if (!equal) {
          return false;
        }
      }
      return true;
    } else {
      return false;
    }
  }

}
