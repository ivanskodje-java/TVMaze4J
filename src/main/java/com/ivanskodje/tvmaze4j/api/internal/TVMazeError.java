package com.ivanskodje.tvmaze4j.api.internal;

public class TVMazeError {

  public static String getString(String value) {
    return (value != null) ? value : "";
  }

  public static int getInteger(Integer value) {
    return (value != null) ? value : -1;
  }

  public static float getFloat(Float value) {
    return (value != null) ? value : -1f;
  }
}
