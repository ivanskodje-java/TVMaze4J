/*************************************************************************
 * This file (SeasonObject.java) is part of TVMaze4J.                    *
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

import java.util.Date;

/**
 * This represents a json Season object.
 *
 * @author Ivan Skodje on 26/09/2017
 */
public class SeasonObject
{
	private Integer id;
	private String url;
	private Integer number;
	private String name;
	private Integer episodeOrder;
	private Date premiereDate;
	private Date endDate;
	private @Getter NetworkObject network;
	private @Getter WebChannelObject webChannel;
	private @Getter ImageObject image;
	private String summary;
	private @Getter LinksObject _links;

	public Integer getId()
	{
		return TVMazeError.getInteger(id);
	}

	public String getUrl()
	{
		return TVMazeError.getString(url);
	}

	public Integer getNumber()
	{
		return TVMazeError.getInteger(number);
	}

	public String getName()
	{
		return TVMazeError.getString(name);
	}

	public Integer getEpisodeOrder()
	{
		return TVMazeError.getInteger(episodeOrder);
	}

	public Date getPremiereDate()
	{
		return premiereDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public String getSummary()
	{
		return TVMazeError.getString(summary);
	}

}
