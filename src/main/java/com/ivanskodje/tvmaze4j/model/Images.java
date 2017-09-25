/*************************************************************************
 * This file (Images.java) is part of TVMaze4J.                          *
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
 * Image URLs for Show or Episode images.
 * <p>
 * Shows may contains vertical images, while Episodes
 * may contain horizontal images.
 *
 * @author Ivan Skodje on 23/09/2017
 */
public class Images
{
	/**
	 * Medium sized image URL.
	 * For Shows the image is vertical.
	 * For Episodes the image is horizontal.
	 */
	private String medium = "";

	/**
	 * Original sized image URL.
	 * For Shows the image is vertical.
	 * For Episodes the image is horizontal.
	 */
	private String original = "";

	/**
	 * Returns the medium sized image URL,
	 * or an empty string if none have been set.
	 *
	 * @return Medium sized image url.
	 */
	public String getMedium()
	{
		return medium;
	}

	/**
	 * Sets the medium sized image URL,
	 * if it is not null.
	 *
	 * @param medium Medium sized image url.
	 */
	public void setMedium(String medium)
	{
		this.medium = medium;
	}

	/**
	 * Returns the original sized image URL,
	 * or an empty string if none have been set.
	 *
	 * @return Original sized image url.
	 */
	public String getOriginal()
	{
		return original;
	}

	/**
	 * Sets the original sized image URL,
	 * if it is not null.
	 *
	 * @param original Original sized image url.
	 */
	public void setOriginal(String original)
	{
		this.original = original;
	}

	/**
	 * Returns the image URLs.
	 * <p>
	 * Formatted as:
	 * "Medium: [medium], Original: [original]"
	 *
	 * @return A description of images.
	 */
	@Override
	public String toString()
	{
		return "Medium: " + getMedium() + ", Original: " + getOriginal();
	}
}
