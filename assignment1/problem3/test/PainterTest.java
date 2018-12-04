package edu.neu.ccs.cs5010.assignment1.problem3;

import static org.junit.Assert.*;
import java.util.List;

import java.util.ArrayList;
import org.junit.Test;
import org.omg.CORBA.Current;

public class PainterTest {
  private Name name = new Name("Yang", "Zi");
  ArrayList<String> genres = new ArrayList<>();
  ArrayList<String> awards = new ArrayList<>();
  Painter painter;
  Painter painter2;
  public PainterTest() {
    genres.add("gentle");
    genres.add("abstraction");
    awards.add("National Price");
    awards.add("State Price");
    try {
      painter = new Painter(name, 20, "2015-Current", genres, awards);
      painter2 = new Painter(name, 300, "2015- Current", genres, awards);
    } catch (Exception e) {
      assertEquals(e.getClass(), OutOfAgeRangeException.class);
    }
  }

  @Test
  public void getName() {
    assertEquals(painter.getName(), name);
  }

  @Test
  public void setName() {
    Name newName = new Name("Shang", "Wu");
    painter.setName(newName);
    assertEquals(painter.getName(), newName);
  }

  @Test
  public void getAge() {
    assertEquals(painter.getAge(), 20);
  }

  @Test
  public void setAge() {
    painter.setAge(30);
    assertEquals(painter.getAge(), 30);
  }

  @Test
  public void getActiveYears() {
    assertEquals(painter.getActiveYears(), "2015-Current");
  }

  @Test
  public void setActiveYears() {
    painter.setActiveYears("2011-2015");
    assertEquals(painter.getActiveYears(), "2011-2015");
  }

  @Test
  public void getGenre() {
    assertEquals(painter.getGenre(), genres);
  }

  @Test
  public void setGenre() {
    ArrayList newGenre = genres;
    newGenre.remove(newGenre.size() - 1);
    painter.setGenre(newGenre);
    assertEquals(painter.getGenre(), newGenre);
  }

  @Test
  public void getAwards() {
    assertEquals(painter.getAwards(), awards);
  }

  @Test
  public void setAwards() {
    ArrayList newAwards = awards;
    newAwards.remove(newAwards.size() - 1);
    painter.setAwards(newAwards);
    assertEquals(painter.getAwards(), newAwards);
  }
}