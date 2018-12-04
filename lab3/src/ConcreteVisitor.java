package edu.neu.ccs.cs5010.lab3;

public class ConcreteVisitor implements Visitor {

  public String visit(Add add) {
    StringBuilder sb = new StringBuilder();
    sb.append("(");
    sb.append(visit(add.left));
    sb.append(" + ");
    sb.append(visit(add.right));
    sb.append(")");
    return sb.toString();
  }

  public String visit(Diff diff) {
    StringBuilder sb = new StringBuilder();
    sb.append("(");
    sb.append(visit(diff.left));
    sb.append(" - ");
    sb.append(visit(diff.right));
    sb.append(")");
    return sb.toString();
  }

  public String visit(Exp exp) {
    StringBuilder sb = new StringBuilder();
    sb.append("(exp ");
    sb.append(visit(exp.left));
    sb.append(" ");
    sb.append(visit(exp.right));
    sb.append(")");
    return sb.toString();

  }

  public String visit(Div div) {
    StringBuilder sb = new StringBuilder();
    sb.append("(");
    sb.append(visit(div.left));
    sb.append(" / ");
    sb.append(visit(div.right));
    sb.append(")");
    return sb.toString();
  }

  public String visit(UnaryMinus unaryMinus) {
    StringBuilder sb = new StringBuilder();
    sb.append("-");
    sb.append(visit(unaryMinus.expression));
    return sb.toString();

  }

  public String visit(Mul mul) {
    StringBuilder sb = new StringBuilder();
    sb.append("(");
    sb.append(visit(mul.left));
    sb.append(" * ");
    sb.append(visit(mul.right));
    sb.append(")");
    return sb.toString();
  }

  public String visit(Num num) {
    return String.valueOf(num.getVal());

  }

  @Override
  public String visit(Expression expression) {
    if (expression instanceof Add) {
      return visit((Add)expression);
    }
    if (expression instanceof Div) {
      return visit((Div)expression);
    }
    if (expression instanceof Num) {
      return visit((Num)expression);
    }
    if (expression instanceof Exp) {
      return visit((Exp)expression);
    }
    if (expression instanceof UnaryMinus) {
      return visit((UnaryMinus)expression);
    }
    if (expression instanceof Mul) {
      return visit((Mul)expression);
    }
    if (expression instanceof Diff) {
      return visit((Diff)expression);
    }
    return null;
  }
}
