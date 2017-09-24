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

/**
 * RatingImpl is on its own class, since we may expect to
 * get more types of rating other than just average.
 *
 * @author Ivan Skodje on 23/09/2017
 */
public class RatingImpl
{
	private float average = 0;

	public float getAverage()
	{
		return average;
	}

	public void setAverage(Float average)
	{
		if(average != null)
		{
			this.average = average;
		}
	}

	@Override
	public String toString()
	{
		return "" + average;
	}
}
