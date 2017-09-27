# TVMaze4J
## A Java Interface/Wrapper for TVMaze API
TVMaze4J is a Java interface/wrapper for the official TVMaze API. It is written with Java 8. 
You can find the official information about TVMaze's API [here](http://www.tvmaze.com/api).


## Project Status: Usable

Some work remains, such as implementing all the different ways you can get Cast members. The same goes for AKAs (names in different languages), indexing, crew and credits. We also need to handle 404 errors and 429 errors, that may happen when you request too many times in a short amount of time.

Contributions are welcome, as I only work on this as a hobby project from time to time.

-- Ivan Skodje


## Examples of use

### Searching for a single show

```
		/* Create a TVMaze Client */
		TVMazeClient client = new ClientBuilder().build();

		/* Search for a single show */
		Show show = client.showSingleSearch("silicon valley");

		/* Print show name */
		System.out.println(show);
```
		
#### Output

```
Silicon Valley
```

### Getting a list of shows with all episodes

```
		/* Create a TVMaze Client */
		TVMazeClient client = new ClientBuilder().build();

		/* Search for a single show */
		List<Show> shows = client.showSearch("silicon valley", true);

		/* Print show name,and episode names */
		shows.stream().forEach(show ->
		{
			System.out.println(">>> " + show);
			for(Episode episode : show.getEpisodes())
			{
				System.out.println(episode);
			}
		});
```
		
#### Output

```
>>> Silicon Valley
S01E01: Minimum Viable Product
S01E02: The Cap Table
S01E03: Articles of Incorporation
S01E04: Fiduciary Duties
S01E05: Signaling Risk
S01E06: Third Party Insourcing
S01E07: Proof of Concept
S01E08: Optimal Tip-to-Tip Efficiency
S02E01: Sand Hill Shuffle
S02E02: Runaway Devaluation
S02E03: Bad Money
S02E04: The Lady
S02E05: Server Space
S02E06: Homicide
S02E07: Adult Content
S02E08: White Hat/Black Hat
S02E09: Binding Arbitration
S02E10: Two Days of the Condor
S03E01: Founder Friendly
S03E02: Two in the Box
S03E03: Meinertzhagen's Haversack
S03E04: Maleant Data Systems Solutions
S03E05: The Empty Chair
S03E06: Bachmanity Insanity
S03E07: To Build a Better Beta
S03E08: Bachman's Earning's Over-ride
S03E09: Daily Active Users
S03E10: The Uptick
S04E01: Success Failure
S04E02: Terms of Service
S04E03: Intellectual Property
S04E04: Teambuilding Exercise
S04E05: The Blood Boy
S04E06: Customer Service
S04E07: The Patent Troll
S04E08: The Keenan Vortex
S04E09: Hooli-Con
S04E10: Server Error
>>> Start-ups: Silicon Valley
S01E01: Starting Up
S01E02: Awkward
S01E03: Connect/Disconnect
S01E04: Restart
S01E05: Breaking the Code
S01E06: Last Pitch Effort
S01E07: Face Time
S01E08: Unfinished Business
>>> Secrets of Silicon Valley
S01E01: The Disruptors
S01E02: The Persuasion Machine
```

## Maven Dependencies
```
		<!-- Testing -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>

        <!-- SLF4J Logging -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.24</version>
        </dependency>

        <!-- Logback -->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-core</artifactId>
            <version>1.2.3</version>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.2.3</version>
        </dependency>

        <!-- Apache HTTP -->
        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpclient</artifactId>
            <version>4.5.3</version>
        </dependency>

        <!-- YAJM -->
        <dependency>
            <groupId>org.yamj</groupId>
            <artifactId>api-common</artifactId>
            <version>2.1</version>
        </dependency>

        <!-- Json/Gson -->
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.1</version>
        </dependency>
```

-------

## Client Functionality
### Show Search
```
	/**
	 * Gets a list of shows matching the query.
	 * <p>
	 * This is the equivalent of <code>showSearch(query, false)</code>,
	 * and  <code>showSearch(query, false, false)</code>
	 *
	 * @param query Search query.
	 * @return A list of Shows matching the query.
	 */
	List<Show> showSearch(String query);
```
### Show Search with Episodes
```
	/**
	 * Gets a list of shows matching the query.
	 * <p>
	 * This is the equivalent of <code>showSearch(query, fetchEpisodes, false)</code>,
	 *
	 * @param query         Search query.
	 * @param fetchEpisodes Whether or not we want to fetch all episodes with the shows.
	 * @return A list of Shows matching the query, with all episodes.
	 */
	List<Show> showSearch(String query, boolean fetchEpisodes);
```
### Show Search with Episodes and Specials
```
	/**
	 * Gets a list of shows matching the query.
	 * <p>
	 * Note: If fetchEpisodes is false, fetch special won't do anything.
	 *
	 * @param query         Search query.
	 * @param fetchEpisodes Whether or not we want to fetch all episodes with the shows.
	 * @param fetchSpecials Whether or not to get specials together with episodes
	 * @return A list of {@link Show}s matching the query, with all {@link Episode}s + specials.
	 */
	List<Show> showSearch(String query, boolean fetchEpisodes, boolean fetchSpecials);
```

### Show Single Search
```
	/**
	 * Gets a list of shows matching the query.
	 * <p>
	 * This is the equivalent of <code>showSingleSearch(query, false)</code>
	 *
	 * @param query Search query.
	 * @return A list of {@link Show}s matching the query.
	 */
	Show showSingleSearch(String query);
```
### Show Single Search with Episodes
```
	/**
	 * Gets a list of shows matching the search query.
	 *
	 * @param query         Search query.
	 * @param fetchEpisodes Whether or not you want episodes included with the shows.
	 * @return A list of {@link Show}s matching the query.
	 */
	Show showSingleSearch(String query, boolean fetchEpisodes);
```
### People Search
```
	/**
	 * Gets a list of people matching the search query.
	 *
	 * @param query Search query.
	 * @return A list of {@link Person} matching the query.
	 */
	List<Person> peopleSearch(String query);
```
###Show Episode List
```
	/**
	 * Gets a list of Episodes belonging to the Show matching the TVMaze ID.
	 * <p>
	 * This is the equivalent of <code>showEpisodeList(id, false)</code>
	 *
	 * @param showId TVMaze Show ID.
	 * @return A list of Episodes matching the Show ID.
	 */
	List<Episode> showEpisodeList(int showId);
```
### Show Episode List with Specials
```
	/**
	 * Gets a list of Episodes belonging to the Show matching the TVMaze ID.
	 *
	 * @param showId        TVMaze Show ID.
	 * @param fetchSpecials Whether or not to fetch the special episodes.
	 * @return A list of Episodes matching the Show ID - possibly with specials.
	 */
	List<Episode> showEpisodeList(int showId, boolean fetchSpecials);
```
### Episode by Number
```
	/**
	 * Get the matching episode from the Show ID, Season, and Episode number.
	 *
	 * @param showId TVMaze ID.
	 * @param season Season number.
	 * @param number Episode number.
	 * @return Episode.
	 */
	Episode episodeByNumber(int showId, int season, int number);
```
### Episodes by Date
```
	/**
	 * Get a list of episodes from the Show id, matching the given date.
	 *
	 * @param showId TVmaze ID.
	 * @param date   The specific date the episode aired.
	 * @return A list of matching episodes.
	 */
	List<Episode> episodesByDate(int showId, LocalDate date);
```
### Episodes by Season
```
	/**
	 * Get a list of episodes belonging to the given season ID.
	 *
	 * @param seasonId Season ID.
	 * @return A list of Episodes from the same season.
	 */
	List<Episode> episodesBySeason(int seasonId);
```
### Show Info
```
	/**
	 * Find the Show matching the TVMaze ID.
	 *
	 * @param showId Show ID.
	 * @return A {@link Show}.
	 */
	Show showInfo(int showId);
```
### Show Info with Cast
```
	/**
	 * Find the Show matching the TVMaze ID, with cast members embedded.
	 *
	 * @param showId    Show ID.
	 * @param fetchCast Whether or not to fetch the cast members.
	 * @return A {@link Show}.
	 */
	Show showInfo(int showId, boolean fetchCast);
```
### Show Lookup from TVRage
```
	/**
	 * Find the Show matching the TVRage ID.
	 *
	 * @param tvRageId TVRage ID
	 * @return Show
	 */
	Show showLookUpFromTvRage(int tvRageId);
```
### Show Lookup from TheTVDB
```
	/**
	 * Find the Show matching the TheTVDB ID.
	 *
	 * @param theTvdbId TheTVDB ID
	 * @return Show
	 */
	Show showLookUpFromTheTvDb(int theTvdbId);
```
### Show Lookup from IMDB
```
	/**
	 * Find the Show matching the IMDB ID.
	 *
	 * @param imdbId IMDB ID
	 * @return Show
	 */
	Show showLookUpFromImdb(String imdbId);
```
### Schedule
```
	/**
	 * Returns today's episode schedule.
	 * <p>
	 * This is the equivalent of <code>getSchedule(null)</code>
	 * and <code>getSchedule(null, null)</code>.
	 *
	 * @return List of today's {@link Episode} schedule.
	 */
	List<Episode> getSchedule();
```
### Schedule in Country
```
	/**
	 * Returns today's episode schedule in the given country,
	 * using ISO 3166-1 code formatting (https://en.wikipedia.org/wiki/ISO_3166-1).
	 * <p>
	 * This is the equivalent of <code>getSchedule(isoCountryCode, null)</code>.
	 *
	 * @return List of today's {@link Episode} schedule from the country.
	 */
	List<Episode> getSchedule(String isoCountryCode);
```
### Schedule on Date
```
	/**
	 * Returns the date's episode schedule.
	 * Date using ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601#Dates).
	 * <p>
	 * This is the equivalent of <code>getSchedule(null, date)</code>.
	 *
	 * @return List of the date's {@link Episode} schedule.
	 */
	List<Episode> getSchedule(LocalDate date);
```
### Schedule in Country on Date
```
	/**
	 * Returns the date's episode schedule in the given country.
	 * Country code using ISO 3166-1 (https://en.wikipedia.org/wiki/ISO_3166-1).
	 * Date using ISO 8601 (https://en.wikipedia.org/wiki/ISO_8601#Dates).
	 *
	 * @return List of the date's {@link Episode} schedule from the country.
	 */
	List<Episode> getSchedule(String isoCountryCode, LocalDate date);
```
### Full Schedule
```
	/**
	 * Returns the full schedule of all the oncoming registered TVMaze episodes.
	 *
	 * @return A list of all future {@link Episode} schedules.
	 */
	List<Episode> getFullSchedule();
```
### Show Seasons
```
	/**
	 * Returns a list of Show seasons for the given Show ID.
	 */
	List<Season> getSeasons(int showId);
```

----

## License
GPLv3 License

Copyright (C) 2017 Ivan P. Skodje

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

![GPLv3](http://www.gnu.org/graphics/gplv3-127x51.png)

