package edu.neu.ccs.cs5010.assignment1.problem3;

import static org.junit.Assert.*;
import java.util.List;

import java.util.ArrayList;
import org.junit.Test;
import org.omg.CORBA.Current;

public class MusicianTest {
  private Name name = new Name("Yang", "Zi");
  ArrayList<String> genres = new ArrayList<>();
  ArrayList<String> awards = new ArrayList<>();
  Musician musician;
  Musician musician2;
  public MusicianTest() {
    genres.add("gentle");
    genres.add("abstraction");
    awards.add("National Price");
    awards.add("State Price");
    try {
      musician = new Musician(name, 20, "2015-Current", genres, awards);
      musician2 = new Musician(name, 300, "2015- Current", genres, awards);
    } catch (Exception e) {
      assertEquals(e.getClass(), OutOfAgeRangeException.class);
    }
  }

  @Test
  public void getName() {
    assertEquals(musician.getName(), name);
  }

  @Test
  public void setName() {
    Name newName = new Name("Shang", "Wu");
    musician.setName(newName);
    assertEquals(musician.getName(), newName);
  }

  @Test
  public void getAge() {
    assertEquals(musician.getAge(), 20);
  }

  @Test
  public void setAge() {
    musician.setAge(30);
    assertEquals(musician.getAge(), 30);
  }

  @Test
  public void getActiveYears() {
    assertEquals(musician.getActiveYears(), "2015-Current");
  }

  @Test
  public void setActiveYears() {
    musician.setActiveYears("2011-2015");
    assertEquals(musician.getActiveYears(), "2011-2015");
  }

  @Test
  public void getGenre() {
    assertEquals(musician.getGenre(), genres);
  }

  @Test
  public void setGenre() {
    ArrayList newGenre = genres;
    newGenre.remove(newGenre.size() - 1);
    musician.setGenre(newGenre);
    assertEquals(musician.getGenre(), newGenre);
  }

  @Test
  public void getAwards() {
    assertEquals(musician.getAwards(), awards);
  }

  @Test
  public void setAwards() {
    ArrayList newAwards = awards;
    newAwards.remove(newAwards.size() - 1);
    musician.setAwards(newAwards);
    assertEquals(musician.getAwards(), newAwards);
  }
}