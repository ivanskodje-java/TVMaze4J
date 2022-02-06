package com.ivanskodje.tvmaze4j.model;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class Show {

  private float searchRelevanceScore;
  private int id;
  private String url;
  private String name;
  private String type;
  private String language;
  private List<String> genres;
  private String status;
  private int runtime;
  private Date premiered;
  private String officialSite;
  private Schedule schedule;
  private Rating rating;
  private int weight;
  private Network network;
  private WebChannel webChannel;
  private Externals externals;
  private Images images;
  private String summary;
  private int updated;
  private Links links;
  private Embedded embedded;

  public List<Episode> getEpisodes() {
    if (embedded == null) {
      return Collections.emptyList();
    }
    return embedded.getEpisodes();
  }

  public void setEpisodes(List<Episode> episodes) {
    if (episodes != null) {
      if (embedded == null) {
        embedded = new Embedded();
      }
      embedded.setEpisodes(episodes);
    }
  }

  public List<Cast> getCastMembers() {
    if (embedded == null) {
      return Collections.emptyList();
    }
    return embedded.getCastMembers();
  }

  public void setCastMembers(List<Cast> castMembers) {
    if (castMembers != null) {
      if (embedded == null) {
        embedded = new Embedded();
      }
      embedded.setCastMembers(castMembers);
    }
  }

  @Override
  public String toString() {
    return getName();
  }
}
