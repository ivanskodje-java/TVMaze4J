package com.ivanskodje.tvmaze4j.api.internal;

import static com.ivanskodje.tvmaze4j.TVMaze4J.LOGGER;

import com.ivanskodje.tvmaze4j.TVMaze4J;
import com.ivanskodje.tvmaze4j.api.TVMazeClient;
import com.ivanskodje.tvmaze4j.util.LogMarkers;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.yamj.api.common.http.DigestedResponse;
import org.yamj.api.common.http.DigestedResponseReader;

public class Requests {

  public final String USER_AGENT =
      String.format("%s (%s): %s", TVMaze4J.NAME, TVMaze4J.VERSION, TVMaze4J.DESCRIPTION);
  public final GetRequest GET;
  private final TVMazeClient client;

  public Requests(TVMazeClient client) {
    this.client = client;
    GET = new GetRequest();
  }

  public interface Request {
    <T> T makeRequest(String url, Class<T> clazz);
  }

  public final class GetRequest implements Request {

    private final CloseableHttpClient httpClient =
        HttpClients.custom().setUserAgent(USER_AGENT).build();

    @Override
    public <T> T makeRequest(String url, Class<T> clazz) {
      try {
        HttpUriRequest httpRequest = new HttpGet(url);
        DigestedResponse response =
            DigestedResponseReader.requestContent(
                httpClient, (HttpGet) httpRequest, StandardCharsets.UTF_8);

        switch (response.getStatusCode()) {
          case 404:
            TVMaze4J.LOGGER.error(LogMarkers.API, "Error Code 404: " + response.getContent());
            return null;
          default:
            break;
        }
        return TVMazeUtilities.GSON.fromJson(response.getContent(), clazz);
      } catch (IOException ex) {
        LOGGER.error(LogMarkers.API, "IO Exception.\n" + ex.getMessage());
      }

      return null;
    }
  }
}
