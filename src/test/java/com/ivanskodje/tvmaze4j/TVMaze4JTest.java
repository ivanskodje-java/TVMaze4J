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

package com.ivanskodje.tvmaze4j;

import com.ivanskodje.tvmaze4j.api.ClientBuilder;
import com.ivanskodje.tvmaze4j.api.TVMazeClient;
import com.ivanskodje.tvmaze4j.model.impl.*;
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
		ShowImpl showImpl1 = client.showSingleSearch("silicon valley", true);
		System.out.println(showImpl1.getEpisodes());

		// Get show with TVRage ID
		ShowImpl showImpl2 = client.showLookUpFromTvRage(24493); // Game of Thrones has TVRage ID 24493
		System.out.println(showImpl2);

		// Get show with TheTVDB ID
		ShowImpl showImpl3 = client.showLookUpFromTheTvDb(81189); // Breaking Bad has TheTVDB ID 81189
		System.out.println(showImpl3);

		// Get show with IMDB ID
		ShowImpl showImpl4 = client.showLookUpFromImdb("tt0944947"); // Game of Thrones has IMDB ID tt0944947
		System.out.println(showImpl4);

		// Get show with TVMaze
		ShowImpl showImpl5 = client.showLookUp(143); // Silicon Valley has TVMaze ID 143
		System.out.println(showImpl5);

		// Get a list of Episodes from ID
		List<EpisodeImpl> episodes1 = client.showEpisodeList(143); // List of episodes from Silicon Valley (TVmaze ID 143)
		System.out.println(episodes1);

		// Get a specific episode
		EpisodeImpl episodeImpl1 = client.episodeByNumber(143, 1, 4); // showid, season, number
		System.out.println(episodeImpl1);

		// Get a list of episodes aired by the show on a specific date.
		List<EpisodeImpl> episodes2 = client.episodesByDate(1, LocalDate.parse("2013-07-01")); // showid, date (yyyy-mm-dd)
		System.out.println(episodes2);
	}

	/**
	 * Make sure we can retrieve a lot of shows from TVMaze.
	 * <p>
	 * NB: Requires internet connectivity.
	 */
	public void testSearchShows()
	{
		/**
		 * Attempting to create a client, and fetch a List of Shows.
		 */
		TVMaze4J.LOGGER.info("Attempting to search for showImpls, using the query 'silicon valley'...");
		TVMazeClient client = new ClientBuilder().build();
		List<ShowImpl> showImpls = client.showSearch("silicon valley");
		showImpls.stream().forEach(s -> TVMaze4J.LOGGER.info("Search Result: " + s));

		if (showImpls.size() > 0 && showImpls.get(0).getClass().getSimpleName().equals("ShowImpl"))
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
		List<ShowImpl> manyShows1 = client.showSearch("girls");
		manyShows1.stream().forEach(s ->
		{
			System.out.println("-----------------------------------------");
			checkShow(s);
		});

		/**
		 * Search for Shows with episodes
		 */
		TVMaze4J.LOGGER.info("Searching for Shows with episodes");
		List<ShowImpl> manyShows2 = client.showSearch("silicon valley", true);
		manyShows2.stream().forEach(s ->
		{
			System.out.println("-----------------------------------------");
			checkShow(s);
		});

		/**
		 * Attempting to fetch all items and properties available.
		 */
		TVMaze4J.LOGGER.info("Searching for Shows with episodes and specials");
		List<ShowImpl> manyShows3 = client.showSearch("Game of Thrones", true, true);
		manyShows3.stream().forEach(s ->
		{
			System.out.println("-----------------------------------------");
			checkShow(s);
		});

		/**
		 * Attempting to get a single show
		 */
		TVMaze4J.LOGGER.info("Searching for Shows with episodes and specials");
		ShowImpl showImpl1 = client.showSingleSearch("Silicon Valley");
		checkShow(showImpl1);

		/**
		 * Attempting to get a single show with episodes
		 */
		TVMaze4J.LOGGER.info("Searching for Shows with episodes and specials");
		ShowImpl showImpl2 = client.showSingleSearch("Game of Thrones", true);
		checkShow(showImpl2);


	}

	private void checkShow(ShowImpl showImpl)
	{
		TVMaze4J.LOGGER.info("SCORE: " + showImpl.getScore());
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

		ScheduleImpl scheduleImpl = showImpl.getScheduleImpl();
		TVMaze4J.LOGGER.info("SCHEDULE: " + scheduleImpl);
		TVMaze4J.LOGGER.info("scheduleImpl->getTime: " + scheduleImpl.getTime());
		TVMaze4J.LOGGER.info("scheduleImpl->getDays: " + scheduleImpl.getDays());

		RatingImpl ratingImpl = showImpl.getRatingImpl();
		TVMaze4J.LOGGER.info("RATING: " + ratingImpl);
		if (ratingImpl != null)
		{
			TVMaze4J.LOGGER.info("ratingImpl->getAverage: " + ratingImpl.getAverage());
		}

		TVMaze4J.LOGGER.info("WEIGHT: " + showImpl.getWeight());

		NetworkImpl networkImpl = showImpl.getNetworkImpl();
		TVMaze4J.LOGGER.info("NETWORK: " + networkImpl);
		if (networkImpl != null)
		{
			TVMaze4J.LOGGER.info("networkImpl->getId: " + networkImpl.getId());
			TVMaze4J.LOGGER.info("networkImpl->getName: " + networkImpl.getName());
			TVMaze4J.LOGGER.info("networkImpl->getCountryImpl: " + networkImpl.getCountryImpl());
			if (networkImpl.getCountryImpl() != null)
			{
				TVMaze4J.LOGGER.info("networkImpl->getCountryImpl->getCode: " + networkImpl.getCountryImpl().getCode());
				TVMaze4J.LOGGER.info("networkImpl->getCountryImpl->getName: " + networkImpl.getCountryImpl().getName());
				TVMaze4J.LOGGER.info("networkImpl->getCountryImpl->getTimeZone: " + networkImpl.getCountryImpl().getTimeZone());
			}
		}

		WebChannelImpl webChannelImpl = showImpl.getWebChannelImpl();
		TVMaze4J.LOGGER.info("WEB CHANNEL: " + webChannelImpl);
		if (webChannelImpl != null)
		{
			TVMaze4J.LOGGER.info("webChannelImpl->getId: " + webChannelImpl.getId());
			TVMaze4J.LOGGER.info("webChannelImpl->getName: " + webChannelImpl.getName());
			TVMaze4J.LOGGER.info("webChannelImpl->getCountryImpl: " + webChannelImpl.getCountryImpl());
			if (webChannelImpl.getCountryImpl() != null)
			{
				TVMaze4J.LOGGER.info("webChannelImpl->getCountryImpl->getCode: " + webChannelImpl.getCountryImpl().getCode());
				TVMaze4J.LOGGER.info("webChannelImpl->getCountryImpl->getName: " + webChannelImpl.getCountryImpl().getName());
				TVMaze4J.LOGGER.info("webChannelImpl->getCountryImpl->getTimeZone: " + webChannelImpl.getCountryImpl().getTimeZone());
			}
		}

		TVMaze4J.LOGGER.info("EXTERNALS: " + showImpl.getExternalsImpl());
		TVMaze4J.LOGGER.info("IMAGES: " + showImpl.getImagesImpl());
		TVMaze4J.LOGGER.info("SUMMARY: " + showImpl.getSummary());
		TVMaze4J.LOGGER.info("UPDATED: " + showImpl.getUpdated());
		TVMaze4J.LOGGER.info("LINKS: " + showImpl.getLinksImpl());
		EmbeddedImpl embeddedImpl = showImpl.getEmbeddedImpl();
		TVMaze4J.LOGGER.info("EMBEDDED: " + embeddedImpl);
		if (embeddedImpl != null)
		{
			TVMaze4J.LOGGER.info("embeddedImpl->getShowImpl: " + embeddedImpl.getShowImpl());
			TVMaze4J.LOGGER.info("embeddedImpl->getEpisodeImpls: " + embeddedImpl.getEpisodeImpls());
		}

		List<EpisodeImpl> episodeImpls = showImpl.getEpisodes();
		TVMaze4J.LOGGER.info("EPISODES: " + episodeImpls);
		if (episodeImpls != null)
		{
			episodeImpls.stream().forEach(e ->
			{
				System.out.println("---------------------------------------------");
				TVMaze4J.LOGGER.info("episodeImpls->episode: " + e);
				TVMaze4J.LOGGER.info("episodeImpls->episode->getId: " + e.getId());
				TVMaze4J.LOGGER.info("episodeImpls->episode->url: " + e.getUrl());
				TVMaze4J.LOGGER.info("episodeImpls->episode->name: " + e.getName());
				TVMaze4J.LOGGER.info("episodeImpls->episode->season: " + e.getSeason());
				TVMaze4J.LOGGER.info("episodeImpls->episode->number: " + e.getNumber());
				TVMaze4J.LOGGER.info("episodeImpls->episode->airDate: " + e.getAirDate());
				TVMaze4J.LOGGER.info("episodeImpls->episode->airTime: " + e.getAirTime());
				TVMaze4J.LOGGER.info("episodeImpls->episode->airStamp: " + e.getAirStamp());
				TVMaze4J.LOGGER.info("episodeImpls->episode->runtime: " + e.getRuntime());
				TVMaze4J.LOGGER.info("episodeImpls->episode->images: " + e.getImagesImpl());
				TVMaze4J.LOGGER.info("episodeImpls->episode->summary: " + e.getSummary());
				TVMaze4J.LOGGER.info("episodeImpls->episode->links: " + e.getLinksImpl());
			});
		}
	}
}
