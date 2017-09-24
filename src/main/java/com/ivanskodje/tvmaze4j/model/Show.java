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

package com.ivanskodje.tvmaze4j.model;

import com.ivanskodje.tvmaze4j.model.impl.*;

import java.util.Date;
import java.util.List;

/**
 * Show Interface.
 *
 * @author Ivan Skodje on 24/09/2017
 */
public interface Show
{
	float getScore();

	void setScore(Float score);

	int getId();

	void setId(Integer id);

	String getUrl();

	void setUrl(String url);

	String getName();

	void setName(String name);

	String getType();

	void setType(String type);

	String getLanguage();

	void setLanguage(String language);

	List<String> getGenres();

	void setGenres(List<String> genres);

	String getStatus();

	void setStatus(String status);

	int getRuntime();

	void setRuntime(Integer runtime);

	Date getPremiered();

	void setPremiered(Date premiered);

	String getOfficialSite();

	void setOfficialSite(String officialSite);

	ScheduleImpl getScheduleImpl();

	void setScheduleImpl(ScheduleImpl scheduleImpl);

	RatingImpl getRatingImpl();

	void setRatingImpl(RatingImpl ratingImpl);

	int getWeight();

	void setWeight(Integer weight);

	NetworkImpl getNetworkImpl();

	void setNetworkImpl(NetworkImpl networkImpl);

	WebChannelImpl getWebChannelImpl();

	void setWebChannelImpl(WebChannelImpl webChannelImpl);

	ExternalsImpl getExternalsImpl();

	void setExternalsImpl(ExternalsImpl externalsImpl);

	ImagesImpl getImagesImpl();

	void setImagesImpl(ImagesImpl imagesImpl);

	String getSummary();

	void setSummary(String summary);

	int getUpdated();

	void setUpdated(Integer updated);

	LinksImpl getLinksImpl();

	void setLinksImpl(LinksImpl linksImpl);

	EmbeddedImpl getEmbeddedImpl();

	void setEmbeddedImpl(EmbeddedImpl embeddedImpl);

	List<EpisodeImpl> getEpisodes();

	void setEpisodes(List<EpisodeImpl> episodeImpls);
}
