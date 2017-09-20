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

import com.ivanskodje.tvmaze4j.api.internal.TVMazeClientImpl;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

/**
 * We use this to setup HTTP requests to TVMaze.
 *
 * @author Ivan Skodje on 19/09/2017
 */
public class Requests
{
	/**
	 * Used for GET requests.
	 */
	public final Request GET;

	/**
	 * HTTP Client
	 */
	private final HttpClient client;

	/**
	 * We use requests in order to request information from TVMaze.
	 * <p>
	 * TODO: Implement premium account requests (API)
	 */
	public Requests(HttpClient client)
	{
		this.client = client;
		GET = new Request(HttpGet.class);
	}

	/**
	 * Used to access
	 */
	public final class Request
	{
		/**
		 * Class containing request type.
		 */
		final Class<? extends HttpUriRequest> requestClass;

		/**
		 * We take in a generic class that extends HttpUriRequests in order to
		 * handle different types of requests.
		 *
		 * @param clazz Any class that extends HttpUriRequest
		 */
		private Request(Class<? extends HttpUriRequest> clazz)
		{
			this.requestClass = clazz;
		}
	}
}
