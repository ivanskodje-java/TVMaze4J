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

package com.ivanskodje.tvmaze4j.model.impl;

import java.util.List;

/**
 * @author Ivan Skodje on 23/09/2017
 */
public class EmbeddedImpl
{
	private ShowImpl showImpl = null;
	private List<EpisodeImpl> episodeImpls = null;

	public ShowImpl getShowImpl()
	{
		return showImpl;
	}

	public void setShowImpl(ShowImpl showImpl)
	{
		if (showImpl != null)
		{
			this.showImpl = showImpl;
		}
	}

	public List<EpisodeImpl> getEpisodeImpls()
	{
		return episodeImpls;
	}

	public void setEpisodeImpls(List<EpisodeImpl> episodeImpls)
	{
		if (episodeImpls != null)
		{
			this.episodeImpls = episodeImpls;
		}
	}

	@Override
	public String toString()
	{
		String message = "";
		if (getShowImpl() != null)
		{
			message += "" + getShowImpl().getName();

			if (getEpisodeImpls() != null)
			{
				message += " has ";
			}
		}

		if (getEpisodeImpls() != null)
		{
			message += getEpisodeImpls().size() + " episodeImpls";
		}

		return message;
	}
}
