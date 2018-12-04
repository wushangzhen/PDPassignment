package edu.neu.ccs.cs5010.assignment6.sequential;

import static org.junit.Assert.*;

import javafx.geometry.Pos;
import org.junit.Test;

public class PostTest {
  Post post = new Post("1", "1", "2");

  @Test
  public void getTimeStamp() {
    assertEquals(post.getLatency(), "1");
  }

  @Test
  public void getLatency() {
    assertEquals(post.getLatency(), "1");
  }
}