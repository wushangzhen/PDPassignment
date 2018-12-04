package edu.neu.ccs.cs5010.lab3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class CtxHashMap implements Context {

  private Map<Var, Val> ctx;
  private List<String> tracer;

  public List<String> getTracer() {
    return tracer;
  }

  public void setTracer(List<String> tracer) {
    this.tracer = tracer;
  }


  public CtxHashMap() {
    this.ctx = new HashMap<Var, Val>();
    this.tracer = new LinkedList<>();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean contains(Var variable) {
    return this.ctx.containsKey(variable);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void add(Var variable, Val value) {
    this.ctx.put(variable, value);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Val get(Var variable) {
    return this.ctx.get(variable);
  }

  public Map<Var, Val> getCtx() {
    return ctx;
  }

  public void setCtx(
      Map<Var, Val> ctx) {
    this.ctx = ctx;
  }
}
