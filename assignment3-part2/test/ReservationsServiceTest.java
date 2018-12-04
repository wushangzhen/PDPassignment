package edu.neu.ccs.cs5010.assignment3.part2;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A test class for reservation service.
 */
public class ReservationsServiceTest {
  Theater theater;
  ReservationsService reservationsService;
  private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
  private ByteArrayInputStream bais;
  List<Integer> accessibleSeatList = new ArrayList<>(Arrays.asList(1, 3, 5));
  String[][] testTheaterSeat;

  /**
   * A test for start service.
   * @throws Exception
   */
  @Test
  public void startService() throws Exception {
    String string = "show\n";
    bais = new ByteArrayInputStream(string.getBytes());
    System.setIn(bais);
    reservationsService.startService(true);
  }

  /**
   * A test for set accessible chairs.
   */
  @Test
  public void setAccessible() {
    reservationsService.initialize();
    reservationsService.setAccessible();
    String[][] testTheaterSeat = new String[10][7];
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 7; j++) {
        if (i == 1 || i == 3 || i == 5) {
          testTheaterSeat[i][j] = "=";
          continue;
        }
        testTheaterSeat[i][j] = "_";
      }
    }
    assertEquals(reservationsService.getTheater().getTheaterSeat(), testTheaterSeat);
  }

  /**
   * A test for initialize the chairs.
   */
  @Test
  public void initialize() {
    Theater theaterNull = new Theater("Roxy", 0, 0, accessibleSeatList);
    ReservationsService reservationsServiceNull = new ReservationsService(theaterNull);
    reservationsServiceNull.initialize();
    assertEquals(outStream.toString(), "There is no rows in the theater");
    reservationsService.initialize();
    assertEquals(reservationsService.getTheater().getTheaterSeat(), testTheaterSeat);
  }

  /**
   * A test for order seat.
   */
  @Test
  public void orderSeat() {
    reservationsService.initialize();
    reservationsService.orderSeat(0, 1, true, 2, "shangzhen");
    testTheaterSeat[0][0] = "X";
    testTheaterSeat[0][1] = "X";
    assertEquals(reservationsService.getTheater().getTheaterSeat(), testTheaterSeat);
    Row row = new Row(0, 7, false);
    row.get(0).setReservedFor("shangzhen");
    row.get(1).setReservedFor("shangzhen");
    assertTrue(reservationsService.getTheater().getRows()[0].equals(row));
    reservationsService.orderSeat(0, 2, false, 2, "shangzhen");
    row.get(2).setReservedFor("shangzhen");
    row.get(3).setReservedFor("shangzhen");
    assertTrue(reservationsService.getTheater().getRows()[0].equals(row));
  }

  /**
   * A test for find the available chairs.
   */
  @Test
  public void find() {
    reservationsService.initialize();
    reservationsService.setAccessible();
    Theater theaterTest = new Theater("Roxy", 5, 6, accessibleSeatList);
    ReservationsService reservationsServiceTest = new ReservationsService(theaterTest);
    reservationsServiceTest.initialize();
    assertEquals(reservationsService.find(2, false), 4);
    assertEquals(reservationsServiceTest.find(2, false), 2);
    reservationsService.orderSeat(2, 0, false, 6, "shangzhen");
    assertEquals(reservationsService.find(2, false), 4);
    assertEquals(reservationsService.find(2, true), 5);
    reservationsService.orderSeat(5, 0, false, 6, "shangzhen");
    assertEquals(reservationsService.find(4, true), 3);
    reservationsService.orderSeat(6, 0, false, 6, "shangzhen");
    reservationsService.orderSeat(4, 0, false, 7, "shangzhen");
    assertEquals(reservationsService.find(1, false), 6);
    Theater theaterNull = new Theater("Roxy", 0, 0, accessibleSeatList);
    ReservationsService reservationsServiceNull = new ReservationsService(theaterNull);
    reservationsServiceNull.initialize();
    assertEquals(reservationsServiceNull.find(1, false), -1);
  }


  /**
   * A test for update the chairs.
   */
  @Test
  public void update() {
    reservationsService.initialize();
    reservationsService.setAccessible();
    reservationsService.update(2, 2, "shangzhen");
    reservationsService.update(1, 4, "shangzhen");
    reservationsService.update(1, 2, "shangzhen");
    reservationsService.update(2, 4, "shangzhen");
    orderSeat();
  }

  /**
   * A test for query operations.
   * @throws Exception some io expression.
   */
  @Test
  public void query() throws Exception {
    reservationsService.initialize();
    reservationsService.setAccessible();
    outStream.reset();
    String string1 = "reserve 2";
    String string2 = "yes";
    String string3 = "shangzhen";
    String string4 = "no";
    String string5 = "nnn";
    String string = string1 +"\n"+ string2 + "\n" + string3 + "\n";
    bais = new ByteArrayInputStream(string.getBytes());
    System.setIn(bais);
    reservationsService.query(true);
    String test1 = "What would you like to do?\n"
        + "Do you need wheelchair accessible seats?\n"
        + "What's your name?\n"
        + "I have reserved 2 seats for you at the Roxy in row 6, shangzhen\n";
    assertEquals(outStream.toString(), test1);

    string = "show\n";
    bais = new ByteArrayInputStream(string.getBytes());
    System.setIn(bais);
    reservationsService.query(true);
    String test2 = "What would you like to do?\n"
        + "   A B C D E F G \n"
        + " 1 _ _ _ _ _ _ _ \n"
        + " 2 = = = = = = = \n"
        + " 3 _ _ _ _ _ _ _ \n"
        + " 4 = = = = = = = \n"
        + " 5 _ _ _ _ _ _ _ \n"
        + " 6 = = X X = = = \n"
        + " 7 _ _ _ _ _ _ _ \n"
        + " 8 _ _ _ _ _ _ _ \n"
        + " 9 _ _ _ _ _ _ _ \n"
        + "10 _ _ _ _ _ _ _ \n";
    assertEquals(outStream.toString(), test1 + test2);

    string = "done\n";
    bais = new ByteArrayInputStream(string.getBytes());
    System.setIn(bais);
    reservationsService.query(true);
    assertEquals(outStream.toString(), test1 + test2 + "What would you like to do?\n");

    string = string1 +"\n"+ string4 + "\n" + string3 + "\n";
    bais = new ByteArrayInputStream(string.getBytes());
    System.setIn(bais);
    reservationsService.query(true);
    String test3 = "What would you like to do?\n"
        + "Do you need wheelchair accessible seats?\n"
        + "What's your name?\n"
        + "I have reserved 2 seats for you at the Roxy in row 5, shangzhen\n";
    assertEquals(outStream.toString(), test1 + test2 + "What would you like to do?\n"
        + test3);

    outStream.reset();
    string = string1 +"\n"+ string5 + "\n" + string3 + "\n";
    bais = new ByteArrayInputStream(string.getBytes());
    System.setIn(bais);
    reservationsService.query(true);
    assertEquals(outStream.toString(), "What would you like to do?\n"
        + "Do you need wheelchair accessible seats?\n"
        + "invalid input\n"
        + "What's your name?\n"
        + "Sorry, we don't have that many seats together for you.\n");
  }

  /**
   * A test for print operations.
   * @throws Exception some io exceptions.
   */
  @Test
  public void print() throws Exception {
    String[][] theaterSeat = this.theater.getTheaterSeat();
    int n = 10;
    int m = 7;
    StringBuilder sb = new StringBuilder();
    sb.append("   ");
    for (int i = 0; i < m; i++) {
      sb.append(theater.getRows()[0].get(i).getName() + " ");
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
    String test = sb.toString();
    String string = "show\n";
    bais = new ByteArrayInputStream(string.getBytes());
    System.setIn(bais);
    reservationsService.print();
    assertEquals(outStream.toString(), test);

  }

  @Before
  public void setUp() throws Exception {
   theater = new Theater("Roxy", 10, 7, accessibleSeatList);
    reservationsService = new ReservationsService(theater);
    System.setOut(new PrintStream(outStream));
    testTheaterSeat = new String[10][7];
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 7; j++) {
        testTheaterSeat[i][j] = "_";
      }
    }
  }

  @After
  public void tearDown() throws Exception {
    System.setOut(System.out);
    System.setIn(System.in);

  }

  /**
   * A getters and setters.
   */
  @Test
  public void getTheater() {
    assertEquals(reservationsService.getTheater(), theater);
  }

  @Test
  public void setTheater() {
    reservationsService.initialize();
    Theater theaterTest = new Theater("Roxy", 5, 6, accessibleSeatList);
    reservationsService.setTheater(theaterTest);
    assertEquals(reservationsService.getTheater(), theaterTest);
  }

}