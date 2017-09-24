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

package com.ivanskodje.tvmaze4j.api.internal.gson.objects;

/**
 * This represents a json LinksImpl object.
 * <p>
 * Contains various links with URLs.
 *
 * @author ivanskodje on 20.09.17
 */
public class LinksObject
{
	public HyperlinkObject self;
	public HyperlinkObject previousepisode;
	public HyperlinkObject nextepisode;

	public class HyperlinkObject
	{
		public String href;
	}
}
