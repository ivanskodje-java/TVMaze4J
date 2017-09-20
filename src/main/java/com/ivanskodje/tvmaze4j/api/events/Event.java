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

package com.ivanskodje.tvmaze4j.api.events;

import com.ivanskodje.tvmaze4j.api.ITVMazeClient;

/**
 * Super-class of events triggered by {@link EventDispatcher}.
 * These are events sent by TVMaze4J.
 *
 * @author Ivan Skodje on 19/09/2017
 */
public abstract class Event
{
	/**
	 * The client the {@link EventDispatcher} is associated with.
	 */
	protected ITVMazeClient client;

	/**
	 * Returns the client associated with the event.
	 * @return
	 */
	public ITVMazeClient getClient()
	{
		return client;
	}
}
