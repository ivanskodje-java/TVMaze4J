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
 * @author Ivan Skodje on 23/09/2017
 */
public class ExternalsImpl
{
	private int tvRage = -1;
	private int theTvDb = -1;
	private String imdb = "";

	public int getTvRage()
	{
		return tvRage;
	}

	public void setTvRage(Integer tvRage)
	{
		this.tvRage = (tvRage != null) ? tvRage : -1;
	}

	public int getTheTvDb()
	{
		return theTvDb;
	}

	public void setTheTvDb(Integer theTvDb)
	{
		this.theTvDb = (theTvDb != null) ? theTvDb : -1;
	}

	public String getImdb()
	{
		return imdb;
	}

	public void setImdb(String imdb)
	{
		this.imdb = imdb;
	}

	@Override
	public String toString()
	{
		return "tvRage: " + getTvRage() + ", theTvDb: " + getTheTvDb() + ", imdb: " + getImdb();
	}
}
