package com.ivanskodje.tvmaze4j.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Season {
  private int id;
  private String url;
  private int number; // season number
  private String name;
  private int episodeOrder; // number of episodes
  private LocalDate premiereDate;
  private LocalDate endDate;
  private Network network;
  private WebChannel webChannel;
  private Images images;
  private String summary;
  private Links links;

  @Override
  public String toString() {
    return "Season " + String.format("%02d", getNumber()) + " - " + getName();
  }
}
