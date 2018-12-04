package edu.neu.ccs.cs5010.lab3;

import java.awt.SystemTray;
import java.util.List;

/**
 *
 */
public class Add extends BinOp {

  /**
   * @param left
   * @param right
   */
  public Add(Expression left, Expression right) {
    super(left, right);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Val eval(Context ctx) throws Exception {
    this.path.add(this.toString());
    Num num = new Num(this.left.eval(ctx).getVal() + this.right.eval(ctx).getVal());
    this.left = this.left.eval(ctx);
    this.right = this.right.eval(ctx);
    this.path.add(this.toString());
    this.path.add(num.toString());
    return num;
  }

  // (3 - (1 + 2))
  // (3 - 3)
  // 0

  //@Override
  //public String asString(Context ctx) throws Exception {
  //  StringBuilder sb = new StringBuilder();
  //  sb.append("(");
  //  sb.append(this.left.asString(ctx));
  //  sb.append(" + ");
  //  sb.append(this.right.asString(ctx));
  //  sb.append(")");
  //  return sb.toString();
  //}

  @Override
  public String toString() {
    return "(" + left + " + " + right + ")";
  }

  @Override
  public String asString(Visitor visitor) {
    return visitor.visit(this);
  }
}
