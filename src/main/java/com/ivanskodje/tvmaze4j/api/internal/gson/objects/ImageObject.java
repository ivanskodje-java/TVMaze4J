package com.ivanskodje.tvmaze4j.api.internal.gson.objects;

import com.ivanskodje.tvmaze4j.api.internal.TVMazeError;

public class ImageObject {
  private String medium;
  private String original;

  public String getMedium() {
    return TVMazeError.getString(medium);
  }

  public String getOriginal() {
    return TVMazeError.getString(original);
  }
}
