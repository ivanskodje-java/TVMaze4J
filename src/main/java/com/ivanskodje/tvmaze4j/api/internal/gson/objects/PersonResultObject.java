package com.ivanskodje.tvmaze4j.api.internal.gson.objects;

import com.ivanskodje.tvmaze4j.api.internal.TVMazeError;
import lombok.Getter;

public class PersonResultObject {

  private Float score;

  private @Getter PersonObject person;

  public Float getScore() {
    return TVMazeError.getFloat(score);
  }
}
