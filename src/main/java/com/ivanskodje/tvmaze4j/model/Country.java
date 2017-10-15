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

import lombok.Data;

/**
 * Country containing name, country code and time-zone.
 *
 * @author Ivan Skodje on 24/09/2017
 */
public @Data class Country
{
	/**
	 * Country name.
	 */
	private String name;

	/**
	 * Country code.
	 */
	private String code;

	/**
	 * The time-zone.
	 */
	private String timeZone;

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
