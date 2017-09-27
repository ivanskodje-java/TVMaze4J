/*************************************************************************
 * This file (TVMazeEndpoints.java) is part of TVMaze4J.                 *
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

package com.ivanskodje.tvmaze4j.api.internal;

/**
 * A list of all end points for the TVMaze API.
 *
 * @author Ivan Skodje on 20/09/2017
 */
public final class TVMazeEndpoints
{
	// ------ SEARCH ------ //
	/**
	 * The core URL for the TVMaze API endpoints.
	 */
	public static final String CORE_URL = "http://api.tvmaze.com/";

	/**
	 * Formatted URL used to retrieve all matching shows.
	 */
	public static final String SHOW_SEARCH = CORE_URL + "search/shows?q=%s";

	/**
	 * Formatted URL used to find one matching Show.
	 */
	public static final String SHOW_SINGLE_SEARCH = CORE_URL + "singlesearch/shows?q=%s";

	/**
	 * URL used to find one matching Show with all episodes attached.
	 */
	public static final String SHOW_SINGLE_SEARCH_WITH_EPISODES = SHOW_SINGLE_SEARCH + "&embed=episodes";

	/**
	 * Formatted URL used to find a specific Show using a TVRage ID.
	 */
	public static final String SHOW_LOOKUP_TVRAGE = CORE_URL + "lookup/shows?tvrage=%s";

	/**
	 * Formatted URL used to find a specific Show using a TheTVDB ID.
	 */
	public static final String SHOW_LOOKUP_THETVDB = CORE_URL + "lookup/shows?thetvdb=%s";

	/**
	 * Formatted URL used to find a specific Show using a IMDB ID.
	 */
	public static final String SHOW_LOOKUP_IMDB = CORE_URL + "lookup/shows?imdb=%s";

	/**
	 * Formatted URL used to find people matching the search query.
	 */
	public static final String PEOPLE_SEARCH = CORE_URL + "search/people?q=%s";


	// ------ SCHEDULE ------ //
	/**
	 * URL used to get a list of episode scheduled to air today (US).
	 * <p>
	 * Episodes are returned in the order in which they are aired,
	 * and full information about the episode and the corresponding
	 * Show is included.
	 */
	public static final String SCHEDULE = CORE_URL + "schedule";

	/**
	 * Formatted URL used to get a list of episodes scheduled to air in the given country.
	 */
	public static final String SCHEDULE_IN_COUNTRY = SCHEDULE + "?country=%s";

	/**
	 * Formatted URL used to get a list of episodes scheduled to air on the given date.
	 */
	public static final String SCHEDULE_ON_DATE = SCHEDULE + "?date=%s";

	/**
	 * Formatted URL used to get a list of episodes schedules to air in the given country
	 * on the given date.
	 */
	public static final String SCHEDULE_IN_COUNTRY_ON_DATE = SCHEDULE + "?country=%s&date=%s";

	/**
	 * URL used to get a full schedule of ALL future episodes.
	 * Warning: This may be at least several MB large.
	 */
	public static final String SCHEDULE_FULL = SCHEDULE + "/full";

	
	// ------ SHOWS ------ //
	/**
	 * Formatted URL used to find a specific Show using a TVMaze ID.
	 */
	public static final String SHOW_INFO = CORE_URL + "shows/%s";

	/**
	 * Formatted URL used to find a specific Show using a TVMaze ID, with cast embedded.
	 */
	public static final String SHOW_INFO_WITH_CAST = SHOW_INFO + "?embed=cast";

	/**
	 * Formatted URL used to get a list of episodes belonging to a Show.
	 */
	public static final String EPISODE_LIST = CORE_URL + "shows/%s/episodes";

	/**
	 * Formatted URL used to get a list of episodes with specials belonging to a Show.
	 */
	public static final String EPISODE_LIST_WITH_SPECIALS = EPISODE_LIST + "?specials=1";

	/**
	 * Formatted URL used to get a single episode matching Show ID, season number, and episode number.
	 */
	public static final String EPISODE_BY_NUMBER = CORE_URL + "shows/%s/episodebynumber?season=%s&number=%s";

	/**
	 * Formatted URL for getting a list of episodes matching Show ID, and the date it aired.
	 */
	public static final String EPISODES_BY_DATE = CORE_URL + "shows/%s/episodesbydate?date=%s";

	/**
	 * Formatted URL for getting a list of episodes in the same season, as the given episode ID.
	 */
	public static final String EPISODES_BY_SEASON = CORE_URL + "seasons/%s/episodes";

	/**
	 * Formatted URL for getting a list of seasons matching the Show ID.
	 */
	public static final String SHOW_SEASONS = CORE_URL + "shows/%s/seasons";

}
