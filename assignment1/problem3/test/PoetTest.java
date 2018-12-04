package edu.neu.ccs.cs5010.assignment1.problem3;

import static org.junit.Assert.*;
import java.util.List;

import java.util.ArrayList;
import org.junit.Test;
import org.omg.CORBA.Current;

public class PoetTest {
  private Name name = new Name("Yang", "Zi");
  ArrayList<String> genres = new ArrayList<>();
  ArrayList<String> awards = new ArrayList<>();
  Poet poet;
  Poet poet2;
  public PoetTest() {
    genres.add("gentle");
    genres.add("abstraction");
    awards.add("National Price");
    awards.add("State Price");
    try {
      poet = new Poet(name, 20, "2015-Current", genres, awards);
      poet2 = new Poet(name, 300, "2015- Current", genres, awards);
    } catch (Exception e) {
      assertEquals(e.getClass(), OutOfAgeRangeException.class);
    }
  }

  @Test
  public void getName() {
    assertEquals(poet.getName(), name);
  }

  @Test
  public void setName() {
    Name newName = new Name("Shang", "Wu");
    poet.setName(newName);
    assertEquals(poet.getName(), newName);
  }

  @Test
  public void getAge() {
    assertEquals(poet.getAge(), 20);
  }

  @Test
  public void setAge() {
    poet.setAge(30);
    assertEquals(poet.getAge(), 30);
  }

  @Test
  public void getActiveYears() {
    assertEquals(poet.getActiveYears(), "2015-Current");
  }

  @Test
  public void setActiveYears() {
    poet.setActiveYears("2011-2015");
    assertEquals(poet.getActiveYears(), "2011-2015");
  }

  @Test
  public void getGenre() {
    assertEquals(poet.getGenre(), genres);
  }

  @Test
  public void setGenre() {
    ArrayList newGenre = genres;
    newGenre.remove(newGenre.size() - 1);
    poet.setGenre(newGenre);
    assertEquals(poet.getGenre(), newGenre);
  }

  @Test
  public void getAwards() {
    assertEquals(poet.getAwards(), awards);
  }

  @Test
  public void setAwards() {
    ArrayList newAwards = awards;
    newAwards.remove(newAwards.size() - 1);
    poet.setAwards(newAwards);
    assertEquals(poet.getAwards(), newAwards);
  }
}