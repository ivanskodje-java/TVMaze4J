package com.ivanskodje.tvmaze4j.api.internal.gson.objects;

import com.ivanskodje.tvmaze4j.api.internal.TVMazeError;
import lombok.Getter;

public class PersonObject {
  private Integer id;
  private String url;
  private String name;
  private @Getter ImageObject image;
  private @Getter LinksObject _links;

  public Integer getId() {
    return TVMazeError.getInteger(id);
  }

  public String getUrl() {
    return TVMazeError.getString(url);
  }

  public String getName() {
    return TVMazeError.getString(name);
  }
}
