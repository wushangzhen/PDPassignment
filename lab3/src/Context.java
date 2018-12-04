package edu.neu.ccs.cs5010.lab3;

/**
 *
 */
public interface Context {

  public static Context emptyCtx() {
    return new CtxHashMap();
  }
  boolean contains(Var variable);

  void add(Var variable, Val value);

  Val get(Var variable);
}
