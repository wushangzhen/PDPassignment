package edu.neu.ccs.cs5010.assignment1.problem3;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;
import org.omg.CORBA.ARG_IN;

public class ActorTest {
  Name name = new Name("Ziling", "Yang");

  ArrayList<String> genres = new ArrayList<>();
  ArrayList<String> awards = new ArrayList<>();
  ArrayList<String> movies = new ArrayList<>();
  ArrayList<String> series = new ArrayList<>();
  ArrayList<String> multiMedias = new ArrayList<>();
  Actor actor;
  Actor actor2;
  public ActorTest() {
    genres.add("gentle");
    genres.add("abstraction");
    awards.add("National Price");
    awards.add("State Price");
    movies.add("killer");
    series.add("lover");
    multiMedias.add("lawyer");
    try {
      actor = new Actor(name, 14, "2017-Current", genres, awards,
          movies, series, multiMedias);
      actor2 = new Actor(name, 290, "2017-Current", genres, awards,
          movies, series, multiMedias);
    } catch (Exception e) {
      assertEquals(e.getClass(), OutOfAgeRangeException.class);
    }
  }

  @Test
  public void getMovies() {
    assertEquals(actor.getMovies(), movies);
  }

  @Test
  public void setMovies() {
    movies.remove(movies.size() - 1);
    actor.setMovies(movies);
    assertEquals(actor.getMovies(), movies);
  }

  @Test
  public void getSeries() {
    assertEquals(actor.getSeries(), series);
  }

  @Test
  public void setSeries() {
    series.remove(series.size() - 1);
    actor.setSeries(series);
    assertEquals(actor.getSeries(), series);
  }

  @Test
  public void getMultiMedias() {
    assertEquals(actor.getMultiMedias(), multiMedias);
  }

  @Test
  public void setMultiMedias() {
    multiMedias.remove(multiMedias.size() -1);
    actor.setMultiMedias(multiMedias);
    assertEquals(actor.getMultiMedias(), multiMedias);
  }
}