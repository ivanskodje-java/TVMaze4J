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

/**
 * API Links to self, previous or next episode.
 *
 * @author Ivan Skodje on 23/09/2017
 */
public class Links
{
	/**
	 * API URL to own show or episode.
	 */
	private String self = "";

	/**
	 * API URL to the previous episode.
	 */
	private String previousEpisode = "";

	/**
	 * API URL to the next episode.
	 */
	private String nextEpisode = "";

	/**
	 * Returns API URL to the own show/episode,
	 * or an empty string if none have been set.
	 *
	 * @return API URL to own show/episode.
	 */
	public String getSelf()
	{
		return self;
	}

	/**
	 * Sets the API URL to the own show/episode,
	 * if it is not null.
	 *
	 * @param self API URL to own show/episode.
	 */
	public void setSelf(String self)
	{
		if (self != null)
		{
			this.self = self;
		}
	}

	/**
	 * Returns API URL to the previous episode,
	 * or an empty string of none have been set.
	 *
	 * @return API URL to previous episode.
	 */
	public String getPreviousEpisode()
	{
		return previousEpisode;
	}

	/**
	 * Sets the API URL to previous episode,
	 * if it is not null.
	 *
	 * @param previousEpisode API URL to previous episode.
	 */
	public void setPreviousEpisode(String previousEpisode)
	{
		if (previousEpisode != null)
		{
			this.previousEpisode = previousEpisode;
		}
	}

	/**
	 * Returns API URL to the next episode,
	 * or an empty string of none have been set.
	 *
	 * @return API URL to next episode.
	 */
	public String getNextEpisode()
	{
		return nextEpisode;
	}

	/**
	 * Sets the API URL to next episode,
	 * if it is not null.
	 *
	 * @param nextEpisode API URL to next episode.
	 */
	public void setNextEpisode(String nextEpisode)
	{
		if (nextEpisode != null)
		{
			this.nextEpisode = nextEpisode;
		}
	}

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
