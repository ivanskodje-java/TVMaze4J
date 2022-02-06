package com.ivanskodje.tvmaze4j.api;

import com.ivanskodje.tvmaze4j.api.internal.TVMazeClientImpl;

public class ClientBuilder {
  public TVMazeClient build() {
    return new TVMazeClientImpl();
  }
}
