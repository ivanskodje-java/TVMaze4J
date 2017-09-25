/*************************************************************************
 * This file (TVMazeClientImpl.java) is part of TVMaze4J.                *
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

package com.ivanskodje.tvmaze4j.api.internal;

import com.ivanskodje.tvmaze4j.api.TVMazeClient;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.EpisodeObject;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.ResultObject;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.ShowObject;
import com.ivanskodje.tvmaze4j.model.Episode;
import com.ivanskodje.tvmaze4j.model.Show;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Ivan Skodje on 19/09/2017
 */
public class TVMazeClientImpl implements TVMazeClient
{

	/**
	 * Used to make HTTP requests with TVMaze
	 */
	public final Requests REQUESTS;

	public TVMazeClientImpl()
	{
		REQUESTS = new Requests(this);
	}

	@Override
	public List<Show> showSearch(String query)
	{
		return showSearch(query, false);
	}

	@Override
	public List<Show> showSearch(String query, boolean fetchEpisodes)
	{
		return showSearch(query, fetchEpisodes, false);
	}

	@Override
	public List<Show> showSearch(String query, boolean fetchEpisodes, boolean fetchSpecials)
	{
		query = TVMazeUtilities.encodeURL(query);

		List<Show> showImpls = new CopyOnWriteArrayList<>();
		ResultObject[] resultObjects = REQUESTS.GET.makeRequest(String.format(TVMazeEndpoints.SHOW_SEARCH, query), ResultObject[].class);
		if (resultObjects != null)
		{
			Arrays.stream(resultObjects).map(TVMazeUtilities::getShowFromGsonObject).forEach(show ->
			{
				if (fetchEpisodes)
				{
					show.setEpisodes(showEpisodeList(show.getId()));
				}
				showImpls.add(show);
			});
		}

		return showImpls;
	}

	@Override
	public Show showSingleSearch(String query)
	{
		return showSingleSearch(query, false);
	}

	@Override
	public Show showSingleSearch(String query, boolean fetchEpisodes)
	{
		query = TVMazeUtilities.encodeURL(query);
		String formattedUrl = fetchEpisodes ? TVMazeEndpoints.SHOW_SINGLE_SEARCH_WITH_EPISODES : TVMazeEndpoints.SHOW_SINGLE_SEARCH;
		ShowObject showObject = REQUESTS.GET.makeRequest(String.format(formattedUrl, query), ShowObject.class);
		if (showObject == null)
		{
			return null;
		}
		return TVMazeUtilities.getShowFromGsonObject(showObject);
	}

	@Override
	public List<Episode> showEpisodeList(int id)
	{
		return showEpisodeList(id, false);
	}

	@Override
	public List<Episode> showEpisodeList(int id, boolean fetchSpecials)
	{
		List<Episode> episodes = new CopyOnWriteArrayList<>();
		String apiUrl = (fetchSpecials) ? TVMazeEndpoints.EPISODE_LIST_WITH_SPECIALS : TVMazeEndpoints.EPISODE_LIST;
		EpisodeObject[] episodeObjects = REQUESTS.GET.makeRequest(String.format(apiUrl, id), EpisodeObject[].class);
		if (episodeObjects != null)
		{
			Arrays.stream(episodeObjects).map(TVMazeUtilities::getEpisodeFromGsonObject).forEach(episodes::add);
		}
		return episodes;
	}

	@Override
	public Episode episodeByNumber(int showId, int season, int number)
	{
		EpisodeObject episodeObject = REQUESTS.GET.makeRequest(String.format(TVMazeEndpoints.EPISODE_BY_NUMBER, showId, season, number), EpisodeObject.class);
		if (episodeObject == null)
		{
			return null;
		}
		return TVMazeUtilities.getEpisodeFromGsonObject(episodeObject);
	}

	@Override
	public List<Episode> episodesByDate(int showId, LocalDate date)
	{
		List<Episode> episodes = new CopyOnWriteArrayList<>();
		EpisodeObject[] episodeObjects = REQUESTS.GET.makeRequest(String.format(TVMazeEndpoints.EPISODES_BY_DATE, showId, date), EpisodeObject[].class);
		if (episodeObjects != null)
		{
			Arrays.stream(episodeObjects).map(TVMazeUtilities::getEpisodeFromGsonObject).forEach(episodes::add);
		}
		return episodes;
	}

	@Override
	public Show showLookUp(int id)
	{
		ShowObject showObject = REQUESTS.GET.makeRequest(String.format(TVMazeEndpoints.SHOW_LOOKUP_TVMAZE, id), ShowObject.class);
		if (showObject == null)
		{
			return null;
		}
		return TVMazeUtilities.getShowFromGsonObject(showObject);
	}

	@Override
	public Show showLookUpFromTvRage(int id)
	{
		ShowObject showObject = REQUESTS.GET.makeRequest(String.format(TVMazeEndpoints.SHOW_LOOKUP_TVRAGE, id), ShowObject.class);
		return TVMazeUtilities.getShowFromGsonObject(showObject);
	}


	@Override
	public Show showLookUpFromTheTvDb(int id)
	{
		ShowObject showObject = REQUESTS.GET.makeRequest(String.format(TVMazeEndpoints.SHOW_LOOKUP_THETVDB, id), ShowObject.class);
		return TVMazeUtilities.getShowFromGsonObject(showObject);
	}

	@Override
	public Show showLookUpFromImdb(String id)
	{
		ShowObject showObject = REQUESTS.GET.makeRequest(String.format(TVMazeEndpoints.SHOW_LOOKUP_IMDB, id), ShowObject.class);
		return TVMazeUtilities.getShowFromGsonObject(showObject);
	}
}
