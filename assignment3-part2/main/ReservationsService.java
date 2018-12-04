package edu.neu.ccs.cs5010.assignment3.part2;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;

public class ReservationsService {

  Theater theater;

  public ReservationsService(Theater theater) {
    this.theater = theater;
  }

  /**
   * A method will start the whole progress.
   * @param forTest represent whether if it is for test or for user use
   * @throws Exception May have some IO exception
   */
  public void startService(boolean forTest) throws Exception {
    initialize();
    setAccessible();
    if (forTest) {
      query(true);
    } else {
      query(false);
    }
  }

  /**
   * A method to set the accessible chairs.
   */
  public void setAccessible() {
    String[][] theaterSeat = this.theater.getTheaterSeat();
    for (int i : this.theater.getAccessibleRowList()) {
      for (int j = 0; j < theaterSeat[0].length; j++) {
        if (i < theaterSeat.length) {
          theaterSeat[i][j] = "=";
        }
      }
    }
    this.theater.setTheaterSeat(theaterSeat);
  }

  /**
   * Initialize the whole theater service.
   */
  public void initialize() {
    String[][] theaterSeat = this.theater.getTheaterSeat();
    Row[] rows = this.theater.getRows();
    if (rows == null || rows.length == 0) {
      System.out.print("There is no rows in the theater");
      return;
    }
    int n = rows.length;
    int m = rows[0].size();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        theaterSeat[i][j] = "_";
      }
    }
    this.theater.setTheaterSeat(theaterSeat);
  }

  /**
   * A method to order seat.
   * @param rowth The number of row
   * @param index The number of position
   * @param toLeft whether they are on the left
   * @param number The reservation number
   * @param name reserver name
   */
  public void orderSeat(int rowth, int index, boolean toLeft, int number, String name) {
    String[][] theaterSeat = this.theater.getTheaterSeat();
    Row[] rows = this.theater.getRows();
    if (toLeft) {
      for (int i = 0; i < number; i++) {
        theaterSeat[rowth][index] = "X";
        rows[rowth].get(index).setReservedFor(name);
        index--;
      }
    }
    if (!toLeft) {
      for (int i = 0; i < number; i++) {
        theaterSeat[rowth][index] = "X";
        rows[rowth].get(index).setReservedFor(name);
        index++;
      }
    }
    this.theater.setTheaterSeat(theaterSeat);
  }

  /**
   * find the row with enough chairs.
   * @param number number of chairs
   * @param isAccessible whether if they want accessible chairs
   * @return number of row
   */
  public int find(int number, boolean isAccessible) {
    List<Integer> accessibleRowList = this.theater.getAccessibleRowList();
    String[][] theaterSeat = this.theater.getTheaterSeat();
    Row[] rows = this.theater.getRows();
    int n = theaterSeat.length;
    HashSet<Integer> hashSet = new HashSet<>();
    for (int i : accessibleRowList) {
      hashSet.add(i);
    }
    int upper = 0;
    int lower = 0;
    if (n % 2 == 0) {
      upper = n / 2 - 1;
      lower = n / 2;
    } else {
      upper = n / 2;
      lower = n / 2;
    }
    int countNotOrdered;
    while (upper >= 0 && lower < n) {
      countNotOrdered = 0;
      if (isAccessible == true && !hashSet.contains(upper)) {
      } else {
        for (String str : theaterSeat[upper]) {
          if (str.equals("_")) {
            countNotOrdered++;
          }
          if (isAccessible == true && str.equals("=")) {
            countNotOrdered++;
          }
          if (countNotOrdered >= number) {
            return upper;
          } else if (str.equals("X")) {
            countNotOrdered = 0;
          }
        }
      }
      upper--;
      countNotOrdered = 0;
      if (isAccessible == true && !hashSet.contains(lower)) {
      } else {
        for (String str : theaterSeat[lower]) {
          if (str.equals("_")) {
            countNotOrdered++;
          }
          if (isAccessible == true && str.equals("=")) {
            countNotOrdered++;
          }
          if (countNotOrdered >= number) {
            return lower;
          } else if (str.equals("X")) {
            countNotOrdered = 0;
          }
        }
      }
      lower++;
    }
    return -1;
  }

  /**
   * update the reservation service.
   * @param rowth the number of row
   * @param number the number of seats
   * @param name the reserver name
   */
  public void update(int rowth, int number, String name) {
    String[][] theaterSeat = this.theater.getTheaterSeat();
    Row[] rows = this.theater.getRows();
    int len = theaterSeat[rowth].length;
    int middle = len / 2;
    int left = middle;
    int right = middle;
    boolean toLeft = true;
    while (left >= 0 && right < len) {
      if (theaterSeat[rowth][left].equals("_")
          || theaterSeat[rowth][left].equals("=")) {
        if (left - 0 >= number) {
          orderSeat(rowth, left, toLeft, number, name);
          return;
        } else {
          orderSeat(rowth, number - 1, toLeft, number, name);
          return;
        }
      }
      left--;
      if (theaterSeat[rowth][right].equals("_")
          || theaterSeat[rowth][right].equals("=")) {
        if (len - right >= number) {
          toLeft = !toLeft;
          orderSeat(rowth, right, toLeft, number, name);
          return;
        } else {
          orderSeat(rowth, len - number, toLeft, number, name);
        }
      }
      right++;
    }
  }

  /**
   * A main query for the service.
   * @param forTest whether it is for the test
   * @throws IOException may have some IO exception
   */
  public void query(boolean forTest) throws IOException {
    int orderSeatNumber = this.theater.getOrderSeatNumber();
    System.out.println("What would you like to do?");
    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    String text = buf.readLine();
    if (text.equals("done")) {
      if (forTest) {
        return;
      } else {
        System.exit(0);
      }
    }
    if (text.equals("show")) {
      print();
      if (!forTest) {
        query(forTest);
      }
    }
    if (text.startsWith("reserve")) {
      String[] tc = text.split(" ");
      orderSeatNumber = parseInt(tc[tc.length - 1]);
      System.out.println("Do you need wheelchair accessible seats?");
      text = buf.readLine();
      int rowth = -1;
      if (text.equals("yes")) {
        rowth = find(orderSeatNumber, true);
      } else if (text.equals("no")) {
        rowth = find(orderSeatNumber, false);
        //if (rowth == -1) {
        //  rowth = find(orderSeatNumber, true);
        //}
      } else {
        System.out.println("invalid input");
        if (!forTest) {
          query(forTest);
        }
      }
      System.out.println("What's your name?");
      text = buf.readLine();
      if (rowth != -1) {
        update(rowth, orderSeatNumber, text);
        System.out.println("I have reserved " + orderSeatNumber
            + " seats for you at the " + this.theater.getName() + " in row "
            + (rowth + 1) + ", " + text);
        if (!forTest) {
          query(forTest);
        }
      } else {
        System.out.println("Sorry, we don't have that many seats together for you.");
        if (!forTest) {
          query(forTest);
        }
      }
    } else {
      if (!forTest) {
        System.out.println("Invalid service, please input again");
        query(forTest);
      }
    }
  }

  /**
   * print the theater seats.
   */
  public void print() {
    Row[] rows = this.theater.getRows();
    String[][] theaterSeat = this.theater.getTheaterSeat();
    int n = rows.length;
    int m = rows[0].size();
    StringBuilder sb = new StringBuilder();
    sb.append("   ");
    for (int i = 0; i < m; i++) {
      sb.append(rows[0].get(i).getName() + " ");
    }
    sb.append("\n");
    for (int i = 0; i < n; i++) {
      if (i < 9) {
        sb.append(" ");
      }
      sb.append(i + 1);
      sb.append(" ");
      for (int j = 0; j < m; j++) {
        sb.append(theaterSeat[i][j] + " ");
      }
      sb.append("\n");
    }
    System.out.print(sb.toString());
  }

  public Theater getTheater() {
    return theater;
  }

  public void setTheater(Theater theater) {
    this.theater = theater;
  }
}
