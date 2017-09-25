/*************************************************************************
 * This file (TVMaze4J.java) is part of TVMaze4J.                        *
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
import com.ivanskodje.tvmaze4j.model.Show;
import com.ivanskodje.tvmaze4j.util.LogMarkers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.NOPLoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This is the main class for TVMaze4J.
 * Not to be used as part of the wrapper - for intern use only.
 * <p>
 * A lot of static information about TVMaze4J will also be stored here.
 *
 * @author Ivan Skodje on 19/09/2017
 */
public class TVMaze4J
{
	/**
	 * API Name
	 */
	public static final String NAME;

	/**
	 * API Version
	 */
	public static final String VERSION;

	/**
	 * API Description
	 */
	public static final String DESCRIPTION;

	/**
	 * Logging with SLF4J.
	 */
	public static final Logger LOGGER = initializeLogger();


	/**
	 * Fetch information from Maven using the "app.properties" resource.
	 * This helps us avoiding duplicate values around the project.
	 */
	static
	{
		InputStream stream = TVMaze4J.class.getClassLoader().getResourceAsStream("app.properties");
		Properties properties = new Properties();
		try
		{
			properties.load(stream);
			stream.close();
		}
		catch (IOException ex)
		{
			TVMaze4J.LOGGER.error(LogMarkers.MAIN, "TVMaze4J: Unable to load app.properties resource.", ex);
		}

		NAME = properties.getProperty("app.name");
		VERSION = properties.getProperty("app.version");
		DESCRIPTION = properties.getProperty("app.description");

		LOGGER.info(LogMarkers.MAIN, String.format("%s (%s)", NAME, VERSION));
		LOGGER.info(LogMarkers.MAIN, String.format("%s", DESCRIPTION));
	}

	/**
	 * We attempt to initialize the SLF4J logger.
	 *
	 * @return A initialized logger.
	 */
	private static Logger initializeLogger()
	{
		if (hasSLF4J())
		{
			return LoggerFactory.getLogger(TVMaze4J.class);
		}
		else
		{
			/**
			 * TODO: Implement a custom logger that we can return instead of NOP?
			 */
			System.err.println("TVMaze4J: Error initializing the SLF4J logger.\n" +
					"TVMaze4J: There are no SLF4J implementation available.");
			return LoggerFactory.getLogger(NOPLoggerFactory.class);
		}
	}

	/**
	 * Tells us whether or not we have SLF4J available.
	 *
	 * @return Is SLF4J available?
	 */
	private static boolean hasSLF4J()
	{
		try
		{
			Class.forName("org.slf4j.impl.StaticLoggerBinder");
			return !(LoggerFactory.getILoggerFactory() instanceof NOPLoggerFactory);
		}
		catch (ClassNotFoundException ex)
		{
			return false;
		}
	}

	/**
	 * Run TVMaze4J in order to test whether or not you can connect with the TVMaze API.
	 * <p>
	 * Requires access to http://api.tvmaze.com.
	 *
	 * @param args No parameters expected.
	 */
	public static void main(String[] args)
	{
		// Create client.
		ClientBuilder builder = new ClientBuilder();
		TVMazeClient client = builder.build();

		// Fetch a show.
		Show show = client.showSingleSearch("silicon valley", true);
		System.out.println(show.getClass().getSimpleName());
	}
}
