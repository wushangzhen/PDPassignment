package edu.neu.ccs.cs5010.assignment4.driver;

/**
 * A class will be used to deliver the information of moving type.
 */
public enum MovingVioType {

  /**
   * An override method of toString to get standard output.
   */
  DISTRACTED_DRIVING {
    @Override
    public String toString() {
      return "Distracted driving";
    }
  },
  RECKLESS_DRIVING {
    @Override
    public String toString() {
      return "Reckless driving";
    }
  },
  SPEEDING {
    @Override
    public String toString() {
      return "Speeding";
    }
  },
  DRIVING_UNDER_INFLUENCE {
    @Override
    public String toString() {
      return "Driving under influence";
    }
  },
  FAILURE_TO_RESPECT_TRAFFIC_SIGNS {
    @Override
    public String toString() {
      return "Failure to respect traffic signs";
    }
  },
  DRIVING_WITHOUT_VALID_LICENCE {
    @Override
    public String toString() {
      return "Driving without a valid license";
    }
  },
  DRIVING_WITHOUT_VALID_INSURANCE {
    @Override
    public String toString() {
      return "Driving without a valid insurance";
    }
  }
}
