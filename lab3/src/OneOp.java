package edu.neu.ccs.cs5010.lab3;
public abstract class OneOp extends Op {
  protected Expression expression;

  public OneOp(Expression expression) {
    this.expression = expression;
  }
}
