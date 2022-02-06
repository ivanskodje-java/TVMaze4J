package com.ivanskodje.tvmaze4j.api.internal.gson.objects;

import com.ivanskodje.tvmaze4j.api.internal.TVMazeError;
import lombok.Getter;

public class NetworkObject {
  private Integer id;
  private String name;
  private @Getter CountryObject country;

  public Integer getId() {
    return TVMazeError.getInteger(id);
  }

  public String getName() {
    return TVMazeError.getString(name);
  }
}
