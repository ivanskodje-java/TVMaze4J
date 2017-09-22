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

import com.ivanskodje.tvmaze4j.api.ITVMazeClient;
import com.ivanskodje.tvmaze4j.api.internal.TVMazeClientImpl;
import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.slf4j.helpers.NOPLoggerFactory;

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
	 * We make sure that the Logger is functional and initialized
	 */
	public void testLogger()
	{
		if (TVMaze4J.LOGGER.getName().equals(NOPLoggerFactory.class.getName()))
		{
			fail("LOGGER initialisation FAILED.");

		}
		else
		{
			TVMaze4J.LOGGER.info("LOGGER initialisation success.");
			Assert.assertTrue("Logger was successfully initialised.", true);
		}
	}

	/**
	 * Initialise client and make sure it is not null.
	 */
	public void testClientInit()
	{
		TVMaze4J.LOGGER.info("Attempting to initialize client");
		ITVMazeClient client = new TVMazeClientImpl();
		assertNotNull(client);
	}

	/**
	 * Make sure we can retrieve shows from TVMaze.
	 * <p>
	 * NB: Requires internet connectivity.
	 * TODO: Find out if you can do a check for internet connectivity.
	 */
	public void testSearchShows()
	{
		TVMaze4J.LOGGER.info("Attempting to initialize client");
		ITVMazeClient client = new TVMazeClientImpl();
		assertNotNull(client);
	}
}
