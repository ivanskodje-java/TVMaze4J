package com.ivanskodje.tvmaze4j.api.internal.gson.objects;

import com.ivanskodje.tvmaze4j.api.internal.TVMazeError;
import java.util.ArrayList;
import java.util.List;

public class ScheduleObject {
  private String time;
  private List<String> days;

  public String getTime() {
    return TVMazeError.getString(time);
  }

  public List<String> getDays() {
    return (days != null) ? days : new ArrayList<>();
  }
}
