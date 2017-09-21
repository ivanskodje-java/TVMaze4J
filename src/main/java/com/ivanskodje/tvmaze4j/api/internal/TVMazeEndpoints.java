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

package com.ivanskodje.tvmaze4j.api.internal;

/**
 * A list of all end points for the TVMaze API.
 *
 * @author Ivan Skodje on 20/09/2017
 */
public final class TVMazeEndpoints
{
	/**
	 * The core URL for the TVMaze API endpoints.
	 */
	public static final String CORE_URL = "http://api.tvmaze.com/";

	/**
	 * Formatted URL used to retrieve all matching shows.
	 */
	public static final String SHOW_SEARCH = CORE_URL + "search/shows?q=%s";

	/**
	 * Formatted URL used to find one matching show.
	 */
	public static final String SHOW_SINGLE_SEARCH = CORE_URL + "singlesearch/shows?q=%s";

	/**
	 * URL used to find one matching show with all episodes attached.
	 */
	public static final String SHOW_SINGLE_SEARCH_WITH_EPISODES = SHOW_SINGLE_SEARCH + "&embed=episodes";

	/**
	 * Private URL used to find a show using tvrage, thetvdb or IMBD ID.
	 */
	private static final String SHOW_LOOKUP = CORE_URL + "lookup/shows";

	/**
	 * Formatted URL used to find a specific show using a TVRage ID.
	 */
	public static final String SHOW_LOOKUP_TVRAGE = SHOW_LOOKUP + "?tvrage=%s";

	/**
	 * Formatted URL used to find a specific show using a TheTVDB ID.
	 */
	public static final String SHOW_LOOKUP_THETVDB = SHOW_LOOKUP + "?thetvdb=%s";

	/**
	 * Formatted URL used to find a specific show using a IMDB ID.
	 */
	public static final String SHOW_LOOKUP_IMDB = SHOW_LOOKUP + "?imdb=%s";

	/**
	 * Formatted URL used to find people.
	 */
	public static final String PEOPLE_SEARCH = CORE_URL + "people?q=%s";

	/**
	 * URL used to get a list of episode scheduled to air today (US).
	 * <p>
	 * Episodes are returned in the order in which they are aired,
	 * and full information about the episode and the corresponding
	 * show is included.
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

	/**
	 * TODO: Get a formatted string for the image URLs
	 */
	public static final String IMAGES = "...";
}
