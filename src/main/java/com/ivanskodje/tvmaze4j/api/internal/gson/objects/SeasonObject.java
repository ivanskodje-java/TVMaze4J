package com.ivanskodje.tvmaze4j.api.internal.gson.objects;

import com.ivanskodje.tvmaze4j.api.internal.TVMazeError;
import java.util.Date;
import lombok.Getter;

public class SeasonObject {
  private Integer id;
  private String url;
  private Integer number;
  private String name;
  private Integer episodeOrder;
  private Date premiereDate;
  private Date endDate;
  private @Getter NetworkObject network;
  private @Getter WebChannelObject webChannel;
  private @Getter ImageObject image;
  private String summary;
  private @Getter LinksObject _links;

  public Integer getId() {
    return TVMazeError.getInteger(id);
  }

  public String getUrl() {
    return TVMazeError.getString(url);
  }

  public Integer getNumber() {
    return TVMazeError.getInteger(number);
  }

  public String getName() {
    return TVMazeError.getString(name);
  }

  public Integer getEpisodeOrder() {
    return TVMazeError.getInteger(episodeOrder);
  }

  public Date getPremiereDate() {
    return premiereDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public String getSummary() {
    return TVMazeError.getString(summary);
  }
}
