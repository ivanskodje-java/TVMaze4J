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

package com.ivanskodje.tvmaze4j.util;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.Iterator;


/**
 * The log markers for TVMaze4J.
 *
 * @author Ivan Skodje on 19/09/2017
 */
public enum LogMarkers implements Marker
{
	/**
	 * The Main marker.
	 */
	MAIN,

	/**
	 * A Marker for the classes in {@link com.ivanskodje.tvmaze4j.api} package.
	 */
	API(MAIN),

	/**
	 * A Marker for the classes in {@link com.ivanskodje.tvmaze4j.util} package.
	 */
	UTIL(MAIN),

	/**
	 * A Marker for event logging.
	 */
	EVENT(MAIN);

	/**
	 * Our Marker
	 */
	private final Marker marker;

	LogMarkers()
	{
		marker = MarkerFactory.getMarker(this.toString());
	}

	LogMarkers(LogMarkers... markers)
	{
		this(); // Call first constructor
		for(LogMarkers marker : markers)
		{
			marker.add(this);
		}
	}

	@Override
	public String getName()
	{
		return marker.getName();
	}

	@Override
	public void add(Marker marker)
	{
		this.marker.add(marker);
	}

	@Override
	public boolean remove(Marker marker)
	{
		return this.marker.remove(marker);
	}

	@Override
	public boolean hasChildren()
	{
		return marker.hasChildren();
	}

	@Override
	public boolean hasReferences()
	{
		return marker.hasReferences();
	}

	@Override
	public Iterator<Marker> iterator()
	{
		return marker.iterator();
	}

	@Override
	public boolean contains(Marker marker)
	{
		return this.marker.contains(marker);
	}

	@Override
	public boolean contains(String s)
	{
		return marker.contains(s);
	}
}
