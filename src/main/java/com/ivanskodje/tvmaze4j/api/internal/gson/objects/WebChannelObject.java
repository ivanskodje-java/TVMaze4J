package com.ivanskodje.tvmaze4j.api.internal.gson.objects;

import com.ivanskodje.tvmaze4j.api.internal.TVMazeError;

public class WebChannelObject {
  private Integer id;
  private String name;
  private CountryObject country;

  public Integer getId() {
    return TVMazeError.getInteger(id);
  }

  public String getName() {
    return TVMazeError.getString(name);
  }

  public CountryObject getCountry() {
    return (country != null) ? country : new CountryObject();
  }
}
