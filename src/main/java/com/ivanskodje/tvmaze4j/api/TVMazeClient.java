/*
 * This file is part of TVMaze4J.
 *
 * TVMaze4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * TVMaze4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with TVMaze4J.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.ivanskodje.tvmaze4j.api;

import com.ivanskodje.tvmaze4j.model.impl.EpisodeImpl;
import com.ivanskodje.tvmaze4j.model.impl.ShowImpl;

import java.time.LocalDate;
import java.util.List;

/**
 * This is a client that is used to simplify interaction with the TVMaze API.
 * The main way of interacting with the TVMaze API.
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
	List<ShowImpl> showSearch(String query);

	/**
	 * Gets a list of shows matching the query.
	 * <p>
	 * This is the equivalent of <code>showSearch(query, fetchEpisodes, false)</code>,
	 *
	 * @param query         Search query.
	 * @param fetchEpisodes Whether or not we want to fetch all episodes with the shows.
	 * @return A list of Shows matching the query, with all episodes.
	 */
	List<ShowImpl> showSearch(String query, boolean fetchEpisodes);

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
	List<ShowImpl> showSearch(String query, boolean fetchEpisodes, boolean fetchSpecials);

	/**
	 * Gets a list of shows matching the query.
	 * <p>
	 * This is the equivalent of <code>showSingleSearch(query, false)</code>
	 *
	 * @param query Search query.
	 * @return A list of Shows matching the query.
	 */
	ShowImpl showSingleSearch(String query);

	/**
	 * Gets a list of shows matching the query.
	 *
	 * @param query        Search query.
	 * @param withEpisodes Whether or not you want episodes included with the shows.
	 * @return A list of Shows matching the query.
	 */
	ShowImpl showSingleSearch(String query, boolean fetchEpisodes);


	/**
	 * Gets a list of Episodes belonging to the ShowImpl matching the TVMaze ID.
	 * <p>
	 * This is the equivalent of <code>showEpisodeList(id, false)</code>
	 *
	 * @param id TVMaze ShowImpl ID.
	 * @return A list of Episodes matching the show ID.
	 */
	List<EpisodeImpl> showEpisodeList(int showId);


	/**
	 * Gets a list of Episodes belonging to the ShowImpl matching the TVMaze ID.
	 *
	 * @param id            TVMaze ShowImpl ID.
	 * @param fetchSpecials Whether or not to fetch the special episodes.
	 * @return A list of Episodes matching the show ID - possibly with specials.
	 */
	List<EpisodeImpl> showEpisodeList(int showId, boolean fetchSpecials);


	/**
	 * Get the matching episode of show ID, Season, and EpisodeImpl number.
	 *
	 * @param showId TVMaze ID.
	 * @param season Season number.
	 * @param number EpisodeImpl number.
	 * @return EpisodeImpl.
	 */
	EpisodeImpl episodeByNumber(int showId, int season, int number);

	/**
	 * Get a list of episodes from the show id, matching the given date.
	 *
	 * @param showId TVmaze ID.
	 * @param date   The specific date the episode aired.
	 * @return A list of matching episodes (of any).
	 */
	List<EpisodeImpl> episodesByDate(int showId, LocalDate date);

	/**
	 * Find the show matching the TVMaze ID.
	 *
	 * @param id
	 * @return
	 */
	ShowImpl showLookUp(int showId);

	/**
	 * Find the show matching the TVRage ID.
	 *
	 * @param id TVRage ID
	 * @return ShowImpl
	 */
	ShowImpl showLookUpFromTvRage(int tvRageId);

	/**
	 * Find the show matching the TheTVDB ID.
	 *
	 * @param id TheTVDB ID
	 * @return ShowImpl
	 */
	ShowImpl showLookUpFromTheTvDb(int theTvdbId);

	/**
	 * Find the show matching the IMDB ID.
	 *
	 * @param id IMDB ID
	 * @return ShowImpl
	 */
	ShowImpl showLookUpFromImdb(String imdbId);
}