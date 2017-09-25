/*************************************************************************
 * This file (ClientBuilder.java) is part of TVMaze4J.                   *
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

package com.ivanskodje.tvmaze4j.api;

import com.ivanskodje.tvmaze4j.api.internal.TVMazeClientImpl;

/**
 * Used to configure and build a {@link TVMazeClient} instance.
 *
 * @author Ivan Skodje on 19/09/2017
 */
public class ClientBuilder
{
	/**
	 * Creates a {@link TVMazeClient} with configuration specified by this builder.
	 * <p>
	 * The intention of a builder is to enable polymorphism, by allowing you to
	 * setup all the classes and constructors leading up to the point.
	 * <p>
	 * NOTE:
	 * This is added in anticipation for future changes and improvements
	 * to the TVMaze4J wrapper.
	 * <p>
	 * For example, when we enable user interactionto the TVMaze API we may
	 * want to request a password or token to go through the builder,
	 * which in turn sets everything up - including error/exception handling.
	 *
	 * @return An implemented client.
	 */
	public TVMazeClient build()
	{
		final TVMazeClient client = new TVMazeClientImpl();
		return client;
	}
}
