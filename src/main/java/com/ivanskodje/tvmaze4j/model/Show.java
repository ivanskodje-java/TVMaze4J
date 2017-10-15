/*************************************************************************
 * This file (Show.java) is part of TVMaze4J.                            *
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

package com.ivanskodje.tvmaze4j.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * The Show.
 *
 * @author Ivan Skodje on 21/09/2017
 */
public @Data class Show
{
	/**
	 * Search relevance score.
	 * <p>
	 * Score is estimated to range 0 and up to 40.
	 * <p>
	 * When searching with terms that provide multiple results,
	 * the result with the highest search relevance score will
	 * return when searching for a single show.
	 */
	private float searchRelevanceScore;

	/**
	 * The Show's TVMaze ID.
	 * IDs range 0 and up.
	 */
	private int id;

	/**
	 * Direct URL to the Show on TVMaze.com.
	 */
	private String url;

	/**
	 * Show name.
	 */
	private String name;

	/**
	 * Show type.
	 * Examples: "Talk Show", "Documentary", "Scripted", "Reality".
	 */
	private String type;

	/**
	 * The spoken language.
	 */
	private String language;

	/**
	 * Show genres.
	 */
	private List<String> genres;

	/**
	 * The Show's current status.
	 * Examples: "Running", "In Development".
	 */
	private String status;

	/**
	 * The length of each episode in minutes.
	 * <p>
	 * Runtime vary, usually ranged 20 and up.
	 */
	private int runtime;

	/**
	 * The date of the Show's premiere.
	 * TODO: Change from Date to LocalDateTime.
	 */
	private Date premiered;

	/**
	 * URL to the Show's official web-site.
	 */
	private String officialSite;

	/**
	 * Show schedule.
	 */
	private Schedule schedule;

	/**
	 * Show rating.
	 */
	private Rating rating;

	/**
	 * The most popular Show on TVMaze would have a weight value of 100,
	 * while the worst would have a value of 0.
	 * <p>
	 * Weight is ranged 0 and up to 100.
	 */
	private int weight;

	/**
	 * Show Network. Ex: "CNN", "Bloomberg TV", "CBS Sports Network".
	 */
	private Network network;

	/**
	 * Some shows originate from the web, such as "YouTube Red".
	 */
	private WebChannel webChannel;

	/**
	 * Externals contain the Show IDs from IMDB, TVRage and TheTVDB.
	 */
	private Externals externals;

	/**
	 * Contains the URL addresses to the medium and original
	 * Show images.
	 */
	private Images images;

	/**
	 * The Show summary is a small description of the
	 * Show with HTML formatting.
	 */
	private String summary;

	/**
	 * Updated is a Unix Epoch value. It is updated to reflect
	 * the time and date of the last update to the Show or episodes.
	 * <p>
	 * A common use for this value may be to compare your own local cache
	 * with TVMaze to check if there have been any changes to the Show.
	 * <p>
	 * Keep in mind that MazeTV stores their own Show cache for 24 hours.
	 */
	private int updated;

	/**
	 * Links may contain API URLs to the Show, as well to
	 * a previous- and next episode.
	 */
	private Links links;

	/**
	 * Embedded may contain a Show, or a list of episodes.
	 */
	private Embedded embedded;

	/**
	 * Returns a list of the Show's {@link Episode}s,
	 * or null if none have been set.
	 * <p>
	 * Episodes are stored and retrieved from {@link Embedded}.
	 *
	 * @return List of {@link Episode}s.
	 */
	public List<Episode> getEpisodes()
	{
		if (embedded == null)
		{
			return null;
		}
		return embedded.getEpisodes();
	}

	/**
	 * Sets a list of the Show's {@link Episode}s,
	 * if it is not null.
	 * <p>
	 * If embedded is null, we instantiate it before
	 * adding the shows.
	 * <p>
	 * Episodes are stored and retrieved from {@link Embedded}.
	 *
	 * @param episodes List of {@link Episode}s.
	 */
	public void setEpisodes(List<Episode> episodes)
	{
		if (episodes != null)
		{
			if (embedded == null)
			{
				embedded = new Embedded();
			}
			embedded.setEpisodes(episodes);
		}
	}


	/**
	 * Returns a list of the Show's {@link Cast} Members,
	 * or null if none have been set.
	 * <p>
	 * Cast are stored and retrieved from {@link Embedded}.
	 *
	 * @return List of {@link Cast} Members.
	 */
	public List<Cast> getCastMembers()
	{
		if (embedded == null)
		{
			return null;
		}
		return embedded.getCastMembers();
	}

	/**
	 * Sets a list of the Show's {@link Cast} Members,
	 * if it is not null.
	 * <p>
	 * If embedded is null, we instantiate it before
	 * adding the cast members.
	 * <p>
	 * Cast members are stored and retrieved from {@link Embedded}.
	 *
	 * @param castMembers List of {@link Cast} Members.
	 */
	public void setCastMembers(List<Cast> castMembers)
	{
		if (castMembers != null)
		{
			if (embedded == null)
			{
				embedded = new Embedded();
			}
			embedded.setCastMembers(castMembers);
		}
	}

	/**
	 * Returns the Show name.
	 * <p>
	 * Formatted as:
	 * "[name]"
	 *
	 * @return A description of the show.
	 */
	@Override
	public String toString()
	{
		return getName();
	}
}
