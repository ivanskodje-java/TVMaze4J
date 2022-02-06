package com.ivanskodje.tvmaze4j.model;

import java.util.List;
import lombok.Data;

@Data
public class Embedded {
  private Show show;
  private List<Episode> episodes;
  private List<Cast> castMembers;

  @Override
  public String toString() {
    String message = "";
    if (getShow() != null) {
      message += "" + getShow().getName();

      if (getEpisodes() != null) {
        message += " has ";
      }
    }

    if (getEpisodes() != null) {
      message += getEpisodes().size() + " episodes";
    }

    return message;
  }
}
