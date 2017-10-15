/*************************************************************************
 * This file (Links.java) is part of TVMaze4J.                           *
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

/**
 * API Links to self, previous or next episode.
 *
 * @author Ivan Skodje on 23/09/2017
 */
public @Data class Links
{
	/**
	 * API URL to own Show or episode.
	 */
	private String self;

	/**
	 * API URL to the previous episode.
	 */
	private String previousEpisode;

	/**
	 * API URL to the next episode.
	 */
	private String nextEpisode;

	/**
	 * Returns the API URLs.
	 * <p>
	 * Formatted as:
	 * "Links: [ self: [self], previousEpisode: [previousEpisode], nextEpisode: [nextEpisode] ]"
	 *
	 * @return A description of the API URLs.
	 */
	@Override
	public String toString()
	{
		return "Links: [ self: " + getSelf() + ", previousEpisode: " + getPreviousEpisode() + ", nextEpisode: " + getNextEpisode() + " ]";
	}
}
