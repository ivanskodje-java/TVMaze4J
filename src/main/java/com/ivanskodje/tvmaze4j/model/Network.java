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

/**
 * Networks may run various shows.
 * Some familiar networks as example:
 * "CNN", "CBS", "Fox News", etc.
 *
 * @author Ivan Skodje on 23/09/2017
 */
public class Network
{
	/**
	 * The Network's TVMaze ID.
	 * IDs range 0 and up.
	 */
	private int id = -1;

	/**
	 * Network name.
	 */
	private String name = "";

	/**
	 * The Network's {@link Country}.
	 */
	private Country country = null;

	/**
	 * Returns the Network's TVMaze ID,
	 * or -1 if none has been set.
	 *
	 * @return Network's TVMaze ID.
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Sets the Network's TVMaze ID,
	 * if it is not null.
	 *
	 * @param id Network's TVMaze ID.
	 */
	public void setId(Integer id)
	{
		if (id != null)
		{
			this.id = id;
		}
	}

	/**
	 * Returns the Network name,
	 * or an empty string if none have been set.
	 *
	 * @return Network name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name of the Network,
	 * if it is not null.
	 *
	 * @param name Network name.
	 */
	public void setName(String name)
	{
		if (name != null)
		{
			this.name = name;
		}
	}

	/**
	 * Returns the Country of the Network,
	 * or null of none have been set.
	 *
	 * @return The Network's {@link Country}.
	 */
	public Country getCountry()
	{
		return country;
	}

	/**
	 * Sets the Country of the Network,
	 * if it is not null.
	 *
	 * @param country The Network's {@link Country}.
	 */
	public void setCountry(Country country)
	{
		if (country != null)
		{
			this.country = country;
		}
	}

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
