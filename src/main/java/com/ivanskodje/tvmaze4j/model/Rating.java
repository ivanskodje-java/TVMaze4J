package com.ivanskodje.tvmaze4j.model;

import lombok.Data;

@Data
public class Rating {
  private float average;

  @Override
  public String toString() {
    return "" + average;
  }
}
