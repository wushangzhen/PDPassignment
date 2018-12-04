package edu.neu.ccs.cs5010.assignment4.driver;

import java.util.List;

/**
 * A class recode the crash list and moving violation list and none moving violation list.
 */
public class VehicleHistory {

  private List<Crash> crashList;
  private List<MovingViolationInfo> movingViolationInfoList;
  private List<NoneMovingViolationInfo> noneMovingViolationInfo;


  /**
   * A constructor of vehicle history.
   * @param crashList crash list
   * @param movingViolationInfoList moving violation information list
   * @param noneMovingViolationInfo none moving violation information list
   */
  public VehicleHistory(
      List<Crash> crashList,
      List<MovingViolationInfo> movingViolationInfoList,
      List<NoneMovingViolationInfo> noneMovingViolationInfo) {
    this.crashList = crashList;
    this.movingViolationInfoList = movingViolationInfoList;
    this.noneMovingViolationInfo = noneMovingViolationInfo;
  }

  /**
   * Get the crash list.
   *
   * @return crash list
   */
  public List<Crash> getCrashList() {
    return crashList;
  }

  /**
   * A setter of crash list.
   *
   * @param crashList The crash list you want to set
   */
  public void setCrashList(
      List<Crash> crashList) {
    this.crashList = crashList;
  }

  /**
   * A getter for moving violation information list.
   *
   * @return moving violation information list
   */
  public List<MovingViolationInfo> getMovingViolationInfoList() {
    return movingViolationInfoList;
  }

  /**
   * A setter of moving violation information list.
   *
   * @param movingViolationInfoList The parameter you want to set
   */
  public void setMovingViolationInfoList(
      List<MovingViolationInfo> movingViolationInfoList) {
    this.movingViolationInfoList = movingViolationInfoList;
  }

  /**
   * Get the none moving violation information list.
   *
   * @return none moving violation information.
   */
  public List<NoneMovingViolationInfo> getNoneMovingViolationInfo() {
    return noneMovingViolationInfo;
  }

  /**
   * A seter for none moving violation info.
   *
   * @param noneMovingViolationInfo None moving violation information.
   */
  public void setNoneMovingViolationInfo(
      List<NoneMovingViolationInfo> noneMovingViolationInfo) {
    this.noneMovingViolationInfo = noneMovingViolationInfo;
  }
}
