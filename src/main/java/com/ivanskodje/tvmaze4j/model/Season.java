/*************************************************************************
 * This file (Season.java) is part of TVMaze4J.                          *
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

/**
 * The Season of a Show.
 * This should give you a small overview of the season.
 *
 * @author Ivan Skodje on 26/09/2017
 */
public @Data class Season
{
	/**
	 * The Season's TVMaze ID.
	 * IDs range 0 and up.
	 */
	private int id;

	/**
	 * Direct URL to the Season on TVMaze.com.
	 */
	private String url;

	/**
	 * This season's number.
	 * Expected range 1 and up.
	 */
	private int number; // season number

	/**
	 * Season name.
	 * This is used when the Network have given a season a special name.
	 */
	private String name;

	/**
	 * The number of episodes in this season.
	 * Expected range 1 and up.
	 */
	private int episodeOrder; // number of episodes

	/**
	 * The date of the seasons's premiere.
	 */
	private LocalDate premiereDate;

	/**
	 * The date when the season ended.
	 */
	private LocalDate endDate;

	/**
	 * The Network the season is run on.
	 * Ex: "CNN", "Bloomberg TV", "CBS Sports Network".
	 */
	private Network network;

	/**
	 * The Web Channel the season is run on.
	 * Ex: "YouTube Red".
	 */
	private WebChannel webChannel;

	/**
	 * Contains the URL addresses to the medium and original
	 * Show images.
	 */
	private Images images;

	/**
	 * The Season's summary.
	 * Uses HTML formatting.
	 */
	private String summary;

	/**
	 * Links contain a self API URL to this season.
	 */
	private Links links;

	/**
	 * Returns the season name.
	 * <p>
	 * Formatted as:
	 * "Season [number] - [name]"
	 *
	 * @return A description of the season.
	 */
	@Override
	public String toString()
	{
		return "Season " + String.format("%02d", getNumber()) + " - " + getName();
	}
}
