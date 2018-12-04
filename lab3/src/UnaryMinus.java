package edu.neu.ccs.cs5010.lab3;
public class UnaryMinus extends OneOp {

  public UnaryMinus(Expression expression) {
    super(expression);
  }

  @Override
  public Val eval(Context ctx) throws Exception {
    return new Num(-expression.eval(ctx).getVal());
  }

  //@Override
  //public String asString(Context ctx) throws Exception {
  //  StringBuilder sb = new StringBuilder();
  //  sb.append("-");
  //  sb.append(this.expression.asString(ctx));
  //  return sb.toString();
  //}

  @Override
  public String asString(Visitor visitor) {
    return visitor.visit(this);
  }
}
