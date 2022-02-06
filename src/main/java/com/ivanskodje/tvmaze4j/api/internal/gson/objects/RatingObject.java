package com.ivanskodje.tvmaze4j.api.internal.gson.objects;

import com.ivanskodje.tvmaze4j.api.internal.TVMazeError;

public class RatingObject {
  private Float average;

  public Float getAverage() {
    return TVMazeError.getFloat(average);
  }
}
