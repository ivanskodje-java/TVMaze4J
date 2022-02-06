package com.ivanskodje.tvmaze4j.model;

import lombok.Data;

@Data
public class Network {
  private int id;
  private String name;
  private Country country;

  @Override
  public String toString() {
    return getName();
  }
}
