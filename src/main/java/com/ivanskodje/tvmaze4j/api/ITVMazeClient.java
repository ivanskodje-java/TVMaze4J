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

package com.ivanskodje.tvmaze4j.api;

import com.ivanskodje.tvmaze4j.model.IShow;

import java.util.List;

/**
 * This is a client that is used to simplify interaction with the TVMaze API.
 * The main way of interacting with the TVMaze API.
 *
 * @author Ivan Skodje on 19/09/2017
 */
public interface ITVMazeClient
{
	/**
	 * Gets a list of shows matching the query.
	 * <p>
	 * This is the equivalent of <code>showSearch(query, false)</code>
	 *
	 * @param query Search query.
	 * @return A list of Shows matching the query.
	 */
	List<IShow> showSearch(String query);

	/**
	 * Gets a list of shows matching the query.
	 * <p>
	 * This is the equivalent of <code>showSearch(query, false)</code>
	 *
	 * @param query Search query.
	 * @return A list of Shows matching the query.
	 */
	IShow showSingleSearch(String query);

	/**
	 * Gets a list of shows matching the query.
	 *
	 * @param query        Search query.
	 * @param withEpisodes Whether or not you want episodes included with the shows.
	 * @return A list of Shows matching the query.
	 */
	IShow showSingleSearch(String query, boolean withEpisodes);
}
