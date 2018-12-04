package edu.neu.ccs.cs5010.assignment1.problem3;

import java.util.ArrayList;

/**
 * An abstract class represents Artist (super class).
 */
public abstract class Artist {

  private Name name;
  private int age;
  private String activeYears;
  private ArrayList<String> genre;
  private ArrayList<String> awards;

  Artist(Name name, int age, String activeYears, ArrayList<String> genre,
      ArrayList<String> awards) throws OutOfAgeRangeException {
    if (age > 128 || age < 0) {
      throw new OutOfAgeRangeException();
    } else {
      this.name = name;
      this.age = age;
      this.activeYears = activeYears;
      this.genre = genre;
      this.awards = awards;
    }
  }

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getActiveYears() {
    return activeYears;
  }

  public void setActiveYears(String activeYears) {
    this.activeYears = activeYears;
  }

  public ArrayList<String> getGenre() {
    return genre;
  }

  public void setGenre(ArrayList<String> genre) {
    this.genre = genre;
  }

  public ArrayList<String> getAwards() {
    return awards;
  }

  public void setAwards(ArrayList<String> awards) {
    this.awards = awards;
  }
}
