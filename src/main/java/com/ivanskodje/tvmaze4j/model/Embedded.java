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

import lombok.Data;

import java.util.List;

/**
 * Some shows or episodes may contain embedded content.
 * This is the class we use to store such content.
 * <p>
 * It may contain either a Show or an episode, or perhaps both.
 *
 * @author Ivan Skodje on 23/09/2017
 */
public @Data class Embedded
{
	/**
	 * A Show.
	 */
	private Show show;

	/**
	 * A list of episodes.
	 */
	private List<Episode> episodes;

	/**
	 * A list of cast members.
	 */
	private List<Cast> castMembers;

	/**
	 * To string will be formatted as either
	 * "[Show]",
	 * "[#] episodes"
	 * or
	 * "[Show] has [#] episodes".
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
