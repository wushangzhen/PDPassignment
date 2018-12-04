package edu.neu.ccs.cs5010.assignment4.pool;

import edu.neu.ccs.cs5010.assignment4.driver.PerspectiveDriver;
import edu.neu.ccs.cs5010.assignment4.driver.MovingViolationInfo;
import edu.neu.ccs.cs5010.assignment4.driver.VehicleInfo;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * A comparator will sort the driver by their last name.
 */
class DriverComparator implements Comparator<PerspectiveDriver>, Serializable {

  @Override
  public int compare(PerspectiveDriver o1, PerspectiveDriver o2) {
    return o1.getName().getFirstName().compareTo(o2.getName().getFirstName());
  }
}

/**
 * A pool class for accepted driver.
 */
public class AcceptedDriverPool {

  Map<String, Set<PerspectiveDriver>> nameToDriver;
  Map<PerspectiveDriver, Set<VehicleInfo>> driverToVehicle;
  Map<VehicleInfo, Set<PerspectiveDriver>> vehicleToDriver;

  /**
   * A constructor for accepted driver poll class.
   * @param nameToDriver map of name to driver
   * @param driverToVehicle map of driver to vehicle
   * @param vehicleToDriver map of vehicle to driver
   */
  public AcceptedDriverPool(
      Map<String, Set<PerspectiveDriver>> nameToDriver,
      Map<PerspectiveDriver, Set<VehicleInfo>> driverToVehicle,
      Map<VehicleInfo, Set<PerspectiveDriver>> vehicleToDriver) {
    this.nameToDriver = nameToDriver;
    this.driverToVehicle = driverToVehicle;
    this.vehicleToDriver = vehicleToDriver;
  }

  /**
   * Print the driver information by last name.
   *
   * @param lastName A String will be used to search
   */
  public void provideDriverInfo(String lastName) {
    if (!nameToDriver.containsKey(lastName)) {
      System.out.println("No registered driver found");
    } else {
      Set<PerspectiveDriver> drivers = nameToDriver.get(lastName);
      for (PerspectiveDriver driver : drivers) {
        printDriverInfo(driver);
      }
    }
  }

  /**
   * print driver information according to driver.
   *
   * @param driver A perspective driver
   */
  public void printDriverInfo(PerspectiveDriver driver) {
    System.out.println(driver.getName().toString());
    Set<VehicleInfo> vehicles = driverToVehicle.get(driver);
    System.out.print(vehicles.size());
    for (VehicleInfo vehicle : vehicles) {
      System.out.println("\t" + vehicle.toString());
    }
    if (driver.getDriverHistory().getMovingVioList().size() > 0
        || driver.getDriverHistory().getNoneMovingVioList().size() > 0) {
      System.out.println("\tDriving violations:");
      List<MovingViolationInfo> listVioMoving = driver.getDriverHistory().getMovingVioList();
      for (MovingViolationInfo vio : listVioMoving) {
        System.out.println("\t\t" + vio.getMovingVioType().toString());
      }
      List<MovingViolationInfo> listVioNoneMoving = driver.getDriverHistory().getMovingVioList();
      for (MovingViolationInfo vio : listVioNoneMoving) {
        System.out.println("\t\t" + vio.getMovingVioType().toString());
      }
    }
  }

  /**
   * Add driver to pool.
   *
   * @param driver The perspective driver object
   * @return whether it will be added
   * @throws Exception This will be the same driver same car exception
   */
  public boolean addDriver(PerspectiveDriver driver) throws Exception {
    if (driverToVehicle.containsKey(driver)) {
      if (driverToVehicle.get(driver).contains(driver.getVehicleInfo())) {
        throw new SameDriverSameCarException();
      }
    }
    nameToDriver.putIfAbsent(driver.getName().getLastName(),
        new TreeSet<>(new DriverComparator()));
    nameToDriver.get(driver.getName().getLastName()).add(driver);
    driverToVehicle.putIfAbsent(driver, new HashSet<>());
    driverToVehicle.get(driver).add(driver.getVehicleInfo());
    vehicleToDriver.putIfAbsent(driver.getVehicleInfo(), new HashSet<>());
    vehicleToDriver.get(driver.getVehicleInfo()).add(driver);
    return true;
  }

  /**
   * Get the map name to driver.
   *
   * @return map name to driver
   */
  public Map<String, Set<PerspectiveDriver>> getNameToDriver() {
    return nameToDriver;
  }

  /**
   * setter for name to driver.
   *
   * @param nameToDriver map name to driver
   */
  public void setNameToDriver(
      Map<String, Set<PerspectiveDriver>> nameToDriver) {
    this.nameToDriver = nameToDriver;
  }

  /**
   * Getter of driver to vehicle.
   *
   * @return map of driver to vehicle
   */
  public Map<PerspectiveDriver, Set<VehicleInfo>> getDriverToVehicle() {
    return driverToVehicle;
  }

  public void setDriverToVehicle(
      Map<PerspectiveDriver, Set<VehicleInfo>> driverToVehicle) {
    this.driverToVehicle = driverToVehicle;
  }

  /**
   * Getter of vehicle to driver map;
   *
   * @return map of vehicle to driver.
   */
  public Map<VehicleInfo, Set<PerspectiveDriver>> getVehicleToDriver() {
    return vehicleToDriver;
  }

  public void setVehicleToDriver(
      Map<VehicleInfo, Set<PerspectiveDriver>> vehicleToDriver) {
    this.vehicleToDriver = vehicleToDriver;
  }
}
