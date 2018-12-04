package edu.neu.ccs.cs5010.lab3;
/**
 *
 */
public class Num extends Val {

  private Integer val;

  Num(Integer n) {
    this.val = n;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Val eval(Context ctx) {
    //System.out.println(asString(new ConcreteVisitor()));
    return this;
  }

  @Override
  public void trace() {

  }

  //@Override
  //public String asString(Context ctx) throws Exception {
  //  return String.valueOf(val);
  //}

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((this.val == null) ? 0 : this.val.hashCode());
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Num other = (Num) obj;
    if (this.val == null) {
      if (other.val != null) {
        return false;
      }
    } else if (!this.val.equals(other.val)) {
      return false;
    }
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return String.valueOf(this.val);
    //return "Num [val=" + this.val + "]";
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Integer getVal() {
    return this.val;
  }

  @Override
  public String asString(Visitor visitor) {
    return visitor.visit(this);
  }
}
