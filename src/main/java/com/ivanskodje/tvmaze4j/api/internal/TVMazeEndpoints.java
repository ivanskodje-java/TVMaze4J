package com.ivanskodje.tvmaze4j.api.internal;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TVMazeEndpoints {

  public static final String CORE_URL = "http://api.tvmaze.com/";
  public static final String SHOW_SEARCH = CORE_URL + "search/shows?q=%s";
  public static final String SHOW_SINGLE_SEARCH = CORE_URL + "singlesearch/shows?q=%s";
  public static final String SHOW_SINGLE_SEARCH_WITH_EPISODES =
      SHOW_SINGLE_SEARCH + "&embed=episodes";
  public static final String SHOW_LOOKUP_TVRAGE = CORE_URL + "lookup/shows?tvrage=%s";
  public static final String SHOW_LOOKUP_THETVDB = CORE_URL + "lookup/shows?thetvdb=%s";
  public static final String SHOW_LOOKUP_IMDB = CORE_URL + "lookup/shows?imdb=%s";
  public static final String PEOPLE_SEARCH = CORE_URL + "search/people?q=%s";
  public static final String SCHEDULE = CORE_URL + "schedule";
  public static final String SCHEDULE_IN_COUNTRY = SCHEDULE + "?country=%s";
  public static final String SCHEDULE_ON_DATE = SCHEDULE + "?date=%s";
  public static final String SCHEDULE_IN_COUNTRY_ON_DATE = SCHEDULE + "?country=%s&date=%s";
  public static final String SCHEDULE_FULL = SCHEDULE + "/full";
  public static final String SHOW_INFO = CORE_URL + "shows/%s";
  public static final String SHOW_INFO_WITH_CAST = SHOW_INFO + "?embed=cast";
  public static final String EPISODE_LIST = CORE_URL + "shows/%s/episodes";
  public static final String EPISODE_LIST_WITH_SPECIALS = EPISODE_LIST + "?specials=1";
  public static final String EPISODE_BY_NUMBER =
      CORE_URL + "shows/%s/episodebynumber?season=%s&number=%s";
  public static final String EPISODES_BY_DATE = CORE_URL + "shows/%s/episodesbydate?date=%s";
  public static final String EPISODES_BY_SEASON = CORE_URL + "seasons/%s/episodes";
  public static final String SHOW_SEASONS = CORE_URL + "shows/%s/seasons";
}
