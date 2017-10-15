/*************************************************************************
 * This file (ScheduleObject.java) is part of TVMaze4J.                  *
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

package com.ivanskodje.tvmaze4j.api.internal.gson.objects;

import com.ivanskodje.tvmaze4j.api.internal.TVMazeError;

import java.util.ArrayList;
import java.util.List;

/**
 * This represents a json Schedule object.
 * <p>
 * It contains the days the person airs, as well as the time.
 *
 * @author ivanskodje on 20.09.17
 */
public class ScheduleObject
{
	private String time;
	private List<String> days;

	public String getTime()
	{
		return TVMazeError.getString(time);
	}

	public List<String> getDays()
	{
		return (days != null) ? days : new ArrayList<>();
	}
}
