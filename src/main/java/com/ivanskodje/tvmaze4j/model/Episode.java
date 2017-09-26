/*************************************************************************
 * This file (Episode.java) is part of TVMaze4J.                         *
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

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * Episode contains all the episode data retrieved from TVMaze.
 * <p>
 * Each variable in Episode have been set a default value.
 * This is done in places where getting a null (or 0 when talking about float or int) would
 * be undesirable.
 *
 * @author Ivan Skodje on 23/09/2017
 */
public class Episode
{
	/**
	 * The Episode's TVMaze ID.
	 * IDs range 0 and up.
	 */
	private int id = -1;

	/**
	 * Direct URL to the Episode on TVMaze.com.
	 */
	private String url = "";

	/**
	 * Episode name.
	 */
	private String name = "";

	/**
	 * Season number.
	 * <p>
	 * Seasons range 1 and up.
	 * Until set, it will be by default 0.
	 */
	private int season = 0;

	/**
	 * Episode number.
	 * <p>
	 * Seasons range 1 and up.
	 * Until set, it will be by default 0.
	 */
	private int number = 0;

	/**
	 * The date the episode aired.
	 */
	private LocalDate airDate = null;

	/**
	 * The time the episode aired.
	 */
	private LocalTime airTime = null;

	/**
	 * The date and time the episode aired.
	 * TODO: Change to LocalDateTime.
	 */
	private Date airStamp = null;

	/**
	 * The length of the episode in minutes.
	 * <p>
	 * Runtime vary, usually ranged 20 and up.
	 */
	private int runtime = -1;

	/**
	 * Contains the URL addresses to the medium and original
	 * episode images.
	 */
	private Images images = null;

	/**
	 * The Episode summary is a small description of the
	 * episode with HTML formatting.
	 */
	private String summary = "";

	/**
	 * The show this episode belongs in.
	 */
	private Show show = null;

	/**
	 * Links may contain API URLs to the episode, as well to
	 * a previous- and next episode.
	 */
	private Links links = null;


	/**
	 * Returns the Episode's TVMaze ID,
	 * or -1 if none has been set.
	 *
	 * @return Episode's TVMaze ID.
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Sets the Episode's TVMaze ID,
	 * if it is not null.
	 *
	 * @param id Episode's TVMaze ID.
	 */
	public void setId(Integer id)
	{
		if (id != null)
		{
			this.id = id;
		}
	}

	/**
	 * Returns a URL directly to the Episode on TVMaze.com,
	 * or an empty string if none have been set.
	 *
	 * @return URL to the Episode.
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * Sets the TVMaze URL to the episode,
	 * if it is not null.
	 *
	 * @param url URL to the Episode.
	 */
	public void setUrl(String url)
	{
		if (url != null)
		{
			this.url = url;
		}
	}

	/**
	 * Returns the episode name,
	 * or an empty string if none have been set.
	 *
	 * @return Episode name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name of the episode,
	 * if it is not null.
	 *
	 * @param name Episode name.
	 */
	public void setName(String name)
	{
		if (name != null)
		{
			this.name = name;
		}
	}

	/**
	 * Returns the season number,
	 * or 0 if none has been set.
	 *
	 * @return Season number.
	 */
	public int getSeason()
	{
		return season;
	}

	/**
	 * Sets the season number,
	 * if it is not null.
	 *
	 * @param season Season number.
	 */
	public void setSeason(Integer season)
	{
		if (season != null)
		{
			this.season = season;
		}
	}

	/**
	 * Returns the episode number,
	 * or 0 if none has been set.
	 *
	 * @return Episode number.
	 */
	public int getNumber()
	{
		return number;
	}

	/**
	 * Sets the episode number,
	 * if it is not null.
	 *
	 * @param number Episode number.
	 */
	public void setNumber(Integer number)
	{
		if (number != null)
		{
			this.number = number;
		}
	}

	/**
	 * Returns the air date of the episode,
	 * or null if none has been set.
	 *
	 * @return The episode's air date.
	 */
	public LocalDate getAirDate()
	{
		return airDate;
	}

	/**
	 * Sets the episode's air date,
	 * if it is not null.
	 *
	 * @param airDate The episode's air date.
	 */
	public void setAirDate(LocalDate airDate)
	{
		if (airDate != null)
		{
			this.airDate = airDate;
		}
	}

	/**
	 * Returns the air time of the episode,
	 * or null if none has been set.
	 *
	 * @return The episode's air time.
	 */
	public LocalTime getAirTime()
	{
		return airTime;
	}

	/**
	 * Sets the episode's air time,
	 * if it is not null.
	 *
	 * @param airTime The episode's air time.
	 */
	public void setAirTime(LocalTime airTime)
	{
		if (airTime != null)
		{
			this.airTime = airTime;
		}
	}

	/**
	 * Returns the air stamp of the episode, which includes
	 * both a date and time.
	 * It returns null if none have been set.
	 *
	 * @return The episode's air stamp.
	 */
	public Date getAirStamp()
	{
		return airStamp;
	}

	/**
	 * Sets the episode's air stamp, which includes
	 * both the date and time,
	 * if it is not null.
	 *
	 * @param airStamp The episode's air stamp.
	 */
	public void setAirStamp(Date airStamp)
	{
		if (airStamp != null)
		{
			this.airStamp = airStamp;
		}
	}

	/**
	 * Returns the runtimes of the episodes,
	 * which is the length in minutes.
	 * <p>
	 * Returns -1 if none have been set.
	 *
	 * @return The episode's runtime.
	 */
	public int getRuntime()
	{
		return runtime;
	}

	/**
	 * Sets the episode's runtime,
	 * if it is not null.
	 *
	 * @param runtime The episode's runtime.
	 */
	public void setRuntime(Integer runtime)
	{
		if (runtime != null)
		{
			this.runtime = runtime;
		}
	}

	/**
	 * Returns the images associated with this episode,
	 * or null if none have been set.
	 *
	 * @return The episode's associated {@link Images}.
	 */
	public Images getImages()
	{
		return images;
	}

	/**
	 * Sets the episode's associated images,
	 * if it is not null.
	 *
	 * @param images The episode's associated {@link Images}.
	 */
	public void setImages(Images images)
	{
		if (images != null)
		{
			this.images = images;
		}
	}

	/**
	 * Returns the episode's summary with the received in HTML format,
	 * or an empty string if none have been set.
	 *
	 * @return Episode summary.
	 */
	public String getSummary()
	{
		return summary;
	}

	/**
	 * Sets the episode's summary,
	 * if it is not null.
	 *
	 * @param summary Episode summary.
	 */
	public void setSummary(String summary)
	{
		if (summary != null)
		{
			this.summary = summary;
		}
	}

	/**
	 * Returns the Show this episode runs on,
	 * or null of none have been set.
	 *
	 * @return This episode's {@link Show}.
	 */
	public Show getShow()
	{
		return show;
	}

	/**
	 * Sets the Show this episode runs on,
	 * if it is not null.
	 *
	 * @param show This episode's {@link Show}.
	 */
	public void setShow(Show show)
	{
		if (show != null)
		{
			this.show = show;
		}
	}

	/**
	 * Returns the Links associated with this episode,
	 * or null if none have been set.
	 *
	 * @return {@link Links}.
	 */
	public Links getLinks()
	{
		return links;
	}

	/**
	 * Sets the Links associated with this episode,
	 * if it is not null.
	 *
	 * @param links {@link Links}.
	 */
	public void setLinks(Links links)
	{
		if (links != null)
		{
			this.links = links;
		}
	}

	/**
	 * Returns the episode season, episode and name.
	 * <p>
	 * Formatted as:
	 * "S[season]E[number]: [name]"
	 *
	 * @return A description of the episode.
	 */
	@Override
	public String toString()
	{
		return "S" + String.format("%02d", getSeason()) + "E" + String.format("%02d", getNumber()) + ": " + getName();
	}
}
