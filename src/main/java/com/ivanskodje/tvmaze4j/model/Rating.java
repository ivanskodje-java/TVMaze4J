/*************************************************************************
 * This file (Rating.java) is part of TVMaze4J.                          *
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
 * Show ratings.
 * <p>
 * Rating is on its own class, since we may expect to
 * get more types of rating other than just average.
 *
 * @author Ivan Skodje on 23/09/2017
 */
public @Data class Rating
{
	/**
	 * Show Rating.
	 * Average range 0 and up.
	 */
	private float average;

	/**
	 * Returns the average ranking,
	 * or an empty string if it has not been set.
	 * <p>
	 * Formatted as:
	 * "[average]"
	 *
	 * @return Average rank.
	 */
	@Override
	public String toString()
	{
		return "" + average;
	}
}
