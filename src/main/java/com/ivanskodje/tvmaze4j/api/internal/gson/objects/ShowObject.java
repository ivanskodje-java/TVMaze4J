package com.ivanskodje.tvmaze4j.api.internal.gson.objects;

import com.ivanskodje.tvmaze4j.api.internal.TVMazeError;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;

public class ShowObject {
  private Integer id;
  private String url;
  private String name;
  private String type;
  private String language;
  private List<String> genres;
  private String status;
  private Integer runtime;
  private Date premiered;
  private String officialSite;
  private @Getter ScheduleObject schedule;
  private @Getter RatingObject rating;
  private Integer weight;
  private @Getter NetworkObject network;
  private @Getter WebChannelObject webChannel;
  private @Getter ExternalsObject externals;
  private @Getter ImageObject image;
  private String summary;
  private Integer updated;
  private @Getter LinksObject _links;
  private @Getter EmbeddedObject _embedded;

  public Integer getId() {
    return TVMazeError.getInteger(id);
  }

  public String getUrl() {
    return TVMazeError.getString(url);
  }

  public String getName() {
    return TVMazeError.getString(name);
  }

  public String getType() {
    return TVMazeError.getString(type);
  }

  public String getLanguage() {
    return TVMazeError.getString(language);
  }

  public List<String> getGenres() {
    return (genres != null) ? genres : new ArrayList<>();
  }

  public String getStatus() {
    return TVMazeError.getString(status);
  }

  public Integer getRuntime() {
    return TVMazeError.getInteger(runtime);
  }

  public Date getPremiered() {
    return premiered;
  }

  public String getOfficialSite() {
    return TVMazeError.getString(officialSite);
  }

  public Integer getWeight() {
    return TVMazeError.getInteger(weight);
  }

  public String getSummary() {
    return TVMazeError.getString(summary);
  }

  public Integer getUpdated() {
    return TVMazeError.getInteger(updated);
  }
}
