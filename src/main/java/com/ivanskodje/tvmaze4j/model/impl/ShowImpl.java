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

import com.ivanskodje.tvmaze4j.model.Show;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The ShowImpl.
 *
 * @author Ivan Skodje on 21/09/2017
 */
public class ShowImpl implements Show
{
	/**
	 * Search relevance score.
	 */
	private float score = 0;

	/**
	 * ShowImpl ID.
	 */
	private int id = -1;

	/**
	 * URL directly to the ShowImpl on TVMaze.com.
	 */
	private String url = "";

	/**
	 * ShowImpl name.
	 */
	private String name = "";

	/**
	 * ShowImpl type. Ex: "Talk ShowImpl", "Documentary", "Scripted", "Reality".
	 */
	private String type = "";

	/**
	 * The spoken language. Ex: "English".
	 */
	private String language = "";

	/**
	 * Genres. Ex: "Comedy", "Adult", "Drama".
	 */
	private List<String> genres = null;

	/**
	 * The show's current status. Ex: "Running", "In Development".
	 */
	private String status = "";

	/**
	 * The length of each episode in minutes.
	 */
	private int runtime = 0;

	/**
	 * The Date of the show's premiere.
	 */
	private Date premiered = null;

	/**
	 * URL to the show's official web-site.
	 */
	private String officialSite = "";

	/**
	 * ShowImpl scheduleImpl.
	 */
	private ScheduleImpl scheduleImpl = null;

	/**
	 * ShowImpl ratingImpl.
	 */
	private RatingImpl ratingImpl = null;

	/**
	 * Weight is a value between 0 and 100.
	 * The most popular show on TVMaze would have a weight value of 100,
	 * while the worst would have a value of 0.
	 */
	private int weight = 0;

	/**
	 * ShowImpl NetworkImpl. Ex: "CNN", "Bloomberg TV", "CBS Sports NetworkImpl".
	 */
	private NetworkImpl networkImpl = null;

	/**
	 * Some shows originate from the web, such as 'YouTube Red'.
	 */
	private WebChannelImpl webChannelImpl = null;

	/**
	 * ExternalsImpl contain the show IDs from IMDB, TVRage and TheTVDB.
	 */
	private ExternalsImpl externalsImpl = null;

	/**
	 * Contains the URL addresses to the medium and original show imagesImpl.
	 */
	private ImagesImpl imagesImpl = null;

	/**
	 * The ShowImpl summary is a small description of the show.
	 */
	private String summary = "";

	/**
	 * Updated is a Unix Epoch value. It is updated to reflect
	 * the time and date of the last update to the show or episodes.
	 * <p>
	 * A common use for this value, is to compare local cache with the remote
	 * to check if there have been any changes. Keep in mind that MazeTV stores
	 * their own ShowImpl cache for 24 hours.
	 */
	private int updated = 0;

	/**
	 * LinksImpl may contain API URLs to the show, as well to a previous- and next episode.
	 */
	private LinksImpl linksImpl = null;

	/**
	 * EmbeddedImpl may contain a show, or a list of episodes.
	 */
	private EmbeddedImpl embeddedImpl = null;

	public ShowImpl()
	{
		genres = new ArrayList<>();
		premiered = new Date();
		scheduleImpl = new ScheduleImpl();
		ratingImpl = new RatingImpl();
		networkImpl = new NetworkImpl();
		webChannelImpl = new WebChannelImpl();
		externalsImpl = new ExternalsImpl();
		imagesImpl = new ImagesImpl();
		linksImpl = new LinksImpl();
		embeddedImpl = new EmbeddedImpl();
	}

	@Override
	public float getScore()
	{
		return score;
	}

	@Override
	public void setScore(Float score)
	{
		if (score != null)
		{
			this.score = score;
		}
	}

	@Override
	public int getId()
	{
		return id;
	}

	@Override
	public void setId(Integer id)
	{
		if (id != null)
		{
			this.id = id;
		}
	}

	@Override
	public String getUrl()
	{
		return url;
	}

	@Override
	public void setUrl(String url)
	{
		if (url != null)
		{
			this.url = url;
		}
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public void setName(String name)
	{
		if (name != null)
		{
			this.name = name;
		}
	}

	@Override
	public String getType()
	{
		return type;
	}

	@Override
	public void setType(String type)
	{
		if (type != null)
		{
			this.type = type;
		}
	}

	@Override
	public String getLanguage()
	{
		return language;
	}

	@Override
	public void setLanguage(String language)
	{
		if (language != null)
		{
			this.language = language;
		}
	}

	@Override
	public List<String> getGenres()
	{
		return genres;
	}

	@Override
	public void setGenres(List<String> genres)
	{
		if (genres != null)
		{
			this.genres = genres;
		}
	}

	@Override
	public String getStatus()
	{
		return status;
	}

	@Override
	public void setStatus(String status)
	{
		if (status != null)
		{
			this.status = status;
		}
	}

	@Override
	public int getRuntime()
	{
		return runtime;
	}

	@Override
	public void setRuntime(Integer runtime)
	{
		if (runtime != null)
		{
			this.runtime = runtime;
		}
	}

	@Override
	public Date getPremiered()
	{
		return premiered;
	}

	@Override
	public void setPremiered(Date premiered)
	{
		if (premiered != null)
		{
			this.premiered = premiered;
		}
	}

	@Override
	public String getOfficialSite()
	{
		return officialSite;
	}

	@Override
	public void setOfficialSite(String officialSite)
	{
		if (officialSite != null)
		{
			this.officialSite = officialSite;
		}
	}

	@Override
	public ScheduleImpl getScheduleImpl()
	{
		return scheduleImpl;
	}

	@Override
	public void setScheduleImpl(ScheduleImpl scheduleImpl)
	{
		if (scheduleImpl != null)
		{
			this.scheduleImpl = scheduleImpl;
		}
	}

	@Override
	public RatingImpl getRatingImpl()
	{
		return ratingImpl;
	}

	@Override
	public void setRatingImpl(RatingImpl ratingImpl)
	{
		if (ratingImpl != null)
		{
			this.ratingImpl = ratingImpl;
		}
	}

	@Override
	public int getWeight()
	{
		return weight;
	}

	@Override
	public void setWeight(Integer weight)
	{
		if (weight != null)
		{
			this.weight = weight;
		}
	}

	@Override
	public NetworkImpl getNetworkImpl()
	{
		return networkImpl;
	}

	@Override
	public void setNetworkImpl(NetworkImpl networkImpl)
	{
		if (networkImpl != null)
		{
			this.networkImpl = networkImpl;
		}
	}

	@Override
	public WebChannelImpl getWebChannelImpl()
	{
		return webChannelImpl;
	}

	@Override
	public void setWebChannelImpl(WebChannelImpl webChannelImpl)
	{
		if (webChannelImpl != null)
		{
			this.webChannelImpl = webChannelImpl;
		}
	}

	@Override
	public ExternalsImpl getExternalsImpl()
	{
		return externalsImpl;
	}

	@Override
	public void setExternalsImpl(ExternalsImpl externalsImpl)
	{
		if (externalsImpl != null)
		{
			this.externalsImpl = externalsImpl;
		}
	}

	@Override
	public ImagesImpl getImagesImpl()
	{
		return imagesImpl;
	}

	@Override
	public void setImagesImpl(ImagesImpl imagesImpl)
	{
		if (imagesImpl != null)
		{
			this.imagesImpl = imagesImpl;
		}
	}

	@Override
	public String getSummary()
	{
		return summary;
	}

	@Override
	public void setSummary(String summary)
	{
		if (summary != null)
		{
			this.summary = summary;
		}
	}

	@Override
	public int getUpdated()
	{
		return updated;
	}

	@Override
	public void setUpdated(Integer updated)
	{
		if (updated != null)
		{
			this.updated = updated;
		}
	}

	@Override
	public LinksImpl getLinksImpl()
	{
		return linksImpl;
	}

	@Override
	public void setLinksImpl(LinksImpl linksImpl)
	{
		if (linksImpl != null)
		{
			this.linksImpl = linksImpl;
		}
	}

	@Override
	public EmbeddedImpl getEmbeddedImpl()
	{
		return embeddedImpl;
	}

	@Override
	public void setEmbeddedImpl(EmbeddedImpl embeddedImpl)
	{
		if (embeddedImpl != null)
		{
			this.embeddedImpl = embeddedImpl;
		}
	}

	@Override
	public List<EpisodeImpl> getEpisodes()
	{
		return embeddedImpl.getEpisodeImpls();
	}

	@Override
	public void setEpisodes(List<EpisodeImpl> episodeImpls)
	{
		if (episodeImpls != null)
		{
			embeddedImpl.setEpisodeImpls(episodeImpls);
		}
	}

	@Override
	public String toString()
	{
		return getName();
	}
}
