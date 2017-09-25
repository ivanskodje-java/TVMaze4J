/*************************************************************************
 * This file (Embedded.java) is part of TVMaze4J.                        *
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

import java.util.List;

/**
 * Some shows or episodes may contain embedded content.
 * This is the class we use to store such content.
 * <p>
 * It may contain either a show or an episode, or perhaps both.
 *
 * @author Ivan Skodje on 23/09/2017
 */
public class Embedded
{
	/**
	 * A show.
	 */
	private Show show = null;

	/**
	 * A list of episodes.
	 */
	private List<Episode> episodes = null;

	/**
	 * Returns the Show embedded,
	 * or null if none have been set.
	 *
	 * @return A {@link Show} or <code>null</code>.
	 */
	public Show getShow()
	{
		return show;
	}

	/**
	 * Sets the Show, if it is not null.
	 *
	 * @param show A {@link Show}.
	 */
	public void setShow(Show show)
	{
		if (show != null)
		{
			this.show = show;
		}
	}

	/**
	 * Returns the Episode embedded,
	 * or null if none have been set.
	 *
	 * @return An {@link Episode} or <code>null</code>.
	 */
	public List<Episode> getEpisodes()
	{
		return episodes;
	}

	/**
	 * Sets the Episode, if it is not null.
	 *
	 * @param episodes An {@link Episode} or <code>null</code>.
	 */
	public void setEpisodes(List<Episode> episodes)
	{
		if (episodes != null)
		{
			this.episodes = episodes;
		}
	}

	/**
	 * To string will be formatted as either
	 * "[show]",
	 * "[#] episodes"
	 * or
	 * "[show] has [#] episodes".
	 *
	 * @return A description of the embedded content.
	 */
	@Override
	public String toString()
	{
		String message = "";
		if (getShow() != null)
		{
			message += "" + getShow().getName();

			if (getEpisodes() != null)
			{
				message += " has ";
			}
		}

		if (getEpisodes() != null)
		{
			message += getEpisodes().size() + " episodes";
		}

		return message;
	}
}
