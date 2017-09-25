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
	 * Get the matching episode of show ID, Season, and Episode number.
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
}
