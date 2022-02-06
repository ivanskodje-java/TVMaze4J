package com.ivanskodje.tvmaze4j.api.internal.gson.objects;

import com.ivanskodje.tvmaze4j.api.internal.TVMazeError;
import java.util.Date;
import lombok.Getter;

public class EpisodeObject {
  private Integer id;
  private String url;
  private String name;
  private Integer season;
  private Integer number;
  private Date airdate;
  private String airtime;
  private Date airstamp;
  private Integer runtime;
  @Getter private ImageObject image;
  private String summary;
  @Getter private ShowObject show; // Received from schedule requests.
  @Getter private LinksObject _links;
  private Integer status; // Used for error handling
  private String message; // Error message

  public int getId() {
    return TVMazeError.getInteger(id);
  }

  public String getUrl() {
    return TVMazeError.getString(url);
  }

  public String getName() {
    return TVMazeError.getString(name);
  }

  public int getSeason() {
    return TVMazeError.getInteger(season);
  }

  public int getNumber() {
    return TVMazeError.getInteger(number);
  }

  public Date getAirdate() {
    return airdate;
  }

  public String getAirtime() {
    return TVMazeError.getString(airtime);
  }

  public Date getAirstamp() {
    return airstamp;
  }

  public int getRuntime() {
    return TVMazeError.getInteger(runtime);
  }

  public String getSummary() {
    return TVMazeError.getString(summary);
  }

  public Integer getStatus() {
    return TVMazeError.getInteger(status);
  }

  public String getMessage() {
    return TVMazeError.getString(message);
  }
}
