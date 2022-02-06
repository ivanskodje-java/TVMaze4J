package com.ivanskodje.tvmaze4j.model;

import lombok.Data;

@Data
public class Country {
  private String name;
  private String code;
  private String timeZone;

  @Override
  public String toString() {
    return getName();
  }
}
