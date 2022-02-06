package com.ivanskodje.tvmaze4j.model;

import lombok.Data;

@Data
public class Images {
  private String medium;
  private String original;

  @Override
  public String toString() {
    return "Medium: " + getMedium() + ", Original: " + getOriginal();
  }
}
