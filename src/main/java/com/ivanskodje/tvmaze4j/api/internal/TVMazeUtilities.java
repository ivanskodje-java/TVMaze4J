package com.ivanskodje.tvmaze4j.api.internal;

import com.google.gson.Gson;
import com.ivanskodje.tvmaze4j.TVMaze4J;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.CastObject;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.CountryObject;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.EmbeddedObject;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.EpisodeObject;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.ExternalsObject;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.ImageObject;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.LinksObject;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.NetworkObject;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.PersonObject;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.PersonResultObject;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.RatingObject;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.ScheduleObject;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.SeasonObject;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.ShowObject;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.ShowResultObject;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.WebChannelObject;
import com.ivanskodje.tvmaze4j.model.Cast;
import com.ivanskodje.tvmaze4j.model.Country;
import com.ivanskodje.tvmaze4j.model.Embedded;
import com.ivanskodje.tvmaze4j.model.Episode;
import com.ivanskodje.tvmaze4j.model.Externals;
import com.ivanskodje.tvmaze4j.model.Images;
import com.ivanskodje.tvmaze4j.model.Links;
import com.ivanskodje.tvmaze4j.model.Network;
import com.ivanskodje.tvmaze4j.model.Person;
import com.ivanskodje.tvmaze4j.model.Rating;
import com.ivanskodje.tvmaze4j.model.Schedule;
import com.ivanskodje.tvmaze4j.model.Season;
import com.ivanskodje.tvmaze4j.model.Show;
import com.ivanskodje.tvmaze4j.model.WebChannel;
import com.ivanskodje.tvmaze4j.util.LogMarkers;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TVMazeUtilities {

  public static final Gson GSON = new Gson();

  public static Show getShowFromGsonObject(ShowResultObject showResultObject) {
    if (showResultObject == null) {
      TVMaze4J.LOGGER.error(LogMarkers.UTIL, "ShowResultObject was NULL.");
      return null;
    }

    if (showResultObject.getShow() == null) {
      TVMaze4J.LOGGER.error(LogMarkers.UTIL, "showResultObject.showImpl was NULL.");
      return null;
    }

    Show showImpl = getShowFromGsonObject(showResultObject.getShow());
    showImpl.setSearchRelevanceScore(showResultObject.getScore());

    return showImpl;
  }

  public static Show getShowFromGsonObject(ShowObject showObject) {
    if (showObject == null) {
      TVMaze4J.LOGGER.error(LogMarkers.UTIL, "ShowObject was NULL.");
      return null;
    }

    Show showImpl = new Show();
    showImpl.setId(showObject.getId());
    showImpl.setUrl(showObject.getUrl());
    showImpl.setName(showObject.getName());
    showImpl.setType(showObject.getType());
    showImpl.setLanguage(showObject.getLanguage());
    showImpl.setGenres(showObject.getGenres());
    showImpl.setStatus(showObject.getStatus());
    showImpl.setRuntime(showObject.getRuntime());
    showImpl.setPremiered(showObject.getPremiered());
    showImpl.setOfficialSite(showObject.getOfficialSite());
    showImpl.setSchedule(getScheduleFromGsonObject(showObject.getSchedule()));
    showImpl.setRating(getRatingFromGsonObject(showObject.getRating()));
    showImpl.setWeight(showObject.getWeight());
    showImpl.setNetwork(getNetworkFromGsonObject(showObject.getNetwork()));
    showImpl.setWebChannel(getWebChannelFromGsonObject(showObject.getWebChannel()));
    showImpl.setExternals(getExternalFromGsonObject(showObject.getExternals()));
    showImpl.setImages(getImagesFromGsonObject(showObject.getImage()));
    showImpl.setSummary(showObject.getSummary());
    showImpl.setUpdated(showObject.getUpdated());
    showImpl.setLinks(getLinksFromGsonObject(showObject.get_links()));
    showImpl.setEmbedded(getEmbeddedFromGsonObject(showObject.get_embedded()));
    return showImpl;
  }

  public static Episode getEpisodeFromGsonObject(EpisodeObject episodeObject) {
    if (episodeObject == null) {
      TVMaze4J.LOGGER.error(LogMarkers.UTIL, "EpisodeObject was NULL.");
      return null;
    }

    if (episodeObject.getStatus() != null) {
      switch (episodeObject.getStatus()) {
        case 404:
          TVMaze4J.LOGGER.error(LogMarkers.UTIL, episodeObject.getMessage());
          return null;
        default:
          break;
      }
    }

    Episode episode = new Episode();
    episode.setId(episodeObject.getId());
    episode.setUrl(episodeObject.getUrl());
    episode.setName(episodeObject.getName());
    episode.setSeason(episodeObject.getSeason());
    episode.setNumber(episodeObject.getNumber());
    episode.setAirDate(parseToLocalDate(episodeObject.getAirdate()));
    episode.setAirStamp(episodeObject.getAirstamp());
    episode.setRuntime(episodeObject.getRuntime());
    episode.setImages(getImagesFromGsonObject(episodeObject.getImage()));
    episode.setSummary(episodeObject.getSummary());
    episode.setLinks(getLinksFromGsonObject(episodeObject.get_links()));

    try {
      String timeString =
          (episodeObject.getAirtime().length() > 5)
              ? episodeObject.getAirtime()
              : episodeObject.getAirtime() + ":00";
      episode.setAirTime(LocalTime.parse(timeString));
    } catch (DateTimeParseException ex) {
      TVMaze4J.LOGGER.warn(
          LogMarkers.UTIL,
          "Was unable to set LocalTime in Episode, due to LocalTime Parsing exceptions.\n");
    }

    if (episodeObject.getShow() != null) {
      episode.setShow(getShowFromGsonObject(episodeObject.getShow()));
    }

    return episode;
  }

  public static Person getPersonFromGsonObject(PersonResultObject personResultObject) {
    if (personResultObject == null) {
      TVMaze4J.LOGGER.error(LogMarkers.UTIL, "PersonResultObject was NULL.");
      return null;
    }

    if (personResultObject.getPerson() == null) {
      TVMaze4J.LOGGER.error(LogMarkers.UTIL, "PersonObject in PersonResultObject was NULL.");
      return null;
    }

    Person person = getPersonFromGsonObject(personResultObject.getPerson());
    person.setSearchRelevanceScore(personResultObject.getScore());
    return person;
  }

  public static Person getPersonFromGsonObject(PersonObject personObject) {
    if (personObject == null) {
      TVMaze4J.LOGGER.error(LogMarkers.UTIL, "PersonObject was NULL.");
      return null;
    }

    Person person = new Person();
    person.setId(personObject.getId());
    person.setUrl(personObject.getUrl());
    person.setName(personObject.getName());
    person.setImages(getImagesFromGsonObject(personObject.getImage()));
    person.setLinks(getLinksFromGsonObject(personObject.get_links()));
    return person;
  }

  public static Links getLinksFromGsonObject(LinksObject linksObject) {
    if (linksObject != null) {
      Links links = new Links();

      if (linksObject.getSelf() != null) {
        links.setSelf(linksObject.getSelf().getHref());
      } else {
        TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "linksObject.self was NULL.");
      }

      if (linksObject.getPreviousepisode() != null) {
        links.setPreviousEpisode(linksObject.getPreviousepisode().getHref());
      } else {
        TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "linksObject.previousepisode was NULL.");
      }

      if (linksObject.getNextepisode() != null) {
        links.setNextEpisode(linksObject.getNextepisode().getHref());
      } else {
        TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "linksObject.nextepisode was NULL.");
      }

      return links;
    } else {
      TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "LinksObject was NULL.");
      return null;
    }
  }

  public static Images getImagesFromGsonObject(ImageObject imageObject) {
    if (imageObject != null) {
      Images images = new Images();

      if (imageObject.getMedium() != null) {
        images.setMedium(imageObject.getMedium());
      } else {
        TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "imageObject.medium was NULL.");
      }

      if (imageObject.getOriginal() != null) {
        images.setOriginal(imageObject.getOriginal());
      } else {
        TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "imageObject.original was NULL.");
      }

      return images;
    } else {
      TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "ImageObject was NULL.");
      return null;
    }
  }

  public static Embedded getEmbeddedFromGsonObject(EmbeddedObject embeddedObject) {
    if (embeddedObject != null) {
      Embedded embedded = new Embedded();

      if (embeddedObject.getShow() != null) {
        embedded.setShow(getShowFromGsonObject(embeddedObject.getShow()));
      }

      if (embeddedObject.getEpisodes() != null) {
        List<Episode> episodes = new CopyOnWriteArrayList<>();
        List<EpisodeObject> episodeObjects = embeddedObject.getEpisodes();
        episodeObjects.stream().forEach(epObj -> episodes.add(getEpisodeFromGsonObject(epObj)));
        embedded.setEpisodes(episodes);
      }

      if (embeddedObject.getCast() != null) {
        List<Cast> castMembers = new CopyOnWriteArrayList<>();
        List<CastObject> castObjects = embeddedObject.getCast();
        castObjects.stream().forEach(castObj -> castMembers.add(getCastFromGsonObject(castObj)));
        embedded.setCastMembers(castMembers);
      }

      return embedded;
    } else {
      TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "EmbeddedObject was NULL.");
      return null;
    }
  }

  public static Cast getCastFromGsonObject(CastObject castObject) {
    if (castObject == null) {
      TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "CastObject was NULL.");
      return null;
    }

    Cast cast = new Cast();
    cast.setActor(getPersonFromGsonObject(castObject.getPerson()));
    cast.setCharacter(getPersonFromGsonObject(castObject.getCharacter()));
    return cast;
  }

  public static Externals getExternalFromGsonObject(ExternalsObject externalsObject) {
    if (externalsObject != null) {
      Externals externals = new Externals();

      if (externalsObject.getImdb() != null) {
        externals.setImdb(externalsObject.getImdb());
      } else {
        TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "externalsObject.imdb was NULL.");
      }

      if (externalsObject.getTvrage() != null) {
        externals.setTvRage(externalsObject.getTvrage());
      } else {
        TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "externalsObject.tvrage was NULL.");
      }

      if (externalsObject.getThetvdb() != null) {
        externals.setTheTvDb(externalsObject.getThetvdb());
      } else {
        TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "externalsObject.thetvdb was NULL.");
      }

      return externals;
    } else {
      TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "ExternalsObject was NULL.");
      return null;
    }
  }

  public static Rating getRatingFromGsonObject(RatingObject ratingObject) {
    if (ratingObject != null && ratingObject.getAverage() != null) {
      Rating rating = new Rating();
      rating.setAverage(ratingObject.getAverage());
      return rating;
    } else {
      TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "RatingObject was NULL.");
      return null;
    }
  }

  public static Schedule getScheduleFromGsonObject(ScheduleObject scheduleObject) {
    if (scheduleObject == null) {
      TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "ScheduleObject was NULL.");
      return null;
    }

    Schedule schedule = new Schedule();

    if (scheduleObject.getTime() != null) {
      try {
        schedule.setTime(LocalTime.parse(scheduleObject.getTime()));
      } catch (DateTimeParseException ex) {
        TVMaze4J.LOGGER.warn(
            LogMarkers.UTIL,
            "Was unable to set time in Schedule, due to DateTime Parsing exception.\n");
      }
    } else {
      TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "scheduleObject.time is NULL.");
    }

    if (scheduleObject.getDays() != null) {
      schedule.setDays(scheduleObject.getDays());
    } else {
      TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "scheduleObject.days is NULL.");
    }

    return schedule;
  }

  public static Season getSeasonFromGsonObject(SeasonObject seasonObject) {
    if (seasonObject == null) {
      TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "SeasonObject was NULL.");
      return null;
    }

    Season season = new Season();

    season.setId(seasonObject.getId());
    season.setUrl(seasonObject.getUrl());
    season.setNumber(seasonObject.getNumber());
    season.setName(seasonObject.getName());
    season.setEpisodeOrder(seasonObject.getEpisodeOrder());
    season.setNetwork(getNetworkFromGsonObject(seasonObject.getNetwork()));
    season.setWebChannel(getWebChannelFromGsonObject(seasonObject.getWebChannel()));
    season.setImages(getImagesFromGsonObject(seasonObject.getImage()));
    season.setSummary(seasonObject.getSummary());
    season.setLinks(getLinksFromGsonObject(seasonObject.get_links()));
    season.setPremiereDate(parseToLocalDate(seasonObject.getPremiereDate()));
    season.setEndDate(parseToLocalDate(seasonObject.getEndDate()));
    return season;
  }

  public static WebChannel getWebChannelFromGsonObject(WebChannelObject webChannelObject) {
    if (webChannelObject != null) {
      WebChannel webChannel = new WebChannel();

      if (webChannelObject.getId() != null) {
        webChannel.setId(webChannelObject.getId());
      } else {
        TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "webChannelObject.id was NULL.");
      }

      if (webChannelObject.getName() != null) {
        webChannel.setName(webChannelObject.getName());
      } else {
        TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "webChannelObject.name was NULL.");
      }

      if (webChannelObject.getCountry() != null) {
        webChannel.setCountry(getCountryFromGsonObject(webChannelObject.getCountry()));
      } else {
        TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "webChannelObject.country was NULL.");
      }

      return webChannel;
    } else {
      TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "WebChannelObject was NULL.");
      return null;
    }
  }

  public static Network getNetworkFromGsonObject(NetworkObject networkObject) {
    if (networkObject != null) {
      Network network = new Network();

      if (networkObject.getId() != null) {
        network.setId(networkObject.getId());
      } else {
        TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "networkObject.id was NULL.");
      }

      if (networkObject.getName() != null) {
        network.setName(networkObject.getName());
      } else {
        TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "networkObject.name was NULL.");
      }

      if (networkObject.getCountry() != null) {
        network.setCountry(getCountryFromGsonObject(networkObject.getCountry()));
      } else {
        TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "networkObject.country was NULL.");
      }

      return network;
    } else {
      TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "NetworkObject was NULL.");
      return null;
    }
  }

  public static Country getCountryFromGsonObject(CountryObject countryObject) {
    if (countryObject != null) {
      Country country = new Country();

      if (countryObject.getName() != null) {
        country.setName(countryObject.getName());
      } else {
        TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "countryObject.name was NULL.");
      }

      if (countryObject.getCode() != null) {
        country.setCode(countryObject.getCode());
      } else {
        TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "countryObject.code was NULL.");
      }

      if (countryObject.getTimezone() != null) {
        country.setTimeZone(countryObject.getTimezone());
      } else {
        TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "countryObject.timezone was NULL.");
      }

      return country;
    } else {
      TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "CountryObject was NULL.");
      return null;
    }
  }

  public static LocalDate parseToLocalDate(Date date) {
    LocalDate localDate = null;
    try {
      localDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date));
    } catch (DateTimeParseException ex) {
      TVMaze4J.LOGGER.warn(
          LogMarkers.UTIL,
          "Was unable to set LocalDate, due to a LocalDate Parsing exception.\n"
              + "Could not parse '"
              + date.toString()
              + "'.");
    }

    return localDate;
  }

  public static String encodeURL(String query) {
    return URLEncoder.encode(query, StandardCharsets.UTF_8);
  }
}
