package edu.neu.ccs.cs5010.lab3;
public class Exp extends BinOp {

  /**
   * Create a binary expression exp.
   *
   * @param left the left subexpression
   * @param right the right subexpression
   */
  public Exp(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public Val eval(Context ctx) throws Exception {
    double lVal = left.eval(ctx).getVal() * 1.0;
    double rVal = right.eval(ctx).getVal() * 1.0;
    return new Num((int)Math.pow(lVal, rVal));
  }

  //@Override
  //public String asString(Context ctx) throws Exception {
  //  StringBuilder sb = new StringBuilder();
  //  sb.append("(");
  //  sb.append(this.left.asString(ctx));
  //  sb.append(" ^ ");
  //  sb.append(this.right.asString(ctx));
  //  sb.append(")");
  //  return sb.toString();
  //}
  @Override
  public String asString(Visitor visitor) {
    return visitor.visit(this);
  }
}
