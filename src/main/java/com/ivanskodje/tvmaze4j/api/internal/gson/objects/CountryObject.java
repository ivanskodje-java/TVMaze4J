package com.ivanskodje.tvmaze4j.api.internal.gson.objects;

import com.ivanskodje.tvmaze4j.api.internal.TVMazeError;


public class CountryObject {
  private String name;
  private String code;
  private String timezone;

  public String getName() {
    return TVMazeError.getString(name);
  }

  public String getCode() {
    return TVMazeError.getString(code);
  }

  public String getTimezone() {
    return TVMazeError.getString(timezone);
  }
}
