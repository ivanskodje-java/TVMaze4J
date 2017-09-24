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

import com.google.gson.Gson;
import com.ivanskodje.tvmaze4j.TVMaze4J;
import com.ivanskodje.tvmaze4j.api.internal.gson.objects.*;
import com.ivanskodje.tvmaze4j.model.impl.*;
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
	 * Get ShowImpl from ResultObject.
	 *
	 * @param resultObject
	 * @return
	 */
	public static ShowImpl getShowFromGsonObject(ResultObject resultObject)
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

		ShowImpl showImpl = getShowFromGsonObject(resultObject.show);
		showImpl.setScore(resultObject.score);

		return showImpl;
	}

	/**
	 * Get ShowImpl from ShowObject.
	 *
	 * @param showObject
	 * @return
	 */
	public static ShowImpl getShowFromGsonObject(ShowObject showObject)
	{
		if (showObject == null)
		{
			TVMaze4J.LOGGER.error(LogMarkers.UTIL, "ShowObject was NULL.");
			return null;
		}

		ShowImpl showImpl = new ShowImpl();
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
		showImpl.setScheduleImpl(getScheduleFromGsonObject(showObject.schedule));
		showImpl.setRatingImpl(getRatingFromGsonObject(showObject.rating));
		showImpl.setWeight(showObject.weight);
		showImpl.setNetworkImpl(getNetworkFromGsonObject(showObject.network));
		showImpl.setWebChannelImpl(getWebChannelFromGsonObject(showObject.webChannel));
		showImpl.setExternalsImpl(getExternalFromGsonObject(showObject.externals));
		showImpl.setImagesImpl(getImagesFromGsonObject(showObject.image));
		showImpl.setSummary(showObject.summary);
		showImpl.setUpdated(showObject.updated);
		showImpl.setLinksImpl(getLinksFromGsonObject(showObject._links));
		showImpl.setEmbeddedImpl(getEmbeddedFromGsonObject(showObject._embedded));
		return showImpl;
	}


	public static EpisodeImpl getEpisodeFromGsonObject(EpisodeObject episodeObject)
	{
		if (episodeObject == null)
		{
			TVMaze4J.LOGGER.error(LogMarkers.UTIL, "EpisodeObject was NULL.");
			return null;
		}

		/**
		 * Handle Status Error Messages in EpisodeImpl (if any).
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

		EpisodeImpl episodeImpl = new EpisodeImpl();
		episodeImpl.setId(episodeObject.id);
		episodeImpl.setUrl(episodeObject.url);
		episodeImpl.setName(episodeObject.name);
		episodeImpl.setSeason(episodeObject.season);
		episodeImpl.setNumber(episodeObject.number);

		try
		{
			episodeImpl.setAirDate(LocalDate.parse(episodeObject.airdate));
		}
		catch (DateTimeParseException ex)
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "Was unable to set LocalDate in EpisodeImpl, due to LocalDate Parsing exceptions.\n");
		}
		try
		{
			String timeString = (episodeObject.airtime.length() > 5) ? episodeObject.airtime : episodeObject.airtime + ":00";
			episodeImpl.setAirTime(LocalTime.parse(timeString));
		}
		catch (DateTimeParseException ex)
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "Was unable to set LocalTime in EpisodeImpl, due to LocalTime Parsing exceptions.\n");
		}

		episodeImpl.setAirStamp(episodeObject.airstamp);
		episodeImpl.setRuntime(episodeObject.runtime);
		episodeImpl.setImagesImpl(getImagesFromGsonObject(episodeObject.image));
		episodeImpl.setSummary(episodeObject.summary);
		episodeImpl.setLinksImpl(getLinksFromGsonObject(episodeObject._links));

		return episodeImpl;
	}


	/**
	 * Get EmbeddedImpl from EmbeddedObject.
	 *
	 * @param embeddedObject
	 * @return
	 */
	public static EmbeddedImpl getEmbeddedFromGsonObject(EmbeddedObject embeddedObject)
	{
		if (embeddedObject != null)
		{
			EmbeddedImpl embeddedImpl = new EmbeddedImpl();

			if (embeddedObject.show != null)
			{
				embeddedImpl.setShowImpl(getShowFromGsonObject(embeddedObject.show));
			}

			if (embeddedObject.episodes != null)
			{
				List<EpisodeImpl> episodeImpls = new ArrayList<>();
				List<EpisodeObject> episodeObjectss = embeddedObject.episodes;
				episodeObjectss.stream().forEach(epObj -> episodeImpls.add(getEpisodeFromGsonObject(epObj)));
				embeddedImpl.setEpisodeImpls(episodeImpls);
			}

			return embeddedImpl;


		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "EmbeddedObject was NULL.");
			return null;
		}
	}


	/**
	 * Get LinksImpl from ImagesObject.
	 *
	 * @param linksObject
	 * @return
	 */
	public static LinksImpl getLinksFromGsonObject(LinksObject linksObject)
	{
		if (linksObject != null)
		{
			LinksImpl linksImpl = new LinksImpl();

			if (linksObject.self != null)
			{
				linksImpl.setSelf(linksObject.self.href);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "linksObject.self was NULL.");
			}

			if (linksObject.previousepisode != null)
			{
				linksImpl.setPreviousEpisode(linksObject.previousepisode.href);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "linksObject.previousepisode was NULL.");
			}

			if (linksObject.nextepisode != null)
			{
				linksImpl.setNextEpisode(linksObject.nextepisode.href);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "linksObject.nextepisode was NULL.");
			}

			return linksImpl;
		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "LinksObject was NULL.");
			return null;
		}
	}

	/**
	 * Get ImagesImpl from ImagesObject.
	 *
	 * @param imageObject
	 * @return
	 */
	public static ImagesImpl getImagesFromGsonObject(ImageObject imageObject)
	{
		if (imageObject != null)
		{
			ImagesImpl imagesImpl = new ImagesImpl();

			if (imageObject.medium != null)
			{
				imagesImpl.setMedium(imageObject.medium);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "imageObject.medium was NULL.");
			}

			if (imageObject.original != null)
			{
				imagesImpl.setOriginal(imageObject.original);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "imageObject.original was NULL.");
			}

			return imagesImpl;
		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "ImageObject was NULL.");
			return null;
		}
	}

	/**
	 * Get ExternalsImpl from ExternalsObject.
	 *
	 * @param externalsObject
	 * @return
	 */
	public static ExternalsImpl getExternalFromGsonObject(ExternalsObject externalsObject)
	{
		if (externalsObject != null)
		{
			ExternalsImpl externalsImpl = new ExternalsImpl();

			if (externalsObject.imdb != null)
			{
				externalsImpl.setImdb(externalsObject.imdb);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "externalsObject.imdb was NULL.");
			}

			if (externalsObject.tvrage != null)
			{
				externalsImpl.setTvRage(externalsObject.tvrage);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "externalsObject.tvrage was NULL.");
			}

			if (externalsObject.thetvdb != null)
			{
				externalsImpl.setTheTvDb(externalsObject.thetvdb);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "externalsObject.thetvdb was NULL.");
			}

			return externalsImpl;
		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "ExternalsObject was NULL.");
			return null;
		}
	}

	/**
	 * Get WebChannelImpl from WebChannelObject.
	 *
	 * @param webChannelObject
	 * @return
	 */
	public static WebChannelImpl getWebChannelFromGsonObject(WebChannelObject webChannelObject)
	{
		if (webChannelObject != null)
		{
			WebChannelImpl webChannelImpl = new WebChannelImpl();

			if (webChannelObject.id != null)
			{
				webChannelImpl.setId(webChannelObject.id);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "webChannelObject.id was NULL.");
			}

			if (webChannelObject.name != null)
			{
				webChannelImpl.setName(webChannelObject.name);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "webChannelObject.name was NULL.");
			}

			if (webChannelObject.country != null)
			{
				webChannelImpl.setCountryImpl(getCountryFromGsonObject(webChannelObject.country));
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "webChannelObject.country was NULL.");
			}

			return webChannelImpl;
		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "WebChannelObject was NULL.");
			return null;
		}
	}

	/**
	 * Get NetworkImpl from NetworkObject.
	 *
	 * @param networkObject
	 * @return
	 */
	public static NetworkImpl getNetworkFromGsonObject(NetworkObject networkObject)
	{
		if (networkObject != null)
		{
			NetworkImpl networkImpl = new NetworkImpl();

			if (networkObject.id != null)
			{
				networkImpl.setId(networkObject.id);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "networkObject.id was NULL.");
			}

			if (networkObject.name != null)
			{
				networkImpl.setName(networkObject.name);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "networkObject.name was NULL.");
			}

			if (networkObject.country != null)
			{
				networkImpl.setCountryImpl(getCountryFromGsonObject(networkObject.country));
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "networkObject.country was NULL.");
			}

			return networkImpl;
		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "NetworkObject was NULL.");
			return null;
		}
	}

	/**
	 * Get {@link CountryImpl} from {@link CountryObject}.
	 *
	 * @param ratingObject
	 * @return
	 */
	public static RatingImpl getRatingFromGsonObject(RatingObject ratingObject)
	{
		if (ratingObject != null && ratingObject.average != null)
		{
			RatingImpl ratingImpl = new RatingImpl();
			ratingImpl.setAverage(ratingObject.average);
			return ratingImpl;
		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "RatingObject was NULL.");
			return null;
		}
	}

	/**
	 * Get CountryImpl from CountryObject.
	 *
	 * @param countryObject
	 * @return
	 */
	public static CountryImpl getCountryFromGsonObject(CountryObject countryObject)
	{
		if (countryObject != null)
		{
			CountryImpl countryImpl = new CountryImpl();

			if (countryObject.name != null)
			{
				countryImpl.setName(countryObject.name);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "countryObject.name was NULL.");
			}

			if (countryObject.code != null)
			{
				countryImpl.setCode(countryObject.code);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "countryObject.code was NULL.");
			}

			if (countryObject.timezone != null)
			{
				countryImpl.setTimeZone(countryObject.timezone);
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "countryObject.timezone was NULL.");
			}

			return countryImpl;
		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "CountryObject was NULL.");
			return null;
		}
	}


	/**
	 * Get ScheduleImpl from ScheduleObject.
	 *
	 * @param scheduleObject
	 * @return
	 */
	public static ScheduleImpl getScheduleFromGsonObject(ScheduleObject scheduleObject)
	{
		if (scheduleObject == null)
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "ScheduleObject was NULL.");
			return null;
		}

		ScheduleImpl scheduleImpl = new ScheduleImpl();

		if (scheduleObject.time != null)
		{
			try
			{
				scheduleImpl.setTime(LocalTime.parse(scheduleObject.time));
			}
			catch (DateTimeParseException ex)
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "Was unable to set time in ScheduleImpl, due to DateTime Parsing exception.\n");
			}
		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "scheduleObject.time is NULL.");
		}

		if (scheduleObject.days != null)
		{
			scheduleImpl.setDays(scheduleObject.days);
		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "scheduleObject.days is NULL.");
		}

		return scheduleImpl;
	}


	/**
	 * Clean query and set encoding format.
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
