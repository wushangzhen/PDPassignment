package edu.neu.ccs.cs5010.assignment1.problem3;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;
import org.omg.CORBA.ARG_IN;

public class FilmMakerTest {
  Name name = new Name("Ziling", "Yang");

  ArrayList<String> genres = new ArrayList<>();
  ArrayList<String> awards = new ArrayList<>();
  ArrayList<String> movies = new ArrayList<>();
  ArrayList<String> series = new ArrayList<>();
  ArrayList<String> multiMedias = new ArrayList<>();
  FilmMaker filmMaker;
  FilmMaker filmMaker2;
  public FilmMakerTest() {
    genres.add("gentle");
    genres.add("abstraction");
    awards.add("National Price");
    awards.add("State Price");
    movies.add("killer");
    series.add("lover");
    multiMedias.add("lawyer");
    try {
      filmMaker = new FilmMaker(name, 14, "2017-Current", genres, awards,
          movies, series, multiMedias);
      filmMaker2 = new FilmMaker(name, 290, "2017-Current", genres, awards,
          movies, series, multiMedias);
    } catch (Exception e) {
      assertEquals(e.getClass(), OutOfAgeRangeException.class);
    }
  }

  @Test
  public void getMovies() {
    assertEquals(filmMaker.getMovies(), movies);
  }

  @Test
  public void setMovies() {
    movies.remove(movies.size() - 1);
    filmMaker.setMovies(movies);
    assertEquals(filmMaker.getMovies(), movies);
  }

  @Test
  public void getSeries() {
    assertEquals(filmMaker.getSeries(), series);
  }

  @Test
  public void setSeries() {
    series.remove(series.size() - 1);
    filmMaker.setSeries(series);
    assertEquals(filmMaker.getSeries(), series);
  }

  @Test
  public void getMultiMedias() {
    assertEquals(filmMaker.getMultiMedias(), multiMedias);
  }

  @Test
  public void setMultiMedias() {
    multiMedias.remove(multiMedias.size() -1);
    filmMaker.setMultiMedias(multiMedias);
    assertEquals(filmMaker.getMultiMedias(), multiMedias);
  }
}