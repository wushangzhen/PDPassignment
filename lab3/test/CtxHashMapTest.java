package edu.neu.ccs.cs5010.lab3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;

public class CtxHashMapTest {
  CtxHashMap ctxHashMap = new CtxHashMap();

  @Test
  public void getTracer() {
    assertEquals(ctxHashMap.getTracer(), new ArrayList<>());

  }

  @Test
  public void setTracer() {
    ctxHashMap.setTracer(new ArrayList<>());
    assertEquals(ctxHashMap.getTracer(), new ArrayList<>());
  }

  @Test
  public void contains() {
    Var var = new Var("x");
    Num n1 = new Num(1);
    Num n2 = new Num(1);
    ctxHashMap.add(var, n1);
    assertTrue(ctxHashMap.contains(var));

  }

  @Test
  public void add() {
    Var var = new Var("x");
    Num n1 = new Num(1);
    Num n2 = new Num(1);
    ctxHashMap.add(var, n1);
  }

  @Test
  public void get() {
    Var var = new Var("x");
    Num n1 = new Num(1);
    Num n2 = new Num(1);
    ctxHashMap.add(var, n1);
    assertEquals(ctxHashMap.get(var), n1);
  }

  @Test
  public void getCtx() {
    ctxHashMap.getCtx();
  }

  @Test
  public void setCtx() {
    ctxHashMap.setCtx(new HashMap<>());
  }
}