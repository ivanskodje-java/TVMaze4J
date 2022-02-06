package com.ivanskodje.tvmaze4j.model;

import java.time.LocalTime;
import java.util.List;
import lombok.Data;

@Data
public class Schedule {
  private LocalTime time;
  private List<String> days;

  @Override
  public String toString() {
    if (getDays() == null || getTime() == null) {
      return "";
    }

    List<String> days = getDays();
    String schedule = "";

    for (int i = 0; i < days.size(); i++) {
      if (i != days.size() - 1) {
        schedule += days.get(i) + ", ";
      } else {
        schedule += days.get(i) + " at ";
      }
    }
    schedule += getTime();

    return schedule;
  }
}
