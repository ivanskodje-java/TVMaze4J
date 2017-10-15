/*************************************************************************
 * This file (ShowObject.java) is part of TVMaze4J.                      *
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
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This represents a json Show object.
 *
 * @author Ivan Skodje on 19/09/2017
 */
public class ShowObject
{
	private Integer id;
	private String url;
	private String name;
	private String type;
	private String language;
	private List<String> genres;
	private String status;
	private Integer runtime;
	private Date premiered;
	private String officialSite;
	private @Getter ScheduleObject schedule;
	private @Getter RatingObject rating;
	private Integer weight;
	private @Getter NetworkObject network;
	private @Getter WebChannelObject webChannel;
	private @Getter ExternalsObject externals;
	private @Getter ImageObject image;
	private String summary;
	private Integer updated;
	private @Getter LinksObject _links;
	private @Getter EmbeddedObject _embedded;

	public Integer getId()
	{
		return TVMazeError.getInteger(id);
	}

	public String getUrl()
	{
		return TVMazeError.getString(url);
	}

	public String getName()
	{
		return TVMazeError.getString(name);
	}

	public String getType()
	{
		return TVMazeError.getString(type);
	}

	public String getLanguage()
	{
		return TVMazeError.getString(language);
	}

	public List<String> getGenres()
	{
		return (genres != null) ? genres : new ArrayList<>();
	}

	public String getStatus()
	{
		return TVMazeError.getString(status);
	}

	public Integer getRuntime()
	{
		return TVMazeError.getInteger(runtime);
	}

	public Date getPremiered()
	{
		return premiered;
	}

	public String getOfficialSite()
	{
		return TVMazeError.getString(officialSite);
	}

	public Integer getWeight()
	{
		return TVMazeError.getInteger(weight);
	}

	public String getSummary()
	{
		return TVMazeError.getString(summary);
	}

	public Integer getUpdated()
	{
		return TVMazeError.getInteger(updated);
	}
}
