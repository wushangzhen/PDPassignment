package edu.neu.ccs.cs5010.assignment4.driver;

import java.util.List;
import java.util.Objects;

/**
 * Driver history class includes all of the moving violation and none moving violations.
 */
public class DriverHistory {

  private List<NoneMovingViolationInfo> noneMovingVioList;
  private List<MovingViolationInfo> movingVioList;

  public DriverHistory(
      List<NoneMovingViolationInfo> noneMovingVioList,
      List<MovingViolationInfo> movingVioList) {
    this.noneMovingVioList = noneMovingVioList;
    this.movingVioList = movingVioList;
  }

  /**
   * Auto generate equals and hashCode method.
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    DriverHistory that = (DriverHistory) object;
    return Objects.equals(noneMovingVioList, that.noneMovingVioList)
        && Objects.equals(movingVioList, that.movingVioList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(noneMovingVioList, movingVioList);
  }

  /**
   * Getter and setters for fields.
   */
  public void setNoneMovingVioList(
      List<NoneMovingViolationInfo> noneMovingVioList) {
    this.noneMovingVioList = noneMovingVioList;
  }

  public void setMovingVioList(
      List<MovingViolationInfo> movingVioList) {
    this.movingVioList = movingVioList;
  }

  public List<NoneMovingViolationInfo> getNoneMovingVioList() {
    return noneMovingVioList;
  }

  public List<MovingViolationInfo> getMovingVioList() {
    return movingVioList;
  }
}
