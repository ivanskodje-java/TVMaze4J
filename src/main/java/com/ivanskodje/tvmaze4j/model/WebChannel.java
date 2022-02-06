package com.ivanskodje.tvmaze4j.model;

import lombok.Data;

@Data
public class WebChannel {

  private int id = -1;
  private String name;
  private Country country;

  @Override
  public String toString() {
    return getName();
  }
}
