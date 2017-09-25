/*************************************************************************
 * This file (Externals.java) is part of TVMaze4J.                       *
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
 * Externals contain the external IDs to other databases that
 * contain a lot of information about various shows and episodes.
 *
 * @author Ivan Skodje on 23/09/2017
 */
public class Externals
{
	/**
	 * TVRage ID.
	 * IDs range 0 and up.
	 */
	private int tvRage = -1;

	/**
	 * TheTVDB ID.
	 * IDs range 0 and up.
	 */
	private int theTvDb = -1;

	/**
	 * IMDB ID.
	 * Who knows, but it certainly will not be empty.
	 */
	private String imdb = "";

	/**
	 * Returns the TVRage ID,
	 * or -1 if none have been set.
	 *
	 * @return TVRage ID.
	 */
	public int getTvRage()
	{
		return tvRage;
	}

	/**
	 * Sets the TVRage ID,
	 * if it is not null.
	 *
	 * @param tvRage TVRage ID.
	 */
	public void setTvRage(Integer tvRage)
	{
		if (tvRage != null)
		{
			this.tvRage = tvRage;
		}
	}

	/**
	 * Returns the TheTVDB ID,
	 * or -1 if none have been set.
	 *
	 * @return TheTVDB ID.
	 */
	public int getTheTvDb()
	{
		return theTvDb;
	}

	/**
	 * Sets the TheTVDB ID,
	 * if it is not null.
	 *
	 * @param theTvDb TheTVDB ID.
	 */
	public void setTheTvDb(Integer theTvDb)
	{
		if (theTvDb != null)
		{
			this.theTvDb = theTvDb;
		}
	}

	/**
	 * Returns the IMDB ID,
	 * or an empty string if none have been set.
	 *
	 * @return IMDB ID.
	 */
	public String getImdb()
	{
		return imdb;
	}

	/**
	 * Sets the IMDB ID,
	 * if it is not null.
	 *
	 * @param imdb IMDB ID.
	 */
	public void setImdb(String imdb)
	{
		if (imdb != null)
		{
			this.imdb = imdb;
		}
	}

	/**
	 * Returns all externals.
	 * <p>
	 * Formatted as:
	 * "tvRage: [tvRage], theTvDb: [theTvDb], imdb: [imdb]"
	 *
	 * @return A description of the external IDs.
	 */
	@Override
	public String toString()
	{
		return "tvRage: " + getTvRage() + ", theTvDb: " + getTheTvDb() + ", imdb: " + getImdb();
	}
}
