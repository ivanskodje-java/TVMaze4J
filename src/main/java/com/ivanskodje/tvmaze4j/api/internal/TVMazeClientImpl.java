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

import com.ivanskodje.tvmaze4j.api.ITVMazeClient;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.ResultObject;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.ShowObject;
import com.ivanskodje.tvmaze4j.model.IShow;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Ivan Skodje on 19/09/2017
 */
public class TVMazeClientImpl implements ITVMazeClient
{

	/**
	 * Used to make HTTP requests with TVMaze
	 */
	public final Requests REQUESTS;

	/**
	 * Using a default HttpClient if none has been specified.
	 */
	public TVMazeClientImpl()
	{
		REQUESTS = new Requests(this);
	}

	@Override
	public List<IShow> showSearch(String query)
	{
		query = encodeURL(query);

		List<IShow> shows = new CopyOnWriteArrayList<>();
		ResultObject[] resultObjects = REQUESTS.GET.makeRequest(String.format(TVMazeEndpoints.SHOW_SEARCH, query), ResultObject[].class);
		Arrays.stream(resultObjects).map(TVMazeUtilities::getShowFromGSON).forEach(shows::add);


		// Arrays.stream(showObjects).map(TVMazeUtilities::getShowFromGSON).forEach(shows::add);
		return shows;
	}

	@Override
	public IShow showSingleSearch(String query)
	{
		return showSingleSearch(query, false);
	}

	@Override
	public IShow showSingleSearch(String query, boolean getEpisodes)
	{
		query = encodeURL(query);
		String formattedUrl = getEpisodes ? TVMazeEndpoints.SHOW_SINGLE_SEARCH_WITH_EPISODES : TVMazeEndpoints.SHOW_SINGLE_SEARCH;
		ShowObject showObject = REQUESTS.GET.makeRequest(String.format(formattedUrl, query), ShowObject.class);
		return TVMazeUtilities.getShowFromGSON(showObject);
	}

	/**
	 * Clean the query and set the correct encoding to avoid errors.
	 *
	 * @param query An URL query.
	 * @return An encoded query.
	 */
	private static String encodeURL(String query)
	{
		try
		{
			return URLEncoder.encode(query, "UTF-8");
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
			return "";
		}
	}
}
