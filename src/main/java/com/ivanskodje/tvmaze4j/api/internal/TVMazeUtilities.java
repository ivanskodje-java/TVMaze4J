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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
	 * Get Show from ShowResultObject.
	 *
	 * @param showResultObject {@link ShowResultObject} is deserialized from Gson.
	 * @return A {@link Show}.
	 */
	public static Show getShowFromGsonObject(ShowResultObject showResultObject)
	{
		if (showResultObject == null)
		{
			TVMaze4J.LOGGER.error(LogMarkers.UTIL, "ShowResultObject was NULL.");
			return null;
		}

		if (showResultObject.getShow() == null)
		{
			TVMaze4J.LOGGER.error(LogMarkers.UTIL, "showResultObject.showImpl was NULL.");
			return null;
		}

		Show showImpl = getShowFromGsonObject(showResultObject.getShow());
		showImpl.setSearchRelevanceScore(showResultObject.getScore());

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
		showImpl.setId(showObject.getId());
		showImpl.setUrl(showObject.getUrl());
		showImpl.setName(showObject.getName());
		showImpl.setType(showObject.getType());
		showImpl.setLanguage(showObject.getLanguage());
		showImpl.setGenres(showObject.getGenres());
		showImpl.setStatus(showObject.getStatus());
		showImpl.setRuntime(showObject.getRuntime());
		showImpl.setPremiered(showObject.getPremiered());
		showImpl.setOfficialSite(showObject.getOfficialSite());
		showImpl.setSchedule(getScheduleFromGsonObject(showObject.getSchedule()));
		showImpl.setRating(getRatingFromGsonObject(showObject.getRating()));
		showImpl.setWeight(showObject.getWeight());
		showImpl.setNetwork(getNetworkFromGsonObject(showObject.getNetwork()));
		showImpl.setWebChannel(getWebChannelFromGsonObject(showObject.getWebChannel()));
		showImpl.setExternals(getExternalFromGsonObject(showObject.getExternals()));
		showImpl.setImages(getImagesFromGsonObject(showObject.getImage()));
		showImpl.setSummary(showObject.getSummary());
		showImpl.setUpdated(showObject.getUpdated());
		showImpl.setLinks(getLinksFromGsonObject(showObject.get_links()));
		showImpl.setEmbedded(getEmbeddedFromGsonObject(showObject.get_embedded()));
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

		// TODO: Handle errors everywhere... !
		if (episodeObject.getStatus() != null)
		{
			switch (episodeObject.getStatus())
			{
				case 404:
					TVMaze4J.LOGGER.error(LogMarkers.UTIL, episodeObject.getMessage());
					return null;
				default:
					break;
			}
		}

		Episode episode = new Episode();
		episode.setId(episodeObject.getId());
		episode.setUrl(episodeObject.getUrl());
		episode.setName(episodeObject.getName());
		episode.setSeason(episodeObject.getSeason());
		episode.setNumber(episodeObject.getNumber());
		episode.setAirDate(parseToLocalDate(episodeObject.getAirdate()));
		episode.setAirStamp(episodeObject.getAirstamp());
		episode.setRuntime(episodeObject.getRuntime());
		episode.setImages(getImagesFromGsonObject(episodeObject.getImage()));
		episode.setSummary(episodeObject.getSummary());
		episode.setLinks(getLinksFromGsonObject(episodeObject.get_links()));

		try
		{
			String timeString = (episodeObject.getAirtime().length() > 5) ? episodeObject.getAirtime() : episodeObject.getAirtime() + ":00";
			episode.setAirTime(LocalTime.parse(timeString));
		}
		catch (DateTimeParseException ex)
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "Was unable to set LocalTime in Episode, due to LocalTime Parsing exceptions.\n");
		}

		// The person is available when you retrieve episode from Schedule.
		if (episodeObject.getShow() != null)
		{
			episode.setShow(getShowFromGsonObject(episodeObject.getShow()));
		}

		return episode;
	}


	public static Person getPersonFromGsonObject(PersonResultObject personResultObject)
	{
		if (personResultObject == null)
		{
			TVMaze4J.LOGGER.error(LogMarkers.UTIL, "PersonResultObject was NULL.");
			return null;
		}

		if (personResultObject.getPerson() == null)
		{
			TVMaze4J.LOGGER.error(LogMarkers.UTIL, "PersonObject in PersonResultObject was NULL.");
			return null;
		}

		Person person = getPersonFromGsonObject(personResultObject.getPerson());
		person.setSearchRelevanceScore(personResultObject.getScore());
		return person;
	}

	/**
	 * Get Person from PersonObject.
	 *
	 * @param personObject {@link PersonObject} is deserialized from Gson.
	 * @return {@link Person}.
	 */
	public static Person getPersonFromGsonObject(PersonObject personObject)
	{
		if (personObject == null)
		{
			TVMaze4J.LOGGER.error(LogMarkers.UTIL, "PersonObject was NULL.");
			return null;
		}

		Person person = new Person();
		person.setId(personObject.getId());
		person.setUrl(personObject.getUrl());
		person.setName(personObject.getName());
		person.setImages(getImagesFromGsonObject(personObject.getImage()));
		person.setLinks(getLinksFromGsonObject(personObject.get_links()));
		return person;
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

			if (embeddedObject.getShow() != null)
			{
				embedded.setShow(getShowFromGsonObject(embeddedObject.getShow()));
			}

			if (embeddedObject.getEpisodes() != null)
			{
				List<Episode> episodes = new CopyOnWriteArrayList<>();
				List<EpisodeObject> episodeObjects = embeddedObject.getEpisodes();
				episodeObjects.stream().forEach(epObj -> episodes.add(getEpisodeFromGsonObject(epObj)));
				embedded.setEpisodes(episodes);
			}

			if (embeddedObject.getCast() != null)
			{
				List<Cast> castMembers = new CopyOnWriteArrayList<>();
				List<CastObject> castObjects = embeddedObject.getCast();
				castObjects.stream().forEach(castObj -> castMembers.add(getCastFromGsonObject(castObj)));
				embedded.setCastMembers(castMembers);
			}

			return embedded;
		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "EmbeddedObject was NULL.");
			return null;
		}
	}

	public static Cast getCastFromGsonObject(CastObject castObject)
	{
		if (castObject == null)
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "CastObject was NULL.");
			return null;
		}

		Cast cast = new Cast();
		cast.setActor(getPersonFromGsonObject(castObject.getPerson()));
		cast.setCharacter(getPersonFromGsonObject(castObject.getCharacter()));
		return cast;
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

			if (linksObject.getSelf() != null)
			{
				links.setSelf(linksObject.getSelf().getHref());
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "linksObject.self was NULL.");
			}

			if (linksObject.getPreviousepisode() != null)
			{
				links.setPreviousEpisode(linksObject.getPreviousepisode().getHref());
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "linksObject.previousepisode was NULL.");
			}

			if (linksObject.getNextepisode() != null)
			{
				links.setNextEpisode(linksObject.getNextepisode().getHref());
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

			if (imageObject.getMedium() != null)
			{
				images.setMedium(imageObject.getMedium());
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "imageObject.medium was NULL.");
			}

			if (imageObject.getOriginal() != null)
			{
				images.setOriginal(imageObject.getOriginal());
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

			if (externalsObject.getImdb() != null)
			{
				externals.setImdb(externalsObject.getImdb());
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "externalsObject.imdb was NULL.");
			}

			if (externalsObject.getTvrage() != null)
			{
				externals.setTvRage(externalsObject.getTvrage());
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "externalsObject.tvrage was NULL.");
			}

			if (externalsObject.getThetvdb() != null)
			{
				externals.setTheTvDb(externalsObject.getThetvdb());
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

			if (webChannelObject.getId() != null)
			{
				webChannel.setId(webChannelObject.getId());
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "webChannelObject.id was NULL.");
			}

			if (webChannelObject.getName() != null)
			{
				webChannel.setName(webChannelObject.getName());
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "webChannelObject.name was NULL.");
			}

			if (webChannelObject.getCountry() != null)
			{
				webChannel.setCountry(getCountryFromGsonObject(webChannelObject.getCountry()));
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

			if (networkObject.getId() != null)
			{
				network.setId(networkObject.getId());
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "networkObject.id was NULL.");
			}

			if (networkObject.getName() != null)
			{
				network.setName(networkObject.getName());
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "networkObject.name was NULL.");
			}

			if (networkObject.getCountry() != null)
			{
				network.setCountry(getCountryFromGsonObject(networkObject.getCountry()));
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
		if (ratingObject != null && ratingObject.getAverage() != null)
		{
			Rating rating = new Rating();
			rating.setAverage(ratingObject.getAverage());
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

			if (countryObject.getName() != null)
			{
				country.setName(countryObject.getName());
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "countryObject.name was NULL.");
			}

			if (countryObject.getCode() != null)
			{
				country.setCode(countryObject.getCode());
			}
			else
			{
				TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "countryObject.code was NULL.");
			}

			if (countryObject.getTimezone() != null)
			{
				country.setTimeZone(countryObject.getTimezone());
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

		if (scheduleObject.getTime() != null)
		{
			try
			{
				schedule.setTime(LocalTime.parse(scheduleObject.getTime()));
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

		if (scheduleObject.getDays() != null)
		{
			schedule.setDays(scheduleObject.getDays());
		}
		else
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "scheduleObject.days is NULL.");
		}

		return schedule;
	}

	/**
	 * Get Season from SeasonObject.
	 *
	 * @param seasonObject {@link SeasonObject} is deserialized from Gson.
	 * @return A {@link Season}.
	 */
	public static Season getSeasonFromGsonObject(SeasonObject seasonObject)
	{
		if (seasonObject == null)
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "SeasonObject was NULL.");
			return null;
		}

		Season season = new Season();

		season.setId(seasonObject.getId());
		season.setUrl(seasonObject.getUrl());
		season.setNumber(seasonObject.getNumber());
		season.setName(seasonObject.getName());
		season.setEpisodeOrder(seasonObject.getEpisodeOrder());
		season.setNetwork(getNetworkFromGsonObject(seasonObject.getNetwork()));
		season.setWebChannel(getWebChannelFromGsonObject(seasonObject.getWebChannel()));
		season.setImages(getImagesFromGsonObject(seasonObject.getImage()));
		season.setSummary(seasonObject.getSummary());
		season.setLinks(getLinksFromGsonObject(seasonObject.get_links()));
		season.setPremiereDate(parseToLocalDate(seasonObject.getPremiereDate()));
		season.setEndDate(parseToLocalDate(seasonObject.getEndDate()));
		return season;
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

	/**
	 * Used to convert LocalDate to Date without needing to
	 * look for exceptions everywhere it is used.
	 * <p>
	 * TVMaze uses the ISO date format.
	 *
	 * @param date A Date.
	 * @return LocalDate.
	 */
	public static LocalDate parseToLocalDate(Date date)
	{
		LocalDate localDate = null;
		try
		{
			localDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date));
		}
		catch (DateTimeParseException ex)
		{
			TVMaze4J.LOGGER.warn(LogMarkers.UTIL, "Was unable to set LocalDate, due to a LocalDate Parsing exception.\n" +
					"Could not parse '" + date.toString() + "'.");
		}

		return localDate;
	}
}
