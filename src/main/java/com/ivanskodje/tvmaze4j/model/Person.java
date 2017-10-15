/*************************************************************************
 * This file (Person.java) is part of TVMaze4J.                          *
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

import lombok.Data;

/**
 * A Person can be an Actor or Character from a {@link Show}.
 *
 * @author Ivan Skodje on 27/09/2017
 */
public @Data class Person
{
	/**
	 * Search relevance score.
	 * <p>
	 * Score is estimated to range 0 and up to 40.
	 * <p>
	 * When searching with terms that provide multiple results,
	 * the result with the highest search relevance score will
	 * return when searching for a single show.
	 */
	private float searchRelevanceScore;

	/**
	 * The Person's TVMaze ID.
	 * IDs range 0 and up.
	 */
	private int id;

	/**
	 * Direct URL to the Person on TVMaze.com.
	 */
	private String url;

	/**
	 * Person name.
	 */
	private String name;

	/**
	 * Contains the URL addresses to the medium and original
	 * pictures of the person.
	 */
	private Images images;

	/**
	 * Links may contain API URLs to the Person.
	 * All have an API url to the person.
	 */
	private Links links;

	/**
	 * Returns the person name.
	 * <p>
	 * Formatted as:
	 * "[name]"
	 *
	 * @return A description of the person.
	 */
	@Override
	public String toString()
	{
		return getName();
	}
}
