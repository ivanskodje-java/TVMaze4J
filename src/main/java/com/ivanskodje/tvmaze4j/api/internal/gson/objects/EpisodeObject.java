/*************************************************************************
 * This file (EpisodeObject.java) is part of TVMaze4J.                   *
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

import java.util.Date;

/**
 * This represents a json Episode object.
 *
 * @author Ivan Skodje on 20/09/2017
 */
public class EpisodeObject
{
	public Integer id;
	public String url;
	public String name;
	public Integer season;
	public Integer number;
	public String airdate;
	public String airtime;
	public Date airstamp;
	public Integer runtime;
	public ImageObject image;
	public String summary;
	public LinksObject _links;

	// TODO: Handle potential error statuses and messages differently.
	public Integer status; // Used for error handling
	public String message; // Error message
}
