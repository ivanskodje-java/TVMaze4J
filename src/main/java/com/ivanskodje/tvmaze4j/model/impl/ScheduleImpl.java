/*
 * This file is part of TVMaze4J.
 *
 * TVMaze4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * TVMaze4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with TVMaze4J.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.ivanskodje.tvmaze4j.model.impl;

import java.time.LocalTime;
import java.util.List;

/**
 * @author Ivan Skodje on 23/09/2017
 */
public class ScheduleImpl
{
	private LocalTime time = null;
	private List<String> days = null;

	public LocalTime getTime()
	{
		return time;
	}

	public void setTime(LocalTime time)
	{
		if(time != null)
		{
			this.time = time;
		}
	}

	public List<String> getDays()
	{
		return days;
	}

	public void setDays(List<String> days)
	{
		if(days != null)
		{
			this.days = days;
		}
	}

	@Override
	public String toString()
	{
		if(getDays() == null || getTime() == null)
		{
			return "";
		}

		// Get days
		List<String> days = getDays();

		// Prepare empty string
		String toString = "";

		// Append Days
		for (int i = 0; i < days.size(); i++)
		{
			if (i != days.size() - 1)
			{
				toString += days.get(i) + ", ";
			}
			else
			{
				toString += days.get(i) + " at ";
			}
		}

		// Append LocalTime
		toString += getTime();

		// Return toString
		return toString;
	}
}
