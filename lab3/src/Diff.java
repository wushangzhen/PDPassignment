package edu.neu.ccs.cs5010.lab3;
/**
 *
 */
public class Diff extends BinOp {

  /**
   * @param left
   * @param right
   */
  public Diff(Expression left, Expression right) {
    super(left, right);
    //System.out.println(this.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Val eval(Context ctx) throws Exception {
    //System.out.println(this.left.toString());
    //System.out.println(this.right.toString());
    this.path.add(this.toString());
    Num num = new Num(this.left.eval(ctx).getVal() - this.right.eval(ctx).getVal());
    this.left = this.left.eval(ctx);
    this.right = this.right.eval(ctx);
    this.path.add(this.toString());
    this.path.add(num.toString());
    //System.out.println(this.left.eval(ctx), this.right.eval(ctx));
    return num;
  }
  @Override
  public String toString() {
    return "(" + this.left.toString() + " - " + this.right.toString() + ")";
  }

  @Override
  public String asString(Visitor visitor) {
    return visitor.visit(this);
  }

  //@Override
  //public void trace() {
  //  for (int i = 0; i < this.path.size(); i++) {
  //    System.out.printf("%-10s", i + 1 + ".");
  //    System.out.print(this.path.get(i) + "\n");
  //    if (i + 1 < this.path.size()) {
  //      System.out.printf("%-10s", this.path.get(i + 1) + "\n");
  //    }
  //  }
  //}

  //@Override
  //public String asString(Context ctx) throws Exception {
  //  StringBuilder sb = new StringBuilder();
  //  sb.append("(");
  //  sb.append(this.left.asString(ctx));
  //  sb.append(" - ");
  //  sb.append(this.right.asString(ctx));
  //  sb.append(")");
  //  return sb.toString();
  //}

}
