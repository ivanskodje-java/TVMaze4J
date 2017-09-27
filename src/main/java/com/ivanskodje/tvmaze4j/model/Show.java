/*************************************************************************
 * This file (Show.java) is part of TVMaze4J.                            *
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

import java.util.Date;
import java.util.List;

/**
 * The Show.
 *
 * @author Ivan Skodje on 21/09/2017
 */
public class Show
{
	/**
	 * Search relevance score.
	 * <p>
	 * Score is estimated to range 0 and up to 40.
	 * <p>
	 * When searching with terms that provide multiple results,
	 * the result with the highest search relevance score will
	 * return when searching for a single show.
	 */
	private float searchRelevanceScore = -1;

	/**
	 * The Show's TVMaze ID.
	 * IDs range 0 and up.
	 */
	private int id = -1;

	/**
	 * Direct URL to the Show on TVMaze.com.
	 */
	private String url = "";

	/**
	 * Show name.
	 */
	private String name = "";

	/**
	 * Show type.
	 * Examples: "Talk Show", "Documentary", "Scripted", "Reality".
	 */
	private String type = "";

	/**
	 * The spoken language.
	 */
	private String language = "";

	/**
	 * Show genres.
	 */
	private List<String> genres = null;

	/**
	 * The Show's current status.
	 * Examples: "Running", "In Development".
	 */
	private String status = "";

	/**
	 * The length of each episode in minutes.
	 * <p>
	 * Runtime vary, usually ranged 20 and up.
	 */
	private int runtime = -1;

	/**
	 * The date of the Show's premiere.
	 * TODO: Change from Date to LocalDateTime.
	 */
	private Date premiered = null;

	/**
	 * URL to the Show's official web-site.
	 */
	private String officialSite = "";

	/**
	 * Show schedule.
	 */
	private Schedule schedule = null;

	/**
	 * Show rating.
	 */
	private Rating rating = null;

	/**
	 * The most popular Show on TVMaze would have a weight value of 100,
	 * while the worst would have a value of 0.
	 * <p>
	 * Weight is ranged 0 and up to 100.
	 */
	private int weight = -1;

	/**
	 * Show Network. Ex: "CNN", "Bloomberg TV", "CBS Sports Network".
	 */
	private Network network = null;

	/**
	 * Some shows originate from the web, such as "YouTube Red".
	 */
	private WebChannel webChannel = null;

	/**
	 * Externals contain the Show IDs from IMDB, TVRage and TheTVDB.
	 */
	private Externals externals = null;

	/**
	 * Contains the URL addresses to the medium and original
	 * Show images.
	 */
	private Images images = null;

	/**
	 * The Show summary is a small description of the
	 * Show with HTML formatting.
	 */
	private String summary = "";

	/**
	 * Updated is a Unix Epoch value. It is updated to reflect
	 * the time and date of the last update to the Show or episodes.
	 * <p>
	 * A common use for this value may be to compare your own local cache
	 * with TVMaze to check if there have been any changes to the Show.
	 * <p>
	 * Keep in mind that MazeTV stores their own Show cache for 24 hours.
	 */
	private int updated = -1;

	/**
	 * Links may contain API URLs to the Show, as well to
	 * a previous- and next episode.
	 */
	private Links links = null;

	/**
	 * Embedded may contain a Show, or a list of episodes.
	 */
	private Embedded embedded = null;

	/**
	 * Returns the Show's search relevance score
	 * from the search that fetched this,
	 * or -1 if none has been set.
	 *
	 * @return Search relevance score.
	 */
	public float getSearchRelevanceScore()
	{
		return searchRelevanceScore;
	}

	/**
	 * Sets the Show's search relevance score
	 * from the search that fetched this,
	 * if it is not null.
	 *
	 * @param searchRelevanceScore
	 */
	public void setSearchRelevanceScore(Float searchRelevanceScore)
	{
		if (searchRelevanceScore != null)
		{
			this.searchRelevanceScore = searchRelevanceScore;
		}
	}

	/**
	 * Returns the Show's TVMaze ID,
	 * or -1 if none has been set.
	 *
	 * @return Show's TVMaze ID.
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Sets the Show's TVMaze ID,
	 * if it is not null.
	 *
	 * @param id Show's TVMaze ID.
	 */
	public void setId(Integer id)
	{
		if (id != null)
		{
			this.id = id;
		}
	}

	/**
	 * Returns a URL directly to the Show on TVMaze.com,
	 * or an empty string if none have been set.
	 *
	 * @return URL to the Show.
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * Sets the TVMaze URL to the Show,
	 * if it is not null.
	 *
	 * @param url URL to the Show.
	 */
	public void setUrl(String url)
	{
		if (url != null)
		{
			this.url = url;
		}
	}

	/**
	 * Returns the Show name,
	 * or an empty string if none have been set.
	 *
	 * @return Show name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name of the Show,
	 * if it is not null.
	 *
	 * @param name Show name.
	 */
	public void setName(String name)
	{
		if (name != null)
		{
			this.name = name;
		}
	}

	/**
	 * Returns the Show type,
	 * or an empty string if none have been set.
	 *
	 * @return Show type.
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * Sets the Show type,
	 * if it is not null.
	 *
	 * @param type Show type.
	 */
	public void setType(String type)
	{
		if (type != null)
		{
			this.type = type;
		}
	}

	/**
	 * Returns the Show language,
	 * or an empty string if none have been set.
	 *
	 * @return Show language.
	 */
	public String getLanguage()
	{
		return language;
	}

	/**
	 * Sets the Show language,
	 * if it is not null.
	 *
	 * @param language Show language.
	 */
	public void setLanguage(String language)
	{
		if (language != null)
		{
			this.language = language;
		}
	}

	/**
	 * Returns a list of genres for the Show,
	 * or an empty string if none have been set.
	 *
	 * @return List of genres.
	 */
	public List<String> getGenres()
	{
		return genres;
	}

	/**
	 * Sets a list of genres for the Show,
	 * if it is not null.
	 *
	 * @param genres List of genres.
	 */
	public void setGenres(List<String> genres)
	{
		if (genres != null)
		{
			this.genres = genres;
		}
	}

	/**
	 * Returns the Show status,
	 * or an empty string if none have been set.
	 *
	 * @return Show status.
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * Sets the Show status,
	 * if it is not null
	 *
	 * @param status Show status.
	 */
	public void setStatus(String status)
	{
		if (status != null)
		{
			this.status = status;
		}
	}

	/**
	 * Returns the runtime of the episodes,
	 * which is the length in minutes.
	 * <p>
	 * Returns -1 if none have been set.
	 *
	 * @return The episode's runtime.
	 */
	public int getRuntime()
	{
		return runtime;
	}

	/**
	 * Sets the episode's runtime,
	 * if it is not null.
	 *
	 * @param runtime The episode's runtime.
	 */
	public void setRuntime(Integer runtime)
	{
		if (runtime != null)
		{
			this.runtime = runtime;
		}
	}

	/**
	 * Returns the date of the Show's premiere,
	 * or -1 if none have been set.
	 *
	 * @return Premiere date.
	 */
	public Date getPremiered()
	{
		return premiered;
	}

	/**
	 * Sets the date of the Show's premiere,
	 * if it is not null.
	 *
	 * @param premiered Premiere date.
	 */
	public void setPremiered(Date premiered)
	{
		if (premiered != null)
		{
			this.premiered = premiered;
		}
	}

	/**
	 * Returns the URL to the official web-site of the Show,
	 * or an empty string if none have been set.
	 *
	 * @return The Show's official web-site URL.
	 */
	public String getOfficialSite()
	{
		return officialSite;
	}

	/**
	 * Sets the URL to the official web-site of the Show,
	 * if it is not null.
	 *
	 * @param officialSite The Show's official web-site URL.
	 */
	public void setOfficialSite(String officialSite)
	{
		if (officialSite != null)
		{
			this.officialSite = officialSite;
		}
	}

	/**
	 * Returns the weekly schedule of the Show,
	 * or null if none have been set.
	 *
	 * @return Show {@link Schedule}.
	 */
	public Schedule getSchedule()
	{
		return schedule;
	}

	/**
	 * Sets the weekly schedule of the Show,
	 * if it is not null.
	 *
	 * @param schedule Show {@link Schedule}.
	 */
	public void setSchedule(Schedule schedule)
	{
		if (schedule != null)
		{
			this.schedule = schedule;
		}
	}

	/**
	 * Returns the Show Rating,
	 * or null if none have been set.
	 *
	 * @return Show {@link Rating}.
	 */
	public Rating getRating()
	{
		return rating;
	}

	/**
	 * Sets the Show Rating,
	 * if it is not null.
	 *
	 * @param rating Show {@link Rating}.
	 */
	public void setRating(Rating rating)
	{
		if (rating != null)
		{
			this.rating = rating;
		}
	}

	/**
	 * Returns the Show's weight on TVMaze,
	 * or -1 if none have been set.
	 * <p>
	 * The most popular Show on TVMaze would have a weight value of 100,
	 * while the worst would have a value of 0.
	 *
	 * @return The Show's weight.
	 */
	public int getWeight()
	{
		return weight;
	}

	/**
	 * Sets the Show's weight on TVMaze,
	 * if it is not null.
	 * <p>
	 * The most popular Show on TVMaze would have a weight value of 100,
	 * while the worst would have a value of 0.
	 *
	 * @param weight The Show's weight.
	 */
	public void setWeight(Integer weight)
	{
		if (weight != null)
		{
			this.weight = weight;
		}
	}

	/**
	 * Returns the Show's Network,
	 * or null if none have been set.
	 *
	 * @return Show's {@link Network}.
	 */
	public Network getNetwork()
	{
		return network;
	}

	/**
	 * Sets the Show's Network,
	 * if it is not null.
	 *
	 * @param network Show's {@link Network}.
	 */
	public void setNetwork(Network network)
	{
		if (network != null)
		{
			this.network = network;
		}
	}

	/**
	 * Returns the Show's Web Channel,
	 * or null if none have been set.
	 *
	 * @return Show's {@link WebChannel}.
	 */
	public WebChannel getWebChannel()
	{
		return webChannel;
	}

	/**
	 * Sets the Show's Web Channel,
	 * if it is not null.
	 *
	 * @param webChannel Show's {@link WebChannel}.
	 */
	public void setWebChannel(WebChannel webChannel)
	{
		if (webChannel != null)
		{
			this.webChannel = webChannel;
		}
	}

	/**
	 * Returns the Show's externals,
	 * or null if none have been set.
	 * <p>
	 * Externals contain Show ID's from other databases.
	 *
	 * @return The Show's {@link Externals}.
	 */
	public Externals getExternals()
	{
		return externals;
	}

	/**
	 * Sets the Show's externals,
	 * if it is not null.
	 *
	 * @param externals The Show's {@link Externals}.
	 */
	public void setExternals(Externals externals)
	{
		if (externals != null)
		{
			this.externals = externals;
		}
	}

	/**
	 * Returns the Show's images,
	 * or null of none have been set.
	 *
	 * @return The Show's {@link Images}.
	 */
	public Images getImages()
	{
		return images;
	}

	/**
	 * Sets the Show's images,
	 * if it is not null.
	 *
	 * @param images The Show's {@link Images}.
	 */
	public void setImages(Images images)
	{
		if (images != null)
		{
			this.images = images;
		}
	}

	/**
	 * Returns the Show's summary,
	 * or an empty string if none have been set.
	 *
	 * @return The Show's summary.
	 */
	public String getSummary()
	{
		return summary;
	}

	/**
	 * Sets the Show's summary,
	 * if it is not null.
	 *
	 * @param summary The Show's summary.
	 */
	public void setSummary(String summary)
	{
		if (summary != null)
		{
			this.summary = summary;
		}
	}

	/**
	 * Returns last update, which is a Unix Epoch value for the
	 * last time the Show have been updated (recursively),
	 * or -1 if none have been set.
	 *
	 * @return The last update in unix epoch time.
	 */
	public int getUpdated()
	{
		return updated;
	}

	/**
	 * Sets last update, which is a Unix Epoch value for the
	 * last time the Show have been updated (recursively),
	 * if it is not null.
	 *
	 * @param updated The last update in unix epoch time.
	 */
	public void setUpdated(Integer updated)
	{
		if (updated != null)
		{
			this.updated = updated;
		}
	}

	/**
	 * Returns the Links associated with this Show,
	 * or null if none have been set.
	 *
	 * @return {@link Links}.
	 */
	public Links getLinks()
	{
		return links;
	}

	/**
	 * Sets the Links associated with this Show,
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
	 * Returns the Embedded data, which may contain
	 * the {@link Episode}s for the Show,
	 * or null of none have been set.
	 *
	 * @return The Show's {@link Embedded} data.
	 */
	public Embedded getEmbedded()
	{
		return embedded;
	}

	/**
	 * Sets the Embedded data, which may contain
	 * the {@link Episode}s for the Show,
	 * if it is not null.
	 *
	 * @param embedded {@link Embedded}.
	 */
	public void setEmbedded(Embedded embedded)
	{
		if (embedded != null)
		{
			this.embedded = embedded;
		}
	}

	/**
	 * Returns a list of the Show's {@link Episode}s,
	 * or null if none have been set.
	 * <p>
	 * Episodes are stored and retrieved from {@link Embedded}.
	 *
	 * @return {@link Episode}.
	 */
	public List<Episode> getEpisodes()
	{
		if (embedded == null)
		{
			return null;
		}
		return embedded.getEpisodes();
	}

	/**
	 * Sets a list of the Show's {@link Episode}s,
	 * if it is not null.
	 * <p>
	 * If embedded is null, we instantiate it before
	 * adding the shows.
	 * <p>
	 * Episodes are stored and retrieved from {@link Embedded}.
	 *
	 * @param episodes {@link Episode}.
	 */
	public void setEpisodes(List<Episode> episodes)
	{
		if (episodes != null)
		{
			if (embedded == null)
			{
				embedded = new Embedded();
			}
			embedded.setEpisodes(episodes);
		}
	}

	/**
	 * Returns the Show name.
	 * <p>
	 * Formatted as:
	 * "[name]"
	 *
	 * @return A description of the show.
	 */
	@Override
	public String toString()
	{
		return getName();
	}
}
