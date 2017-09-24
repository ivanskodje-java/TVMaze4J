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

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author Ivan Skodje on 23/09/2017
 */
public class EpisodeImpl
{
	/**
	 * EpisodeImpl ID.
	 *
	 * -1 means that it have not been set.
	 */
	private int id = -1;

	/**
	 * URL directly to the EpisodeImpl on TVMaze.com.
	 */
	private String url = "";

	/**
	 * EpisodeImpl name.
	 */
	private String name = "";

	/**
	 * Season number.
	 *
	 * 0 indicate that it has not been set.
	 */
	private int season = 0;

	/**
	 * EpisodeImpl number.
	 *
	 * 0 indicate that it has not been set.
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
	 */
	private Date airStamp = null;

	/**
	 * The length of each episode in minutes.
	 *
	 * 0 indicate that it has not been set.
	 */
	private int runtime = 0;

	/**
	 * Contains the URL addresses to the medium and original episode imagesImpl.
	 */
	private ImagesImpl imagesImpl = null;

	/**
	 * The EpisodeImpl summary is a small description of the show.
	 */
	private String summary = "";

	/**
	 * LinksImpl may contain API URLs to the episode, as well to a previous- and next episode.
	 */
	private LinksImpl linksImpl = null;

	public EpisodeImpl()
	{
		airStamp = new Date();
		imagesImpl = new ImagesImpl();
		linksImpl = new LinksImpl();
	}

	public int getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		if(id != null)
		{
			this.id = id;
		}
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		if(url != null)
		{
			this.url = url;
		}
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		if(name != null)
		{
			this.name = name;
		}
	}

	public int getSeason()
	{
		return season;
	}

	public void setSeason(Integer season)
	{
		if(season != null)
		{
			this.season = season;
		}
	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(Integer number)
	{
		if(number != null)
		{
			this.number = number;
		}
	}

	public LocalDate getAirDate()
	{
		return airDate;
	}

	public void setAirDate(LocalDate airDate)
	{
		if(airDate != null)
		{
			this.airDate = airDate;
		}
	}

	public LocalTime getAirTime()
	{
		return airTime;
	}

	public void setAirTime(LocalTime airTime)
	{
		if(airTime != null)
		{
			this.airTime = airTime;
		}
	}

	public Date getAirStamp()
	{
		return airStamp;
	}

	public void setAirStamp(Date airStamp)
	{
		if(airStamp != null)
		{
			this.airStamp = airStamp;
		}
	}

	public int getRuntime()
	{
		return runtime;
	}

	public void setRuntime(Integer runtime)
	{
		if(runtime != null)
		{
			this.runtime = runtime;
		}
	}

	public ImagesImpl getImagesImpl()
	{
		return imagesImpl;
	}

	public void setImagesImpl(ImagesImpl imagesImpl)
	{
		if(imagesImpl != null)
		{
			this.imagesImpl = imagesImpl;
		}
	}

	public String getSummary()
	{
		return summary;
	}

	public void setSummary(String summary)
	{
		if(summary != null)
		{
			this.summary = summary;
		}
	}

	public LinksImpl getLinksImpl()
	{
		return linksImpl;
	}

	public void setLinksImpl(LinksImpl linksImpl)
	{
		if(linksImpl != null)
		{
			this.linksImpl = linksImpl;
		}
	}

	@Override
	public String toString()
	{
		return "S" + String.format("%02d", getSeason()) + "E" + String.format("%02d", getNumber()) + ": " + getName();
	}
}
