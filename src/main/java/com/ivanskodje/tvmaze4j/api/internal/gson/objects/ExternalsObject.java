package com.ivanskodje.tvmaze4j.api.internal.gson.objects;

import com.ivanskodje.tvmaze4j.api.internal.TVMazeError;

public class ExternalsObject {
  private Integer tvrage;
  private Integer thetvdb;
  private String imdb;

  public Integer getTvrage() {
    return TVMazeError.getInteger(tvrage);
  }

  public Integer getThetvdb() {
    return TVMazeError.getInteger(thetvdb);
  }

  public String getImdb() {
    return TVMazeError.getString(imdb);
  }
}
