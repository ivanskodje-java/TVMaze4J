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

package com.ivanskodje.tvmaze4j.api.internal.gson.objects;

import com.google.gson.annotations.Expose;

import java.util.Map;

/**
 * This represents a json Episode object.
 *
 * @author Ivan Skodje on 20/09/2017
 */
public class EpisodeObject
{
	/**
	 * TODO: Find out if there is any advantage using Integer Vs int.
	 */
	public Integer id;
	public String url;
	public String name;
	public Integer season;
	public Integer number;
	public String airdate;
	public String airtime;
	public Integer runtime;
	public Map<String, String> image; // TODO: Create ImageObject.java
	public String summary;
	public LinksObject _links;

	/**
	 * Serialization is off, as we do not want to store these values in the database.
	 * When we deserialize from a json string, we might as well store the show if it
	 * comes with it.
	 */
	@Expose(serialize = false, deserialize = true)
	private ShowObject show;
}
