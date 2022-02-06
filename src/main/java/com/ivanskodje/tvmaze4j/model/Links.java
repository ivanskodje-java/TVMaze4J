package com.ivanskodje.tvmaze4j.model;

import lombok.Data;

@Data
public class Links {
  private String self;
  private String previousEpisode;
  private String nextEpisode;

  @Override
  public String toString() {
    return "Links: [ self: "
        + getSelf()
        + ", previousEpisode: "
        + getPreviousEpisode()
        + ", nextEpisode: "
        + getNextEpisode()
        + " ]";
  }
}
