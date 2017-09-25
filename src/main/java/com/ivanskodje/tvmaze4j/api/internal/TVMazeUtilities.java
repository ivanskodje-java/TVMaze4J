/*************************************************************************
 * This file (TVMazeUtilities.java) is part of TVMaze4J.                 *
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

import com.google.gson.Gson;
import com.ivanskodje.tvmaze4j.TVMaze4J;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.*;
import com.ivanskodje.tvmaze4j.model.*;
import com.ivanskodje.tvmaze4j.util.LogMarkers;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * A bunch of various utilities used throughout TVMaze4J.
 *
 * @author ivanskodje on 20.09.17
 */
public class TVMazeUtilities
{
	/**
	 * GSON is used throughout the project in order to
	 * serialize and deserialize json strings received from TVMaze.
	 */
	public static final Gson GSON = new Gson();

	/**
	 * Get Show from ResultObject.
	 *
	 * @param resultObject {@link ResultObject} is deserialized from Gson.
	 * @return A {@link Show}.
	 */
	public static Show getShowFromGsonObject(ResultObject resultObject)
	{
		if (resultObject == null)
		{
			TVMaze4J.LOGGER.error(LogMarkers.UTIL, "ResultObject was NULL.");
			return null;
		}

		if (resultObject.show == null)
		{
			TVMaze4J.LOGGER.error(LogMarkers.UTIL, "resultObject.showImpl was NULL.");
			return null;
		}

		Show showImpl = getShowFromGsonObject(resultObject.show);
		showImpl.setSearchRelevanceScore(resultObject.score);

		return showImpl;
	}

	/**
	 * Get Show from ShowObject.
	 *
	 * @param showObject {@link ShowObject} is deserialized from Gson.
	 * @return A {@link Show}.
	 */
	public static Show getShowFromGsonObject(ShowObject showObject)
	{
		if (showObject == null)
		{
			TVMaze4J.LOGGER.error(LogMarkers.UTIL, "ShowObject was NULL.");
			return null;
		}

		Show showImpl = new Show();
		showImpl.setId(showObject.id);
		showImpl.setUrl(showObject.url);
		showImpl.setName(showObject.name);
		showImpl.setType(showObject.type);
		showImpl.setLanguage(showObject.language);
		showImpl.setGenres(showObject.genres);
		showImpl.setStatus(showObject.status);
		showImpl.setRuntime(showObject.runtime);
		showImpl.setPremiered(showObject.premiered);
		showImpl.setOfficialSite(showObject.officialSite);
		showImpl.setSchedule(getScheduleFromGsonObject(showObject.schedule));
		showImpl.setRating(getRatingFromGsonObject(showObject.rating));
		showImpl.setWeight(showObject.weight);
		showImpl.setNetwork(getNetworkFromGsonObject(showObject.network));
		showImpl.setWebChannel(getWebChannelFromGsonObject(showObject.webChannel));
		showImpl.setExternals(getExternalFromGsonObject(showObject.externals));
		showImpl.setImages(getImagesFromGsonObject(showObject.image));
		showImpl.setSummary(showObject.summary);
		showImpl.setUpdated(showObject.updated);
		showImpl.setLinks(getLinksFromGsonObject(showObject._links));
		showImpl.setEmbedded(getEmbeddedFromGsonObject(showObject._embedded));
		return showImpl;
	}

	/**
	 * Get Episode from EpisodeObject.
	 *
	 * @param episodeObject {@link EpisodeObject} is deserialized from Gson.
	 * @return {@link Episode}.
	 */
	public static Episode getEpisodeFromGsonObject(EpisodeObject episodeObject)
	{
		if (episodeObject == null)
		{
			TVMaze4J.LOGGER.error(LogMarkers.UTIL, "EpisodeObject was NULL.");
			return null;
		}

		/**
		 * Handle Status Error Messages in Episode (if any).
		 */
		if (episodeObject.status != null)
		{
			switch (episodeObject.status)
			{
				case 404:
					TVMaze4J.LOGGER.error(LogMarkers.UTIL, episodeObject.message);
					return null;
				default:
					break;
			}
		}

		Episode episode = new Episode();
		episode.setId(episodeObject.id);
		episode.setUrl(episodeObject.url);
		episode.setName(episodeObject.name);
		episode.setSeason(episodeObject.season);
		episode.setNumber(episodeObject.number);

		try
		{
			episode.setAirDate(LocalDate.parse(episodeObject.airdate));
		}
		catch (DateTimeParseException ex)
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "Was unable to set LocalDate in Episode, due to LocalDate Parsing exceptions.\n");
		}
		try
		{
			String timeString = (episodeObject.airtime.length() > 5) ? episodeObject.airtime : episodeObject.airtime + ":00";
			episode.setAirTime(LocalTime.parse(timeString));
		}
		catch (DateTimeParseException ex)
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "Was unable to set LocalTime in Episode, due to LocalTime Parsing exceptions.\n");
		}

		episode.setAirStamp(episodeObject.airstamp);
		episode.setRuntime(episodeObject.runtime);
		episode.setImages(getImagesFromGsonObject(episodeObject.image));
		episode.setSummary(episodeObject.summary);
		episode.setLinks(getLinksFromGsonObject(episodeObject._links));

		return episode;
	}

	/**
	 * Get Embedded from EmbeddedObject.
	 *
	 * @param embeddedObject {@link Embedded} is deserialized from Gson.
	 * @return {@link Embedded}.
	 */
	public static Embedded getEmbeddedFromGsonObject(EmbeddedObject embeddedObject)
	{
		if (embeddedObject != null)
		{
			Embedded embedded = new Embedded();

			if (embeddedObject.show != null)
			{
				embedded.setShow(getShowFromGsonObject(embeddedObject.show));
			}

			if (embeddedObject.episodes != null)
			{
				List<Episode> episodes = new ArrayList<>();
				List<EpisodeObject> episodeObjectss = embeddedObject.episodes;
				episodeObjectss.stream().forEach(epObj -> episodes.add(getEpisodeFromGsonObject(epObj)));
				embedded.setEpisodes(episodes);
			}

			return embedded;
		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "EmbeddedObject was NULL.");
			return null;
		}
	}

	/**
	 * Get Links from ImagesObject.
	 *
	 * @param linksObject {@link LinksObject} is deserialized from Gson.
	 * @return {@link Links}.
	 */
	public static Links getLinksFromGsonObject(LinksObject linksObject)
	{
		if (linksObject != null)
		{
			Links links = new Links();

			if (linksObject.self != null)
			{
				links.setSelf(linksObject.self.href);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "linksObject.self was NULL.");
			}

			if (linksObject.previousepisode != null)
			{
				links.setPreviousEpisode(linksObject.previousepisode.href);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "linksObject.previousepisode was NULL.");
			}

			if (linksObject.nextepisode != null)
			{
				links.setNextEpisode(linksObject.nextepisode.href);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "linksObject.nextepisode was NULL.");
			}

			return links;
		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "LinksObject was NULL.");
			return null;
		}
	}

	/**
	 * Get Images from ImagesObject.
	 *
	 * @param imageObject {@link ImageObject} is deserialized from Gson.
	 * @return {@link Images}.
	 */
	public static Images getImagesFromGsonObject(ImageObject imageObject)
	{
		if (imageObject != null)
		{
			Images images = new Images();

			if (imageObject.medium != null)
			{
				images.setMedium(imageObject.medium);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "imageObject.medium was NULL.");
			}

			if (imageObject.original != null)
			{
				images.setOriginal(imageObject.original);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "imageObject.original was NULL.");
			}

			return images;
		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "ImageObject was NULL.");
			return null;
		}
	}

	/**
	 * Get Externals from ExternalsObject.
	 *
	 * @param externalsObject {@link ExternalsObject} is deserialized from Gson.
	 * @return {@link Externals}.
	 */
	public static Externals getExternalFromGsonObject(ExternalsObject externalsObject)
	{
		if (externalsObject != null)
		{
			Externals externals = new Externals();

			if (externalsObject.imdb != null)
			{
				externals.setImdb(externalsObject.imdb);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "externalsObject.imdb was NULL.");
			}

			if (externalsObject.tvrage != null)
			{
				externals.setTvRage(externalsObject.tvrage);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "externalsObject.tvrage was NULL.");
			}

			if (externalsObject.thetvdb != null)
			{
				externals.setTheTvDb(externalsObject.thetvdb);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "externalsObject.thetvdb was NULL.");
			}

			return externals;
		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "ExternalsObject was NULL.");
			return null;
		}
	}

	/**
	 * Get WebChannel from WebChannelObject.
	 *
	 * @param webChannelObject {@link WebChannelObject} is deserialized from Gson.
	 * @return A {@link WebChannel}.
	 */
	public static WebChannel getWebChannelFromGsonObject(WebChannelObject webChannelObject)
	{
		if (webChannelObject != null)
		{
			WebChannel webChannel = new WebChannel();

			if (webChannelObject.id != null)
			{
				webChannel.setId(webChannelObject.id);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "webChannelObject.id was NULL.");
			}

			if (webChannelObject.name != null)
			{
				webChannel.setName(webChannelObject.name);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "webChannelObject.name was NULL.");
			}

			if (webChannelObject.country != null)
			{
				webChannel.setCountry(getCountryFromGsonObject(webChannelObject.country));
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "webChannelObject.country was NULL.");
			}

			return webChannel;
		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "WebChannelObject was NULL.");
			return null;
		}
	}

	/**
	 * Get Network from NetworkObject.
	 *
	 * @param networkObject {@link NetworkObject} is deserialized from Gson.
	 * @return A {@link Network}.
	 */
	public static Network getNetworkFromGsonObject(NetworkObject networkObject)
	{
		if (networkObject != null)
		{
			Network network = new Network();

			if (networkObject.id != null)
			{
				network.setId(networkObject.id);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "networkObject.id was NULL.");
			}

			if (networkObject.name != null)
			{
				network.setName(networkObject.name);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "networkObject.name was NULL.");
			}

			if (networkObject.country != null)
			{
				network.setCountry(getCountryFromGsonObject(networkObject.country));
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "networkObject.country was NULL.");
			}

			return network;
		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "NetworkObject was NULL.");
			return null;
		}
	}

	/**
	 * Get {@link Country} from {@link CountryObject}.
	 *
	 * @param ratingObject {@link RatingObject} is deserialized from Gson.
	 * @return A {@link Rating}.
	 */
	public static Rating getRatingFromGsonObject(RatingObject ratingObject)
	{
		if (ratingObject != null && ratingObject.average != null)
		{
			Rating rating = new Rating();
			rating.setAverage(ratingObject.average);
			return rating;
		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "RatingObject was NULL.");
			return null;
		}
	}

	/**
	 * Get Country from CountryObject.
	 *
	 * @param countryObject {@link CountryObject} is deserialized from Gson.
	 * @return A {@link Country}.
	 */
	public static Country getCountryFromGsonObject(CountryObject countryObject)
	{
		if (countryObject != null)
		{
			Country country = new Country();

			if (countryObject.name != null)
			{
				country.setName(countryObject.name);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "countryObject.name was NULL.");
			}

			if (countryObject.code != null)
			{
				country.setCode(countryObject.code);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "countryObject.code was NULL.");
			}

			if (countryObject.timezone != null)
			{
				country.setTimeZone(countryObject.timezone);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "countryObject.timezone was NULL.");
			}

			return country;
		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "CountryObject was NULL.");
			return null;
		}
	}

	/**
	 * Get Schedule from ScheduleObject.
	 *
	 * @param scheduleObject {@link ScheduleObject} is deserialized from Gson.
	 * @return A {@link Schedule}.
	 */
	public static Schedule getScheduleFromGsonObject(ScheduleObject scheduleObject)
	{
		if (scheduleObject == null)
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "ScheduleObject was NULL.");
			return null;
		}

		Schedule schedule = new Schedule();

		if (scheduleObject.time != null)
		{
			try
			{
				schedule.setTime(LocalTime.parse(scheduleObject.time));
			}
			catch (DateTimeParseException ex)
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "Was unable to set time in Schedule, due to DateTime Parsing exception.\n");
			}
		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "scheduleObject.time is NULL.");
		}

		if (scheduleObject.days != null)
		{
			schedule.setDays(scheduleObject.days);
		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "scheduleObject.days is NULL.");
		}

		return schedule;
	}

	/**
	 * Clean query and set encoding format.
	 * Replace spaces with UTF-8 format of space.
	 *
	 * @param query An URL query.
	 * @return An encoded query.
	 */
	public static String encodeURL(String query)
	{
		try
		{
			return URLEncoder.encode(query, "UTF-8");
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
			return "";
		}
	}
}
