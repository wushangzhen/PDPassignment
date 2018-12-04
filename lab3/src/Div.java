package edu.neu.ccs.cs5010.lab3;
public class Div extends BinOp {
  /**
   * @param left
   * @param right
   */
  public Div(Expression left, Expression right) {
    super(left, right);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Val eval(Context ctx) throws Exception {
    if (this.right.eval(ctx).getVal() == 0) {
      throw new IllegalParameterException();
    }
    return new Num(this.left.eval(ctx).getVal() / this.right.eval(ctx).getVal());
  }

  //@Override
  //public String asString(Context ctx) throws Exception {
  //  StringBuilder sb = new StringBuilder();
  //  sb.append("(");
  //  sb.append(this.left.asString(ctx));
  //  sb.append(" / ");
  //  sb.append(this.right.asString(ctx));
  //  sb.append(")");
  //  return sb.toString();
  //}
  @Override
  public String asString(Visitor visitor) {
    return visitor.visit(this);
  }

}
