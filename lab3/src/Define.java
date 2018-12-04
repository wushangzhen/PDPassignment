package edu.neu.ccs.cs5010.lab3;
/**
 *
 */
public class Define implements Expression {
  private Var lval;
  private Expression rval;



  /**
   * @param lval
   * @param rval
   */
  public Define(Var lval, Expression rval) {
    this.lval = lval;
    this.rval = rval;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public Val eval(Context ctx) throws Exception {
    ctx.add(this.lval, this.rval.eval(ctx));
    return lval;
  }

  @Override
  public void trace() {

  }

  //@Override
  //public String asString(Context ctx) throws Exception {
  //  return rval.asString(ctx);
  //}

}
