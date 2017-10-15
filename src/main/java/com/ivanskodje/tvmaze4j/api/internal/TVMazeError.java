/*************************************************************************
 * This file (TVMazeError.java) is part of TVMaze4J.                     *
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

package com.ivanskodje.tvmaze4j.api.internal;

/**
 * Error handling methods.
 *
 * @author ivanskodje on 20.09.17
 */
public class TVMazeError
{
	/**
	 * Used to safeguard that we do NOT return null.
	 *
	 * @param value String object.
	 * @return A string that is not null.
	 */
	public static String getString(String value)
	{
		return (value != null) ? value : "";
	}

	/**
	 * Used to safeguard that we do NOT return null.
	 *
	 * @param value Integer object.
	 * @return An integer that is not null.
	 */
	public static int getInteger(Integer value)
	{
		return (value != null) ? value : -1;
	}

	/**
	 * Used to safeguard that we do NOT return null.
	 *
	 * @param value Float object.
	 * @return A float that is not null.
	 */
	public static float getFloat(Float value)
	{
		return (value != null) ? value : -1f;
	}
}
