package edu.neu.ccs.cs5010.assignment3.part2;

public class Seat {

  private String name;
  private String reservedFor;

  public Seat(String name, String reservedFor) {
    this.name = name;
    this.reservedFor = reservedFor;
  }

  /**
   * name getters.
   * @return String of name
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getReservedFor() {
    return reservedFor;
  }

  public void setReservedFor(String reservedFor) {
    this.reservedFor = reservedFor;
  }

  /**
   * Override the equal method to compare with seats.
   * @param o Object o represents any object
   * @return A boolean represent whether they are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Seat seat = (Seat) o;
    if (this.name.equals(seat.getName())) {
      if ((this.reservedFor == null && seat.getReservedFor() == null)
          || this.reservedFor.equals(seat.getReservedFor())) {
        return true;
      }
    }
    return false;
  }
}
