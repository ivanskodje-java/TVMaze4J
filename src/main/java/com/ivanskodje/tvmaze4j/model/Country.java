/*************************************************************************
 * This file (Country.java) is part of TVMaze4J.                         *
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
 * Country containing name, country code and time-zone.
 *
 * @author Ivan Skodje on 24/09/2017
 */
public class Country
{
	/**
	 * Country name.
	 */
	private String name = "";

	/**
	 * Country code.
	 */
	private String code = "";

	/**
	 * The time-zone.
	 */
	private String timeZone = "";

	/**
	 * Returns the name of the country.
	 *
	 * @return Country name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Set the name, if it is not null.
	 *
	 * @param name Country name.
	 */
	public void setName(String name)
	{
		if (name != null)
		{
			this.name = name;
		}
	}

	/**
	 * Returns the country code.
	 *
	 * @return The Country code, or an empty string.
	 */
	public String getCode()
	{
		return code;
	}

	/**
	 * Set the code, if it is not null.
	 *
	 * @param code Country code.
	 */
	public void setCode(String code)
	{
		if (code != null)
		{
			this.code = code;
		}
	}

	/**
	 * Returns the country's time-zone.
	 *
	 * @return Country's time-zone, or an empty string.
	 */
	public String getTimeZone()
	{
		return timeZone;
	}

	/**
	 * Set the country's time-zone, but only if it is not null.
	 *
	 * @param timeZone Country's time-zone.
	 */
	public void setTimeZone(String timeZone)
	{
		if (timeZone != null)
		{
			this.timeZone = timeZone;
		}
	}

	/**
	 * A descriptive text of the country.
	 *
	 * @return Country name, or an empty string.
	 */
	@Override
	public String toString()
	{
		return getName();
	}
}
