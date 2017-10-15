/*************************************************************************
 * This file (Network.java) is part of TVMaze4J.                         *
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
 * Networks may run various shows.
 * Some familiar networks as example:
 * "CNN", "CBS", "Fox News", etc.
 *
 * @author Ivan Skodje on 23/09/2017
 */
public @Data class Network
{
	/**
	 * The Network's TVMaze ID.
	 * IDs range 0 and up.
	 */
	private int id;

	/**
	 * Network name.
	 */
	private String name;

	/**
	 * The Network's {@link Country}.
	 */
	private Country country;

	/**
	 * Returns the Country name.
	 * <p>
	 * Formatted as:
	 * "[name]"
	 *
	 * @return A description of the {@link Country}.
	 */
	@Override
	public String toString()
	{
		return getName();
	}
}
