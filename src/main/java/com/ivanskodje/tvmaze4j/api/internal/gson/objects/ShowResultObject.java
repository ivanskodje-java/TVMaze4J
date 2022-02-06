package com.ivanskodje.tvmaze4j.api.internal.gson.objects;

import com.ivanskodje.tvmaze4j.api.internal.TVMazeError;

public class ShowResultObject {

  private Float score;

  private ShowObject show;

  public Float getScore() {
    return TVMazeError.getFloat(score);
  }

  public ShowObject getShow() {
    return (show != null) ? show : new ShowObject();
  }
}
