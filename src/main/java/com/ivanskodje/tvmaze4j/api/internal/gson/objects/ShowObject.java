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


import java.util.*;

/**
 * This represents a json Show object.
 *
 * @author Ivan Skodje on 19/09/2017
 */
public class ShowObject
{
	/**
	 * TODO: Comment all variables.
	 */
	public Integer id;
	public String url;
	public String name;
	public String type;
	public String language;
	public List<String> genres;
	public String status;
	public Integer runtime;
	public Date premiered;
	public String officialSite;
	public ScheduleObject schedule;
	public RatingObject rating;
	public Integer weight;
	public NetworkObject network;
	public ExternalsObject externals;
	public Map<String, String> image; // TODO: Create ImageObject.java
	public Integer updated;
	public String summary;
	public LinksObject _links;
	public List<EpisodeObject> episodes;
	public EpisodeObject previousEpisode;
	public EmbeddedObject _embedded;
}
