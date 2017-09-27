/*************************************************************************
 * This file (Season.java) is part of TVMaze4J.                          *
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

/**
 * The Season of a Show.
 * This should give you a small overview of the season.
 *
 * @author Ivan Skodje on 26/09/2017
 */
public class Season
{
	/**
	 * The Season's TVMaze ID.
	 * IDs range 0 and up.
	 */
	private int id = -1;

	/**
	 * Direct URL to the Season on TVMaze.com.
	 */
	private String url = "";

	/**
	 * This season's number.
	 * Expected range 1 and up.
	 */
	private int number = -1; // season number

	/**
	 * Season name.
	 * This is used when the Network have given a season a special name.
	 */
	private String name = "";

	/**
	 * The number of episodes in this season.
	 * Expected range 1 and up.
	 */
	private int episodeOrder = -1; // number of episodes

	/**
	 * The date of the seasons's premiere.
	 */
	private LocalDate premiereDate = null;

	/**
	 * The date when the season ended.
	 */
	private LocalDate endDate = null;

	/**
	 * The Network the season is run on.
	 * Ex: "CNN", "Bloomberg TV", "CBS Sports Network".
	 */
	private Network network = null;

	/**
	 * The Web Channel the season is run on.
	 * Ex: "YouTube Red".
	 */
	private WebChannel webChannel = null;

	/**
	 * Contains the URL addresses to the medium and original
	 * Show images.
	 */
	private Images images = null;

	/**
	 * The Season's summary.
	 * Uses HTML formatting.
	 */
	private String summary = "";

	/**
	 * Links contain a self API URL to this season.
	 */
	private Links links = null;

	/**
	 * Returns the Seasons's TVMaze ID,
	 * or -1 if none has been set.
	 *
	 * @return Season's TVMaze ID.
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Sets the Season's TVMaze ID,
	 * if it is not null.
	 *
	 * @param id Season's TVMaze ID.
	 */
	public void setId(Integer id)
	{
		if(id != null)
		{
			this.id = id;
		}
	}

	/**
	 * Returns a URL directly to the Season on TVMaze.com,
	 * or an empty string if none have been set.
	 *
	 * @return URL to the Season.
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * Sets the TVMaze URL to the Season,
	 * if it is not null.
	 *
	 * @param url URL to the Season.
	 */
	public void setUrl(String url)
	{
		if (url != null)
		{
			this.url = url;
		}
	}

	/**
	 * Returns the season number,
	 * or -1 if none have been set.
	 *
	 * @return Season number.
	 */
	public int getNumber()
	{
		return number;
	}

	/**
	 * Sets the Season number,
	 * if it is not null.
	 *
	 * @param number
	 */
	public void setNumber(Integer number)
	{
		if (number != null)
		{
			this.number = number;
		}
	}

	/**
	 * Returns the Season name,
	 * or an empty string if none have been set.
	 *
	 * @return Season name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name of the Season,
	 * if it is not null.
	 *
	 * @param name Season name.
	 */
	public void setName(String name)
	{
		if (name != null)
		{
			this.name = name;
		}
	}

	/**
	 * Returns the number of episodes there is in this season,
	 * or -1 if none have been set.
	 *
	 * @return Season's episode count.
	 */
	public int getEpisodeOrder()
	{
		return episodeOrder;
	}

	/**
	 * Sets the number of episodes there is in this season,
	 * if it is not null.
	 *
	 * @param episodeOrder Season's episode count.
	 */
	public void setEpisodeOrder(Integer episodeOrder)
	{
		if (episodeOrder != null)
		{
			this.episodeOrder = episodeOrder;
		}
	}

	/**
	 * Returns the date of the Season's premiere,
	 * or -1 if none have been set.
	 *
	 * @return Season's premiere date.
	 */
	public LocalDate getPremiereDate()
	{
		return premiereDate;
	}

	/**
	 * Sets the date of the Season's premiere,
	 * if it is not null.
	 *
	 * @param premiereDate Season's premiere date.
	 */
	public void setPremiereDate(LocalDate premiereDate)
	{
		if (premiereDate != null)
		{
			this.premiereDate = premiereDate;
		}
	}

	/**
	 * Returns the date of the Season's finale,
	 * or -1 if none have been set.
	 *
	 * @return Season's end date.
	 */
	public LocalDate getEndDate()
	{
		return endDate;
	}

	/**
	 * Sets the date of the Season's finale,
	 * if it is not null.
	 *
	 * @param endDate Season's end date.
	 */
	public void setEndDate(LocalDate endDate)
	{
		if (endDate != null)
		{
			this.endDate = endDate;
		}
	}

	/**
	 * Returns the Season's Network,
	 * or null if none have been set.
	 *
	 * @return Season's {@link Network}.
	 */
	public Network getNetwork()
	{
		return network;
	}

	/**
	 * Sets the Season's Network,
	 * if it is not null.
	 *
	 * @param network Season's {@link Network}.
	 */
	public void setNetwork(Network network)
	{
		if (network != null)
		{
			this.network = network;
		}
	}

	/**
	 * Returns the Season's Web Channel,
	 * or null if none have been set.
	 *
	 * @return Season's {@link WebChannel}.
	 */
	public WebChannel getWebChannel()
	{
		return webChannel;
	}

	/**
	 * Sets the Season's Web Channel,
	 * if it is not null.
	 *
	 * @param webChannel Season's {@link WebChannel}.
	 */
	public void setWebChannel(WebChannel webChannel)
	{
		if (webChannel != null)
		{
			this.webChannel = webChannel;
		}
	}

	/**
	 * Returns the Season's images,
	 * or null of none have been set.
	 *
	 * @return The Season's {@link Images}.
	 */
	public Images getImages()
	{
		return images;
	}

	/**
	 * Sets the Season's images,
	 * if it is not null.
	 *
	 * @param images The Season's {@link Images}.
	 */
	public void setImages(Images images)
	{
		if (images != null)
		{
			this.images = images;
		}
	}

	/**
	 * Returns the Season's summary,
	 * or an empty string if none have been set.
	 *
	 * @return The Season's summary.
	 */
	public String getSummary()
	{
		return summary;
	}

	/**
	 * Sets the Season's summary,
	 * if it is not null.
	 *
	 * @param summary The Season's summary.
	 */
	public void setSummary(String summary)
	{
		if (summary != null)
		{
			this.summary = summary;
		}
	}

	/**
	 * Returns the Links associated with this Season,
	 * or null if none have been set.
	 *
	 * @return {@link Links}.
	 */
	public Links getLinks()
	{
		return links;
	}

	/**
	 * Sets the Links associated with this Season,
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
}
