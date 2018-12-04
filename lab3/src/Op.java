package edu.neu.ccs.cs5010.lab3;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
abstract class Op implements Expression, OpPart {

  protected List<String> path;
  public Op() {
    path = new ArrayList<>();
  }

  @Override
  public void trace() {
    for (int i = 0; i < this.path.size() - 1; i++) {
      System.out.printf("%-3s", i + 1 + ".");
      System.out.printf("%-3s", this.path.get(i) + "\n");
      if (i + 1 < this.path.size()) {
        System.out.printf("%-3s", this.path.get(i + 1) + "\n");
      }
    }
  }

}
