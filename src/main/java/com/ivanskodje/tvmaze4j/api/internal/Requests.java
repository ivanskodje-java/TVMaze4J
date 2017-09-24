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

import com.ivanskodje.tvmaze4j.TVMaze4J;
import com.ivanskodje.tvmaze4j.api.TVMazeClient;
import com.ivanskodje.tvmaze4j.util.LogMarkers;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.yamj.api.common.http.DigestedResponse;
import org.yamj.api.common.http.DigestedResponseReader;

import java.io.IOException;
import java.nio.charset.Charset;

import static com.ivanskodje.tvmaze4j.TVMaze4J.LOGGER;

/**
 * We use this to setup HTTP requests to TVMaze.
 *
 * @author Ivan Skodje on 19/09/2017
 */
public class Requests
{

	/**
	 * TODO: This might be used in future implementations.
	 */
	private final TVMazeClient client;

	/**
	 * User Agent which is used to identify us as we interact.
	 */
	public final String USER_AGENT = String.format("%s (%s): %s", TVMaze4J.NAME, TVMaze4J.VERSION, TVMaze4J.DESCRIPTION);

	/**
	 * Used for GET requests.
	 */
	public final GetRequest GET;


	/**
	 * We use the requests in order to request information from TVMaze.
	 * <p>
	 * TODO-MAYBE: Implement premium account APIs end points & requests
	 */
	public Requests(TVMazeClient client)
	{
		this.client = client;
		GET = new GetRequest();
	}

	/**
	 * Used to make HTTP GET requests.
	 */
	public final class GetRequest implements Request
	{
		/**
		 * HTTP Client; for which the requests are made with.
		 */
		private final CloseableHttpClient httpClient = HttpClients.custom().setUserAgent(USER_AGENT).build();

		/**
		 * Makes a request to TVMaze, using a class that extends HttpUriRequest.
		 *
		 * @param url   API URL for the request.
		 * @param clazz Class used for deserialization of JSON responses.
		 * @param <T>   Type used for deserialization of JSON responses.
		 * @return A deserialized object from the response.
		 */
		@Override
		public <T> T makeRequest(String url, Class<T> clazz)
		{
			System.out.println("-------> " + url);
			try
			{
				HttpUriRequest httpRequest = new HttpGet(url);
				DigestedResponse response = DigestedResponseReader.requestContent(httpClient, (HttpGet) httpRequest, Charset.forName("UTF-8"));

				switch (response.getStatusCode())
				{
					case 404:
						TVMaze4J.LOGGER.error(LogMarkers.API, "Error Code 404: " + response.getContent());
						return null;
				}
				return TVMazeUtilities.GSON.fromJson(response.getContent(), clazz);
			}
			catch (IOException ex)
			{
				LOGGER.error(LogMarkers.API, "IO Exception.\n" + ex.getMessage());
			}

			return null;
		}
	}

	/**
	 * Request Interface.
	 */
	public interface Request
	{
		<T> T makeRequest(String url, Class<T> clazz);
	}
}
