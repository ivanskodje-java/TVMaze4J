/*************************************************************************
 * This file (Episode.java) is part of TVMaze4J.                         *
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

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * Episode contains all the episode data retrieved from TVMaze.
 * <p>
 * Each variable in Episode have been set a default value.
 * This is done in places where getting a null (or 0 when talking about float or int) would
 * be undesirable.
 *
 * @author Ivan Skodje on 23/09/2017
 */
public @Data class Episode
{
	/**
	 * The Episode's TVMaze ID.
	 * IDs range 0 and up.
	 */
	private int id;

	/**
	 * Direct URL to the Episode on TVMaze.com.
	 */
	private String url;

	/**
	 * Episode name.
	 */
	private String name;

	/**
	 * Season number.
	 * <p>
	 * Seasons range 1 and up.
	 * Until set, it will be by default 0.
	 */
	private int season;

	/**
	 * Episode number.
	 * <p>
	 * Seasons range 1 and up.
	 * Until set, it will be by default 0.
	 */
	private int number;

	/**
	 * The date the episode aired.
	 */
	private LocalDate airDate;

	/**
	 * The time the episode aired.
	 */
	private LocalTime airTime;

	/**
	 * The date and time the episode aired.
	 * TODO: Change to LocalDateTime.
	 */
	private Date airStamp;

	/**
	 * The length of the episode in minutes.
	 * <p>
	 * Runtime vary, usually ranged 20 and up.
	 */
	private int runtime;

	/**
	 * Contains the URL addresses to the medium and original
	 * episode images.
	 */
	private Images images;

	/**
	 * The Episode summary is a small description of the
	 * episode with HTML formatting.
	 */
	private String summary;

	/**
	 * The Show this episode belongs in.
	 */
	private Show show;

	/**
	 * Links may contain API URLs to the episode, as well to
	 * a previous- and next episode.
	 */
	private Links links;

	/**
	 * Returns the episode season, episode and name.
	 * <p>
	 * Formatted as:
	 * "S[season]E[number]: [name]"
	 *
	 * @return A description of the episode.
	 */
	@Override
	public String toString()
	{
		return "S" + String.format("%02d", getSeason()) + "E" + String.format("%02d", getNumber()) + ": " + getName();
	}
}
