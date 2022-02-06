package com.ivanskodje.tvmaze4j.api;

import com.ivanskodje.tvmaze4j.model.Episode;
import com.ivanskodje.tvmaze4j.model.Person;
import com.ivanskodje.tvmaze4j.model.Season;
import com.ivanskodje.tvmaze4j.model.Show;
import java.time.LocalDate;
import java.util.List;

public interface TVMazeClient {

  List<Show> showSearch(String query);

  List<Show> showSearch(String query, boolean fetchEpisodes);

  List<Show> showSearch(String query, boolean fetchEpisodes, boolean fetchSpecials);

  Show showSingleSearch(String query);

  Show showSingleSearch(String query, boolean fetchEpisodes);

  List<Person> peopleSearch(String query);

  List<Episode> showEpisodeList(int showId);

  List<Episode> showEpisodeList(int showId, boolean fetchSpecials);

  Episode episodeByNumber(int showId, int season, int number);

  List<Episode> episodesByDate(int showId, LocalDate date);

  List<Episode> episodesBySeason(int seasonId);

  Show showInfo(int showId);

  Show showInfo(int showId, boolean fetchCast);

  Show showLookUpFromTvRage(int tvRageId);

  Show showLookUpFromTheTvDb(int theTvdbId);

  Show showLookUpFromImdb(String imdbId);

  List<Episode> getSchedule();

  List<Episode> getSchedule(String isoCountryCode);

  List<Episode> getSchedule(LocalDate date);

  List<Episode> getSchedule(String isoCountryCode, LocalDate date);

  List<Episode> getFullSchedule();

  List<Season> getSeasons(int showId);
}
