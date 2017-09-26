/*************************************************************************
 * This file (TVMazeClient.java) is part of TVMaze4J.                    *
 *                                                                       *
 * Copyright (c) 2017 Ivan Skodje.                                       *
 *                                                                       *
 * TVMaze4J is free software: you can redistribute it and/or modify      *
 * it under the terms of the GNU General Public License as published by  *
 * the Free Software Foundation, either version 3 of the License, or     *
 * (at your option) any later version.                                   *
 *                                                                       *
 * TVMaze4J is distributed in the hope that it will be useful,           *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 * GNU General Public License for more details.                          *
 *                                                                       *
 * You should have received a copy of the GNU General Public License     *
 * along with TVMaze4J.  If not, see <http://www.gnu.org/licenses/>.     *
 *************************************************************************/

package com.ivanskodje.tvmaze4j.api;

import com.ivanskodje.tvmaze4j.model.Episode;
import com.ivanskodje.tvmaze4j.model.Season;
import com.ivanskodje.tvmaze4j.model.Show;

import java.time.LocalDate;
import java.util.List;

/**
 * The main way of interacting with the TVMaze API.
 * This is a client that is used to simplify interaction with the TVMaze API.
 *
 * @author Ivan Skodje on 19/09/2017
 */
public interface TVMazeClient
{
	/**
	 * Gets a list of shows matching the query.
	 * <p>
	 * This is the equivalent of <code>showSearch(query, false)</code>,
	 * and  <code>showSearch(query, false, false)</code>
	 *
	 * @param query Search query.
	 * @return A list of Shows matching the query.
	 */
	List<Show> showSearch(String query);

	/**
	 * Gets a list of shows matching the query.
	 * <p>
	 * This is the equivalent of <code>showSearch(query, fetchEpisodes, false)</code>,
	 *
	 * @param query         Search query.
	 * @param fetchEpisodes Whether or not we want to fetch all episodes with the shows.
	 * @return A list of Shows matching the query, with all episodes.
	 */
	List<Show> showSearch(String query, boolean fetchEpisodes);

	/**
	 * Gets a list of shows matching the query.
	 * <p>
	 * Note: If fetchEpisodes is false, fetch special won't do anything.
	 *
	 * @param query         Search query.
	 * @param fetchEpisodes Whether or not we want to fetch all episodes with the shows.
	 * @param fetchSpecials Whether or not to get specials together with episodes
	 * @return A list of Shows matching the query, with all episodes + specials.
	 */
	List<Show> showSearch(String query, boolean fetchEpisodes, boolean fetchSpecials);

	/**
	 * Gets a list of shows matching the query.
	 * <p>
	 * This is the equivalent of <code>showSingleSearch(query, false)</code>
	 *
	 * @param query Search query.
	 * @return A list of Shows matching the query.
	 */
	Show showSingleSearch(String query);

	/**
	 * Gets a list of shows matching the query.
	 *
	 * @param query         Search query.
	 * @param fetchEpisodes Whether or not you want episodes included with the shows.
	 * @return A list of Shows matching the query.
	 */
	Show showSingleSearch(String query, boolean fetchEpisodes);

	/**
	 * Gets a list of Episodes belonging to the Show matching the TVMaze ID.
	 * <p>
	 * This is the equivalent of <code>showEpisodeList(id, false)</code>
	 *
	 * @param showId TVMaze Show ID.
	 * @return A list of Episodes matching the show ID.
	 */
	List<Episode> showEpisodeList(int showId);

	/**
	 * Gets a list of Episodes belonging to the Show matching the TVMaze ID.
	 *
	 * @param showId        TVMaze Show ID.
	 * @param fetchSpecials Whether or not to fetch the special episodes.
	 * @return A list of Episodes matching the show ID - possibly with specials.
	 */
	List<Episode> showEpisodeList(int showId, boolean fetchSpecials);

	/**
	 * Get the matching episode from the Show ID, Season, and Episode number.
	 *
	 * @param showId TVMaze ID.
	 * @param season Season number.
	 * @param number Episode number.
	 * @return Episode.
	 */
	Episode episodeByNumber(int showId, int season, int number);

	/**
	 * Get a list of episodes from the show id, matching the given date.
	 *
	 * @param showId TVmaze ID.
	 * @param date   The specific date the episode aired.
	 * @return A list of matching episodes (of any).
	 */
	List<Episode> episodesByDate(int showId, LocalDate date);

	/**
	 * Find the show matching the TVMaze ID.
	 *
	 * @param showId
	 * @return
	 */
	Show showLookUp(int showId);

	/**
	 * Find the show matching the TVRage ID.
	 *
	 * @param tvRageId TVRage ID
	 * @return Show
	 */
	Show showLookUpFromTvRage(int tvRageId);

	/**
	 * Find the show matching the TheTVDB ID.
	 *
	 * @param theTvdbId TheTVDB ID
	 * @return Show
	 */
	Show showLookUpFromTheTvDb(int theTvdbId);

	/**
	 * Find the show matching the IMDB ID.
	 *
	 * @param imdbId IMDB ID
	 * @return Show
	 */
	Show showLookUpFromImdb(String imdbId);

	/**
	 * Returns today's episode schedule.
	 * <p>
	 * This is the equivalent of <code>getSchedule(null)</code>
	 * and <code>getSchedule(null, null)</code>.
	 *
	 * @return List of today's {@link Episode} schedule.
	 */
	List<Episode> getSchedule();

	/**
	 * Returns today's episode schedule in the given country,
	 * using ISO 3166-1 code formatting (https://en.wikipedia.org/wiki/ISO_3166-1).
	 * <p>
	 * This is the equivalent of <code>getSchedule(isoCountryCode, null)</code>.
	 *
	 * @return List of today's {@link Episode} schedule from the country.
	 */
	List<Episode> getSchedule(String isoCountryCode);

	/**
	 * Returns the date's episode schedule.
	 * Date using ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601#Dates).
	 * <p>
	 * This is the equivalent of <code>getSchedule(null, date)</code>.
	 *
	 * @return List of the date's {@link Episode} schedule.
	 */
	List<Episode> getSchedule(LocalDate date);

	/**
	 * Returns the date's episode schedule in the given country.
	 * Country code using ISO 3166-1 (https://en.wikipedia.org/wiki/ISO_3166-1).
	 * Date using ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601#Dates).
	 *
	 * @return List of the date's {@link Episode} schedule from the country.
	 */
	List<Episode> getSchedule(String isoCountryCode, LocalDate date);


	/**
	 * Returns the full schedule of all the oncoming registered TVMaze episodes.
	 *
	 * @return A list of all future {@link Episode} schedules.
	 */
	List<Episode> getFullSchedule();

	/**
	 * Returns a list of Show seasons for the given Show
	 */
	List<Season> getSeasons(int showId);
}
