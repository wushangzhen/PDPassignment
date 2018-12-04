package edu.neu.ccs.cs5010.assignment1.problem3;

import static org.junit.Assert.*;
import java.util.List;

import java.util.ArrayList;
import org.junit.Test;
import org.omg.CORBA.Current;

public class PhotoGrapherTest {
  private Name name = new Name("Yang", "Zi");
  ArrayList<String> genres = new ArrayList<>();
  ArrayList<String> awards = new ArrayList<>();
  PhotoGrapher photoGrapher;
  PhotoGrapher  photoGrapher2;
  public PhotoGrapherTest() {
    genres.add("gentle");
    genres.add("abstraction");
    awards.add("National Price");
    awards.add("State Price");
    try {
      photoGrapher = new PhotoGrapher(name, 20, "2015-Current", genres, awards);
      photoGrapher2 = new PhotoGrapher(name, 300, "2015- Current", genres, awards);
    } catch (Exception e) {
      assertEquals(e.getClass(), OutOfAgeRangeException.class);
    }
  }

  @Test
  public void getName() {
    assertEquals(photoGrapher.getName(), name);
  }

  @Test
  public void setName() {
    Name newName = new Name("Shang", "Wu");
    photoGrapher.setName(newName);
    assertEquals(photoGrapher.getName(), newName);
  }

  @Test
  public void getAge() {
    assertEquals(photoGrapher.getAge(), 20);
  }

  @Test
  public void setAge() {
    photoGrapher.setAge(30);
    assertEquals(photoGrapher.getAge(), 30);
  }

  @Test
  public void getActiveYears() {
    assertEquals(photoGrapher.getActiveYears(), "2015-Current");
  }

  @Test
  public void setActiveYears() {
    photoGrapher.setActiveYears("2011-2015");
    assertEquals(photoGrapher.getActiveYears(), "2011-2015");
  }

  @Test
  public void getGenre() {
    assertEquals(photoGrapher.getGenre(), genres);
  }

  @Test
  public void setGenre() {
    ArrayList newGenre = genres;
    newGenre.remove(newGenre.size() - 1);
    photoGrapher.setGenre(newGenre);
    assertEquals(photoGrapher.getGenre(), newGenre);
  }

  @Test
  public void getAwards() {
    assertEquals(photoGrapher.getAwards(), awards);
  }

  @Test
  public void setAwards() {
    ArrayList newAwards = awards;
    newAwards.remove(newAwards.size() - 1);
    photoGrapher.setAwards(newAwards);
    assertEquals(photoGrapher.getAwards(), newAwards);
  }
}