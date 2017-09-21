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

package com.ivanskodje.tvmaze4j.api.internal;

import com.google.gson.Gson;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.ResultObject;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.ShowObject;
import com.ivanskodje.tvmaze4j.model.IShow;
import com.ivanskodje.tvmaze4j.model.impl.Show;

/**
 * A bunch of various utilities used throughout TVMaze4J.
 *
 * @author ivanskodje on 20.09.17
 */
public class TVMazeUtilities
{
	/**
	 * GSON is used throughout the project in order to
	 * serialize and deserialize json strings received from TVMaze.
	 */
	public static final Gson GSON = new Gson();

	public static IShow getShowFromGSON(ResultObject resultObject)
	{
		return new Show(resultObject.show.name);
	}

	public static IShow getShowFromGSON(ShowObject showObject)
	{
		return new Show(showObject.name);
	}
}
