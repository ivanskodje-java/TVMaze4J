/*************************************************************************
 * This file (TVMaze4JTest.java) is part of TVMaze4J.                    *
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

package com.ivanskodje.tvmaze4j;

import com.ivanskodje.tvmaze4j.api.ClientBuilder;
import com.ivanskodje.tvmaze4j.api.TVMazeClient;
import com.ivanskodje.tvmaze4j.model.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.time.LocalDate;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class TVMaze4JTest extends TestCase
{
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public TVMaze4JTest(String testName)
	{
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite(TVMaze4JTest.class);
	}


	/**
	 * Test each individual command
	 */
	public void testAllAPIs()
	{
		// Create client
		ClientBuilder builder = new ClientBuilder();
		TVMazeClient client = builder.build();

		// Get the matching show (single) with episodes
		Show showImpl1 = client.showSingleSearch("silicon valley", true);
		System.out.println(showImpl1.getEpisodes());

		// Get show with TVRage ID
		Show showImpl2 = client.showLookUpFromTvRage(24493); // Game of Thrones has TVRage ID 24493
		System.out.println(showImpl2);

		// Get show with TheTVDB ID
		Show showImpl3 = client.showLookUpFromTheTvDb(81189); // Breaking Bad has TheTVDB ID 81189
		System.out.println(showImpl3);

		// Get show with IMDB ID
		Show showImpl4 = client.showLookUpFromImdb("tt0944947"); // Game of Thrones has IMDB ID tt0944947
		System.out.println(showImpl4);

		// Get show with TVMaze
		Show showImpl5 = client.showLookUp(143); // Silicon Valley has TVMaze ID 143
		System.out.println(showImpl5);

		// Get a list of Episodes from ID
		List<Episode> episodes1 = client.showEpisodeList(143); // List of episodes from Silicon Valley (TVmaze ID 143)
		System.out.println(episodes1);

		// Get a specific episode
		Episode episode1 = client.episodeByNumber(143, 1, 4); // showid, season, number
		System.out.println(episode1);

		// Get a list of episodes aired by the show on a specific date.
		List<Episode> episodes2 = client.episodesByDate(1, LocalDate.parse("2013-07-01")); // showid, date (yyyy-mm-dd)
		System.out.println(episodes2);
	}

	/**
	 * Make sure we can retrieve a lot of shows from TVMaze.
	 * <p>
	 * NB: Requires internet connectivity.
	 */
	public void testSearchShows()
	{
		TVMaze4J.LOGGER.info("Attempting to search for showImpls, using the query 'silicon valley'...");
		TVMazeClient client = new ClientBuilder().build();

		List<Show> showImpls = client.showSearch("silicon valley");
		showImpls.stream().forEach(s -> TVMaze4J.LOGGER.info("Search Result: " + s));

		if (showImpls.size() > 0 && showImpls.get(0).getClass().getSimpleName().equals("Show"))
		{
			TVMaze4J.LOGGER.info("Successfully received " + showImpls.size() + " showImpls.");
		}
		else
		{
			fail("Did not receive any search results.");
		}

		/**
		 * Search for Shows (without episodes)
		 */
		TVMaze4J.LOGGER.info("Searching for Shows");
		List<Show> manyShows1 = client.showSearch("girls");
		manyShows1.stream().forEach(s ->
		{
			System.out.println("-----------------------------------------");
			checkShow(s);
		});

		/**
		 * Search for Shows with episodes
		 */
		TVMaze4J.LOGGER.info("Searching for Shows with episodes");
		List<Show> manyShows2 = client.showSearch("silicon valley", true);
		manyShows2.stream().forEach(s ->
		{
			System.out.println("-----------------------------------------");
			checkShow(s);
		});

		/**
		 * Attempting to fetch all items and properties available.
		 */
		TVMaze4J.LOGGER.info("Searching for Shows with episodes and specials");
		List<Show> manyShows3 = client.showSearch("Game of Thrones", true, true);
		manyShows3.stream().forEach(s ->
		{
			System.out.println("-----------------------------------------");
			checkShow(s);
		});

		/**
		 * Attempting to get a single show
		 */
		TVMaze4J.LOGGER.info("Searching for Shows with episodes and specials");
		Show showImpl1 = client.showSingleSearch("Silicon Valley");
		checkShow(showImpl1);

		/**
		 * Attempting to get a single show with episodes
		 */
		TVMaze4J.LOGGER.info("Searching for Shows with episodes and specials");
		Show showImpl2 = client.showSingleSearch("Game of Thrones", true);
		checkShow(showImpl2);
	}

	public void testSchedules()
	{
		TVMaze4J.LOGGER.info("Attempting to test schedules...");
		TVMazeClient client = new ClientBuilder().build();

		/**
		 * Attempting to get today's schedule
		 */
		TVMaze4J.LOGGER.info("Getting today's schedule");
		List<Episode> episodes1 = client.getSchedule();
		episodes1.stream().forEach(e -> checkEpisode(e));

		/**
		 * Attempting to get today's schedule in Norway
		 * ISO Country Code: https://en.wikipedia.org/wiki/ISO_3166-1
		 */
		TVMaze4J.LOGGER.info("Getting today's schedule in Norway");
		List<Episode> episodes3 = client.getSchedule("No");
		episodes3.stream().forEach(e -> checkEpisode(e));

		/**
		 * Attempting to get 30-09-2017's schedule
		 */
		TVMaze4J.LOGGER.info("Getting 30-09-2017's schedule");
		List<Episode> episodes2 = client.getSchedule(LocalDate.parse("2017-09-30"));
		episodes2.stream().forEach(e -> checkEpisode(e));

		/**
		 * Attempting to get 30-09-2017's schedule in Norway
		 * ISO Country Code: https://en.wikipedia.org/wiki/ISO_3166-1
		 */
		TVMaze4J.LOGGER.info("Getting today's schedule in Norway");
		List<Episode> episodes4 = client.getSchedule("no", LocalDate.parse("2017-09-30"));
		episodes4.stream().forEach(e -> checkEpisode(e));

		/**
		 * Attempting to get FULL schedule.
		 */
		TVMaze4J.LOGGER.info("Getting FULL schedule");
		List<Episode> episodes5 = client.getFullSchedule();
		episodes5.stream().forEach(e -> checkEpisode(e));
	}

	public void testSeasons()
	{
		TVMazeClient client = new ClientBuilder().build();

		/**
		 * Attempting to get all seasons in Silicon Valley (ID: 143)
		 */
		TVMaze4J.LOGGER.info("Attempting to get all seasons in Silicon Valley (ID: 143)...");
		List<Season> seasons1 = client.getSeasons(143);
		seasons1.stream().forEach(s -> System.out.println(s));
	}

	private void checkEpisode(Episode episode)
	{
		TVMaze4J.LOGGER.info("episodes: " + episode);
		TVMaze4J.LOGGER.info("episodes->getId: " + episode.getId());
		TVMaze4J.LOGGER.info("episodes->url: " + episode.getUrl());
		TVMaze4J.LOGGER.info("episodes->name: " + episode.getName());
		TVMaze4J.LOGGER.info("episodes->season: " + episode.getSeason());
		TVMaze4J.LOGGER.info("episodes->number: " + episode.getNumber());
		TVMaze4J.LOGGER.info("episodes->airDate: " + episode.getAirDate());
		TVMaze4J.LOGGER.info("episodes->airTime: " + episode.getAirTime());
		TVMaze4J.LOGGER.info("episodes->airStamp: " + episode.getAirStamp());
		TVMaze4J.LOGGER.info("episodes->runtime: " + episode.getRuntime());
		TVMaze4J.LOGGER.info("episodes->images: " + episode.getImages());
		TVMaze4J.LOGGER.info("episodes->summary: " + episode.getSummary());
		TVMaze4J.LOGGER.info("episodes->links: " + episode.getLinks());

		Show show = episode.getShow();
		TVMaze4J.LOGGER.info("SHOW: " + show);
		if (show != null)
		{
			checkShow(show);
		}
	}


	private void checkShow(Show showImpl)
	{
		TVMaze4J.LOGGER.info("SCORE: " + showImpl.getSearchRelevanceScore());
		TVMaze4J.LOGGER.info("ID: " + showImpl.getId());
		TVMaze4J.LOGGER.info("URL: " + showImpl.getUrl());
		TVMaze4J.LOGGER.info("NAME: " + showImpl.getName());
		TVMaze4J.LOGGER.info("TYPE: " + showImpl.getType());
		TVMaze4J.LOGGER.info("LANGUAGE: " + showImpl.getLanguage());
		TVMaze4J.LOGGER.info("GENRES: " + showImpl.getGenres());
		TVMaze4J.LOGGER.info("STATUS: " + showImpl.getStatus());
		TVMaze4J.LOGGER.info("RUNTIME: " + showImpl.getRuntime());
		TVMaze4J.LOGGER.info("PREMIERED: " + showImpl.getPremiered());
		TVMaze4J.LOGGER.info("OFFICIAL SITE: " + showImpl.getOfficialSite());

		Schedule schedule = showImpl.getSchedule();
		TVMaze4J.LOGGER.info("SCHEDULE: " + schedule);
		TVMaze4J.LOGGER.info("schedule->getTime: " + schedule.getTime());
		TVMaze4J.LOGGER.info("schedule->getDays: " + schedule.getDays());

		Rating rating = showImpl.getRating();
		TVMaze4J.LOGGER.info("RATING: " + rating);
		if (rating != null)
		{
			TVMaze4J.LOGGER.info("rating->getAverage: " + rating.getAverage());
		}

		TVMaze4J.LOGGER.info("WEIGHT: " + showImpl.getWeight());

		Network network = showImpl.getNetwork();
		TVMaze4J.LOGGER.info("NETWORK: " + network);
		if (network != null)
		{
			TVMaze4J.LOGGER.info("network->getId: " + network.getId());
			TVMaze4J.LOGGER.info("network->getName: " + network.getName());
			TVMaze4J.LOGGER.info("network->getCountry: " + network.getCountry());
			if (network.getCountry() != null)
			{
				TVMaze4J.LOGGER.info("network->getCountry->getCode: " + network.getCountry().getCode());
				TVMaze4J.LOGGER.info("network->getCountry->getName: " + network.getCountry().getName());
				TVMaze4J.LOGGER.info("network->getCountry->getTimeZone: " + network.getCountry().getTimeZone());
			}
		}

		WebChannel webChannel = showImpl.getWebChannel();
		TVMaze4J.LOGGER.info("WEB CHANNEL: " + webChannel);
		if (webChannel != null)
		{
			TVMaze4J.LOGGER.info("webChannel->getId: " + webChannel.getId());
			TVMaze4J.LOGGER.info("webChannel->getName: " + webChannel.getName());
			TVMaze4J.LOGGER.info("webChannel->getCountry: " + webChannel.getCountry());
			if (webChannel.getCountry() != null)
			{
				TVMaze4J.LOGGER.info("webChannel->getCountry->getCode: " + webChannel.getCountry().getCode());
				TVMaze4J.LOGGER.info("webChannel->getCountry->getName: " + webChannel.getCountry().getName());
				TVMaze4J.LOGGER.info("webChannel->getCountry->getTimeZone: " + webChannel.getCountry().getTimeZone());
			}
		}

		TVMaze4J.LOGGER.info("EXTERNALS: " + showImpl.getExternals());
		TVMaze4J.LOGGER.info("IMAGES: " + showImpl.getImages());
		TVMaze4J.LOGGER.info("SUMMARY: " + showImpl.getSummary());
		TVMaze4J.LOGGER.info("UPDATED: " + showImpl.getUpdated());
		TVMaze4J.LOGGER.info("LINKS: " + showImpl.getLinks());
		Embedded embedded = showImpl.getEmbedded();
		TVMaze4J.LOGGER.info("EMBEDDED: " + embedded);
		if (embedded != null)
		{
			TVMaze4J.LOGGER.info("embedded->getShowImpl: " + embedded.getShow());
			TVMaze4J.LOGGER.info("embedded->getEpisodes: " + embedded.getEpisodes());
		}

		List<Episode> episodes = showImpl.getEpisodes();
		TVMaze4J.LOGGER.info("EPISODES: " + episodes);
		if (episodes != null)
		{
			episodes.stream().forEach(e ->
			{
				System.out.println("---------------------------------------------");
				TVMaze4J.LOGGER.info("episodes->episode: " + e);
				TVMaze4J.LOGGER.info("episodes->episode->getId: " + e.getId());
				TVMaze4J.LOGGER.info("episodes->episode->url: " + e.getUrl());
				TVMaze4J.LOGGER.info("episodes->episode->name: " + e.getName());
				TVMaze4J.LOGGER.info("episodes->episode->season: " + e.getSeason());
				TVMaze4J.LOGGER.info("episodes->episode->number: " + e.getNumber());
				TVMaze4J.LOGGER.info("episodes->episode->airDate: " + e.getAirDate());
				TVMaze4J.LOGGER.info("episodes->episode->airTime: " + e.getAirTime());
				TVMaze4J.LOGGER.info("episodes->episode->airStamp: " + e.getAirStamp());
				TVMaze4J.LOGGER.info("episodes->episode->runtime: " + e.getRuntime());
				TVMaze4J.LOGGER.info("episodes->episode->images: " + e.getImages());
				TVMaze4J.LOGGER.info("episodes->episode->summary: " + e.getSummary());
				TVMaze4J.LOGGER.info("episodes->episode->links: " + e.getLinks());
			});
		}
	}
}
