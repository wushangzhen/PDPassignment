package edu.neu.ccs.cs5010.assignment3.part2;

import static org.junit.Assert.*;

import org.junit.Test;

public class SeatTest {
  private final String NAME = "A";
  private final String NAME_RESERVED = "SHANGZHEN";
  private final String NAME_CHANGED = "B";
  private final String NAME_RESERVED_CHANGED = "SHANG";

  Seat seat = new Seat(NAME, NAME_RESERVED);

  @Test
  public void getName() {
    assertEquals(seat.getName(), NAME);
  }

  @Test
  public void setName() {
    seat.setName(NAME_CHANGED);
    assertEquals(seat.getName(), NAME_CHANGED);
  }

  @Test
  public void getReservedFor() {
    assertEquals(seat.getReservedFor(), NAME_RESERVED);
  }

  @Test
  public void setReservedFor() {
    seat.setReservedFor(NAME_RESERVED_CHANGED);
    assertEquals(seat.getReservedFor(), NAME_RESERVED_CHANGED);
  }

  /**
   * A test for override method equal.
   */
  @Test
  public void equals() {
    String str = "";
    Seat newSeat = new Seat(NAME, NAME_RESERVED);
    Seat changeSeat = new Seat(NAME, NAME_RESERVED_CHANGED);
    assertFalse(seat.equals(str));
    assertTrue(seat.equals(seat));
    assertTrue(seat.equals(newSeat));
    assertFalse(seat.equals(changeSeat));
    assertFalse(seat.equals(null));
    newSeat.setReservedFor(null);
    changeSeat.setReservedFor(null);
    assertTrue(newSeat.equals(changeSeat));
  }
}