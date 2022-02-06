package com.ivanskodje.tvmaze4j.model;

import lombok.Data;

@Data
public class Externals {
  private int tvRage;
  private int theTvDb;
  private String imdb;

  @Override
  public String toString() {
    return "tvRage: " + getTvRage() + ", theTvDb: " + getTheTvDb() + ", imdb: " + getImdb();
  }
}
