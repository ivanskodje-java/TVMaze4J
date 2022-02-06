package com.ivanskodje.tvmaze4j.util;

import java.util.Iterator;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public enum LogMarkers implements Marker {
  MAIN,

  /** A Marker for the classes in {@link com.ivanskodje.tvmaze4j.api} package. */
  API(MAIN),

  /** A Marker for the classes in {@link com.ivanskodje.tvmaze4j.util} package. */
  UTIL(MAIN),

  /** A Marker for models in {@link com.ivanskodje.tvmaze4j.model} package. */
  MODEL(MAIN);

  private final Marker marker;

  LogMarkers(LogMarkers... markers) {
    this();
    for (LogMarkers marker : markers) {
      marker.add(this);
    }
  }

  LogMarkers() {
    marker = MarkerFactory.getMarker(this.toString());
  }

  @Override
  public void add(Marker marker) {
    this.marker.add(marker);
  }

  @Override
  public boolean remove(Marker marker) {
    return this.marker.remove(marker);
  }

  @Override
  public boolean hasChildren() {
    return marker.hasChildren();
  }

  @Override
  public boolean hasReferences() {
    return marker.hasReferences();
  }

  @Override
  public Iterator<Marker> iterator() {
    return marker.iterator();
  }

  @Override
  public boolean contains(Marker marker) {
    return this.marker.contains(marker);
  }

  @Override
  public boolean contains(String s) {
    return marker.contains(s);
  }

  @Override
  public String getName() {
    return marker.getName();
  }
}
