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
import com.ivanskodje.tvmaze4j.model.IShow;
import org.apache.http.client.HttpClient;
import org.yamj.api.common.http.SimpleHttpClientBuilder;

import java.util.List;

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
		this(new SimpleHttpClientBuilder().build());
	}

	/**
	 * Initializes with a given HttpClient, for handling interaction with TVMaze.
	 *
	 * @param httpClient
	 */
	public TVMazeClientImpl(HttpClient httpClient)
	{
		REQUESTS = new Requests(httpClient);
	}
	public static double getAPIResponseTimeForDay() {
		MetricsResponse response = Requests.GENERAL_REQUESTS.GET.makeRequest(
				String.format(DiscordEndpoints.METRICS, "day"), MetricsResponse.class);

		return response.summary.mean;
	}

	@Override
	public List<IShow> showSearch(String query)
	{
		List<IShow> shows = REQUESTS.GET.makeRequest();
	}

	@Override
	public List<IShow> showSearch(String query, boolean withEpisodes)
	{
		return null;
	}
}
