package edu.neu.ccs.cs5010.assignment3.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * main function will initialize the service
 */
public class ReservationSystem {

  public static void main(String[] args) throws Exception {
    ReservationsService reservationsService = new ReservationsService(
        new Theater("Roxy", 10, 7,
        new ArrayList<>(Arrays.asList(1, 3, 5))));
    reservationsService.startService(false);
  }
}
