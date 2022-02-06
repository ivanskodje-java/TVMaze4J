package com.ivanskodje.tvmaze4j.model;

import lombok.Data;

@Data
public class Person {
  private float searchRelevanceScore;
  private int id;
  private String url;
  private String name;
  private Images images;
  private Links links;

  @Override
  public String toString() {
    return getName();
  }
}
