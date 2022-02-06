package com.ivanskodje.tvmaze4j.api.internal.gson.objects;

import com.ivanskodje.tvmaze4j.api.internal.TVMazeError;

public class LinksObject {
  private HyperlinkObject self;
  private HyperlinkObject previousepisode;
  private HyperlinkObject nextepisode;

  public HyperlinkObject getSelf() {
    return self;
  }

  public HyperlinkObject getPreviousepisode() {
    return previousepisode;
  }

  public HyperlinkObject getNextepisode() {
    return nextepisode;
  }

  public class HyperlinkObject {
    private String href;

    public String getHref() {
      return TVMazeError.getString(href);
    }
  }
}
