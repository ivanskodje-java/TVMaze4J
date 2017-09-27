/*************************************************************************
 * This file (Person.java) is part of TVMaze4J.                          *
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

package com.ivanskodje.tvmaze4j.model;

/**
 * A Person.
 *
 * @author Ivan Skodje on 27/09/2017
 */
public class Person
{
	/**
	 * The Person's TVMaze ID.
	 * IDs range 0 and up.
	 */
	private int id = -1;

	/**
	 * Direct URL to the Person on TVMaze.com.
	 */
	private String url = "";

	/**
	 * Person name.
	 */
	private String name = "";

	/**
	 * Contains the URL addresses to the medium and original
	 * pictures of the person.
	 */
	private Images images = null;

	/**
	 * Links may contain API URLs to the Person.
	 * All have an API url to the person.
	 */
	private Links links = null;

	/**
	 * Returns the Person's TVMaze ID,
	 * or -1 if none has been set.
	 *
	 * @return Person's TVMaze ID.
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Sets the Person's TVMaze ID,
	 * if it is not null.
	 *
	 * @param id Person's TVMaze ID.
	 */
	public void setId(Integer id)
	{
		if (id != null)
		{
			this.id = id;
		}
	}

	/**
	 * Returns a URL directly to the Person on TVMaze.com,
	 * or an empty string if none have been set.
	 *
	 * @return URL to the Person.
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * Sets the TVMaze URL to the Person,
	 * if it is not null.
	 *
	 * @param url URL to the Person.
	 */
	public void setUrl(String url)
	{
		if (url != null)
		{
			this.url = url;
		}
	}

	/**
	 * Returns the Person name,
	 * or an empty string if none have been set.
	 *
	 * @return Person name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name of the Person,
	 * if it is not null.
	 *
	 * @param name Person name.
	 */
	public void setName(String name)
	{
		if (name != null)
		{
			this.name = name;
		}
	}

	/**
	 * Returns the Person's images,
	 * or null of none have been set.
	 *
	 * @return The Person's {@link Images}.
	 */
	public Images getImages()
	{
		return images;
	}

	/**
	 * Sets the Person's images,
	 * if it is not null.
	 *
	 * @param images The Person's {@link Images}.
	 */
	public void setImages(Images images)
	{
		if (images != null)
		{
			this.images = images;
		}
	}

	/**
	 * Returns the Links associated with this Person,
	 * or null if none have been set.
	 *
	 * @return {@link Links}.
	 */
	public Links getLinks()
	{
		return links;
	}

	/**
	 * Sets the Links associated with this Person,
	 * if it is not null.
	 *
	 * @param links {@link Links}.
	 */
	public void setLinks(Links links)
	{
		if (links != null)
		{
			this.links = links;
		}
	}

	/**
	 * Returns the person name.
	 * <p>
	 * Formatted as:
	 * "[name]"
	 *
	 * @return A description of the person.
	 */
	@Override
	public String toString()
	{
		return getName();
	}
}
