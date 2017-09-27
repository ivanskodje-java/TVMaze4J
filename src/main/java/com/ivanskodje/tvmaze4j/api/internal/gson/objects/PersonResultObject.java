/*************************************************************************
 * This file (PersonResultObject.java) is part of TVMaze4J.              *
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

/**
 * This represents a json Result object.
 *
 * @author Ivan Skodje on 27/09/2017
 */
public class PersonResultObject
{
	/**
	 * Search relevance score.
	 * This score represent the relevance of your search.
	 * A high value indicate a good match to your search result.
	 * <p>
	 * Range is expected to be between 0 and 40.
	 */
	public Float score;

	/**
	 * The Person object.
	 */
	public PersonObject person;
}
