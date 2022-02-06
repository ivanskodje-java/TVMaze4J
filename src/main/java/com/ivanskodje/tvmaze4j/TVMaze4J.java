package com.ivanskodje.tvmaze4j;

import com.ivanskodje.tvmaze4j.api.ClientBuilder;
import com.ivanskodje.tvmaze4j.api.TVMazeClient;
import com.ivanskodje.tvmaze4j.model.Episode;
import com.ivanskodje.tvmaze4j.model.Show;
import com.ivanskodje.tvmaze4j.util.LogMarkers;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.NOPLoggerFactory;

public class TVMaze4J {

  public static final String NAME;
  public static final String VERSION;
  public static final String DESCRIPTION;
  public static final Logger LOGGER = initializeLogger();

  static {
    InputStream stream = TVMaze4J.class.getClassLoader().getResourceAsStream("app.properties");
    Properties properties = new Properties();
    try {
      properties.load(stream);
      stream.close();
    } catch (IOException ex) {
      TVMaze4J.LOGGER.error(
          LogMarkers.MAIN, "TVMaze4J: Unable to load app.properties resource.", ex);
    }

    NAME = properties.getProperty("app.name");
    VERSION = properties.getProperty("app.version");
    DESCRIPTION = properties.getProperty("app.description");

    LOGGER.info(LogMarkers.MAIN, String.format("%s (%s)", NAME, VERSION));
    LOGGER.info(LogMarkers.MAIN, String.format("%s", DESCRIPTION));
  }

  private static Logger initializeLogger() {
    if (hasSLF4J()) {
      return LoggerFactory.getLogger(TVMaze4J.class);
    } else {
      System.err.println(
          "TVMaze4J: Error initializing the SLF4J logger.\n"
              + "TVMaze4J: There are no SLF4J implementation available.");
      return LoggerFactory.getLogger(NOPLoggerFactory.class);
    }
  }

  private static boolean hasSLF4J() {
    try {
      Class.forName("org.slf4j.impl.StaticLoggerBinder");
      return !(LoggerFactory.getILoggerFactory() instanceof NOPLoggerFactory);
    } catch (ClassNotFoundException ex) {
      return false;
    }
  }

  /**
   * Run TVMaze4J in order to test whether or not you can connect with the TVMaze API.
   *
   * <p>Requires access to http://api.tvmaze.com.
   *
   * @param args No parameters expected.
   */
  public static void main(String[] args) {
    TVMazeClient client = new ClientBuilder().build();
    List<Show> shows = client.showSearch("silicon valley", true);
    for (Show show : shows) {
      System.out.println(">>> " + show);
      for (Episode episode : show.getEpisodes()) {
        System.out.println(episode);
      }
    }
  }
}
