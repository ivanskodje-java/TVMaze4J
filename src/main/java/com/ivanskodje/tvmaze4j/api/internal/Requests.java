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
import com.ivanskodje.tvmaze4j.util.LogMarkers;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.yamj.api.common.http.DigestedResponse;
import org.yamj.api.common.http.DigestedResponseReader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
	 * User Agent which is used to identify us as we interact.
	 */
	public final String USER_AGENT = String.format("%s (%s): %s", TVMaze4J.NAME, TVMaze4J.VERSION, TVMaze4J.DESCRIPTION);

	/**
	 * Used for GET requests.
	 */
	public final HttpRequest GET;

	/**
	 * Used for POST requests.
	 */
	// public final HttpRequest POST;


	/**
	 * We use requests in order to request information from TVMaze.
	 * <p>
	 * The structure of using a GET variable to access certain requests,
	 * will allow us to expand on this with POST, DELETE, and other types of
	 * requests in the future - if ever needed.
	 * <p>
	 * TODO?: Implement premium account APIs
	 */
	public Requests(TVMazeClientImpl client)
	{
		GET = new HttpRequest(HttpGet.class, client);
		// POST = new HttpRequest(HttpPost.class, client);
	}

	/**
	 * Used to access HTTP requests, depending on Class that extends HttpUriRequest.
	 */
	public final class HttpRequest
	{
		/**
		 * TODO: Do we need this?
		 * Client reference that may be used for some requests.
		 */
		private final TVMazeClientImpl client;

		/**
		 * HTTP Client; for which the requests are made with.
		 */
		private final CloseableHttpClient HTTP_CLIENT = HttpClients.custom().setUserAgent(USER_AGENT).build();

		/**
		 * Class of the method used for making requests.
		 */
		final Class<? extends HttpUriRequest> requestClass;

		/**
		 * Used to access HTTP requests, depending on Class that extends HttpUriRequest.
		 *
		 * @param clazz  The class that determines what kind of requests we are going to make.
		 * @param client The client that own the requests.
		 */
		private HttpRequest(Class<? extends HttpUriRequest> clazz, TVMazeClientImpl client)
		{
			this.requestClass = clazz;
			this.client = client;
		}

		/**
		 * Makes a request to TVMaze, using a class that extends HttpUriRequest.
		 *
		 * @param url   API URL for the request.
		 * @param clazz Class used for deserialization of JSON responses.
		 * @param <T>   Type used for deserialization of JSON responses.
		 * @return A deserialized object from the response.
		 */
		public <T> T makeRequest(String url, Class<T> clazz)
		{
			try
			{
				HttpUriRequest httpRequest = this.requestClass.getConstructor(String.class).newInstance(url);
				httpRequest.addHeader("User-Agent", USER_AGENT);
				httpRequest.addHeader("Content-Type", "application/json; charset=utf-8");
				DigestedResponse response = null;

				/**
				 * HttpGet response
				 */
				if (httpRequest instanceof HttpGet)
				{
					response = DigestedResponseReader.requestContent(HTTP_CLIENT, (HttpGet) httpRequest, Charset.forName("UTF-8"));
				}

				return TVMazeUtilities.GSON.fromJson(response.getContent(), clazz);
			}
			catch (IOException ex)
			{
				LOGGER.error(LogMarkers.API, "IO Exception.\n" + ex.getMessage());
			}
			catch (IllegalAccessException ex)
			{
				LOGGER.error(LogMarkers.API, "Illegal Access.\n" + ex.getMessage());
			}
			catch (InstantiationException ex)
			{
				LOGGER.error(LogMarkers.API, "Was unable to instantiate with " + url + ".\n" + ex.getMessage());
			}
			catch (NoSuchMethodException ex)
			{
				LOGGER.error(LogMarkers.API, "No such method exists for " + clazz.getSimpleName() + ".\n" + ex.getMessage());
			}
			catch (InvocationTargetException ex)
			{
				LOGGER.error(LogMarkers.API, "Invocation target exception.\n" + ex.getMessage());
			}

			return null;
		}
	}
}
