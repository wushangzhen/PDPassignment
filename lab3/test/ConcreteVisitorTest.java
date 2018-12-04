package edu.neu.ccs.cs5010.lab3;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConcreteVisitorTest {
  ConcreteVisitor concreteVisitor = new ConcreteVisitor();
  Num n1= new Num(1);
  Num n2= new Num(1);
  Add add = new Add(n1, n2);
  Diff diff = new Diff(n1, n2);
  Exp exp = new Exp(n1, n2);
  Mul mul = new Mul(n1, n2);
  Div div = new Div(n1, n2);
  UnaryMinus unaryMinus = new UnaryMinus(n1);
  @Test
  public void visit() {
    concreteVisitor.visit(add);
    concreteVisitor.visit(mul);
    concreteVisitor.visit(diff);
    concreteVisitor.visit(exp);
    concreteVisitor.visit(div);
    concreteVisitor.visit(unaryMinus);
  }


}