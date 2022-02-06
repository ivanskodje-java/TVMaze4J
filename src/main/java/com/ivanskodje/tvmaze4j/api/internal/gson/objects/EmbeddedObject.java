package com.ivanskodje.tvmaze4j.api.internal.gson.objects;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class EmbeddedObject {
  @Getter private ShowObject show;
  private List<EpisodeObject> episodes;
  private List<CastObject> cast;

  public List<EpisodeObject> getEpisodes() {
    return (episodes != null) ? episodes : new ArrayList<>();
  }

  public List<CastObject> getCast() {
    return (cast != null) ? cast : new ArrayList<>();
  }
}
