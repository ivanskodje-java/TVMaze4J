package com.ivanskodje.tvmaze4j.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import lombok.Data;

@Data
public class Episode {
  private int id;
  private String url;
  private String name;
  private int season;
  private int number;
  private LocalDate airDate;
  private LocalTime airTime;
  private Date airStamp;
  private int runtime;
  private Images images;
  private String summary;
  private Show show;
  private Links links;

  @Override
  public String toString() {
    return "S"
        + String.format("%02d", getSeason())
        + "E"
        + String.format("%02d", getNumber())
        + ": "
        + getName();
  }
}
