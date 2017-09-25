/*************************************************************************
 * This file (Schedule.java) is part of TVMaze4J.                        *
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

import java.time.LocalTime;
import java.util.List;

/**
 * The weekly schedule of the Show.
 *
 * @author Ivan Skodje on 23/09/2017
 */
public class Schedule
{
	/**
	 * Time the show airs.
	 */
	private LocalTime time = null;

	/**
	 * Days the show airs.
	 */
	private List<String> days = null;

	/**
	 * Returns the time the show airs,
	 * or null if none have been set.
	 *
	 * @return Time the show airs.
	 */
	public LocalTime getTime()
	{
		return time;
	}

	/**
	 * Sets the time the show airs,
	 * if it is not null.
	 *
	 * @param time Time the show airs.
	 */
	public void setTime(LocalTime time)
	{
		if (time != null)
		{
			this.time = time;
		}
	}

	/**
	 * Returns the days the show airs,
	 * or null if none have been set.
	 *
	 * @return Days the show airs.
	 */
	public List<String> getDays()
	{
		return days;
	}

	/**
	 * Sets the days the show airs,
	 * if it is not null.
	 *
	 * @param days Days the show airs.
	 */
	public void setDays(List<String> days)
	{
		if (days != null)
		{
			this.days = days;
		}
	}

	/**
	 * Returns a summary of when the show airs,
	 * or an empty string if it has not been set.
	 * <p>
	 * Note: We need to have both a day and time
	 * in order to return a readable schedule.
	 * <p>
	 * Formatted as:
	 * "[day1], [dayN] at [time]"
	 *
	 * @return A readable schedule.
	 */
	@Override
	public String toString()
	{
		if (getDays() == null || getTime() == null)
		{
			return "";
		}

		List<String> days = getDays();
		String schedule = "";

		for (int i = 0; i < days.size(); i++)
		{
			if (i != days.size() - 1)
			{
				schedule += days.get(i) + ", ";
			}
			else
			{
				schedule += days.get(i) + " at ";
			}
		}
		schedule += getTime();

		return schedule;
	}
}
