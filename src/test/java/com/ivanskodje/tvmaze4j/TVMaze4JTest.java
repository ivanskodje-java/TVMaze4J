package com.ivanskodje.tvmaze4j;

import com.ivanskodje.tvmaze4j.api.ClientBuilder;
import com.ivanskodje.tvmaze4j.api.TVMazeClient;
import com.ivanskodje.tvmaze4j.model.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.time.LocalDate;
import java.util.List;

public class TVMaze4JTest extends TestCase {

  public TVMaze4JTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    return new TestSuite(TVMaze4JTest.class);
  }

  public void testAllAPIs() {
    ClientBuilder builder = new ClientBuilder();
    TVMazeClient client = builder.build();

    Show showImpl1 = client.showSingleSearch("silicon valley", true);
    System.out.println(showImpl1.getEpisodes());

    Show showImpl2 = client.showLookUpFromTvRage(24493); // Game of Thrones has TVRage ID 24493
    System.out.println(showImpl2);

    Show showImpl3 = client.showLookUpFromTheTvDb(81189); // Breaking Bad has TheTVDB ID 81189
    System.out.println(showImpl3);

    Show showImpl4 =
        client.showLookUpFromImdb("tt0944947"); // Game of Thrones has IMDB ID tt0944947
    System.out.println(showImpl4);

    Show showImpl5 = client.showInfo(143); // Silicon Valley has TVMaze ID 143
    System.out.println(showImpl5);

    List<Episode> episodes1 =
        client.showEpisodeList(143); // List of episodes from Silicon Valley (TVmaze ID 143)
    System.out.println(episodes1);

    Episode episode1 = client.episodeByNumber(143, 1, 4); // showid, season, number
    System.out.println(episode1);

    List<Episode> episodes2 =
        client.episodesByDate(1, LocalDate.parse("2013-07-01")); // showid, date (yyyy-mm-dd)
    System.out.println(episodes2);
  }

  public void testSearchShows() {
    TVMaze4J.LOGGER.info("Attempting to search for showImpls, using the query 'silicon valley'...");
    TVMazeClient client = new ClientBuilder().build();

    List<Show> showImpls = client.showSearch("silicon valley");
    showImpls.stream().forEach(s -> TVMaze4J.LOGGER.info("Search Result: " + s));

    if (showImpls.size() > 0 && showImpls.get(0).getClass().getSimpleName().equals("Show")) {
      TVMaze4J.LOGGER.info("Successfully received " + showImpls.size() + " showImpls.");
    } else {
      fail("Did not receive any search results.");
    }

    TVMaze4J.LOGGER.info("Searching for Shows");
    List<Show> manyShows1 = client.showSearch("girls");
    manyShows1.stream()
        .forEach(
            s -> {
              System.out.println("-----------------------------------------");
              checkShow(s);
            });

    TVMaze4J.LOGGER.info("Searching for Shows with episodes");
    List<Show> manyShows2 = client.showSearch("silicon valley", true);
    manyShows2.stream()
        .forEach(
            s -> {
              System.out.println("-----------------------------------------");
              checkShow(s);
            });

    TVMaze4J.LOGGER.info("Searching for Shows with episodes and specials");
    List<Show> manyShows3 = client.showSearch("Game of Thrones", true, true);
    manyShows3.stream()
        .forEach(
            s -> {
              System.out.println("-----------------------------------------");
              checkShow(s);
            });

    TVMaze4J.LOGGER.info("Searching for Shows with episodes and specials");
    Show showImpl1 = client.showSingleSearch("Silicon Valley");
    checkShow(showImpl1);

    TVMaze4J.LOGGER.info("Searching for Shows with episodes and specials");
    Show showImpl2 = client.showSingleSearch("Game of Thrones", true);
    checkShow(showImpl2);
  }

  public void testSchedules() {
    TVMaze4J.LOGGER.info("Attempting to test schedules...");
    TVMazeClient client = new ClientBuilder().build();

    TVMaze4J.LOGGER.info("Getting today's schedule");
    List<Episode> episodes1 = client.getSchedule();
    episodes1.stream().forEach(e -> checkEpisode(e));

    TVMaze4J.LOGGER.info("Getting today's schedule in Norway");
    List<Episode> episodes3 = client.getSchedule("No");
    episodes3.stream().forEach(e -> checkEpisode(e));

    TVMaze4J.LOGGER.info("Getting 30-09-2017's schedule");
    List<Episode> episodes2 = client.getSchedule(LocalDate.parse("2017-09-30"));
    episodes2.stream().forEach(e -> checkEpisode(e));

    TVMaze4J.LOGGER.info("Getting today's schedule in Norway");
    List<Episode> episodes4 = client.getSchedule("no", LocalDate.parse("2017-09-30"));
    episodes4.stream().forEach(e -> checkEpisode(e));

    TVMaze4J.LOGGER.info("Getting FULL schedule");
    List<Episode> episodes5 = client.getFullSchedule();
    episodes5.stream().forEach(e -> checkEpisode(e));
  }

  public void testSeasons() {
    TVMazeClient client = new ClientBuilder().build();

    TVMaze4J.LOGGER.info("Attempting to get all seasons in Silicon Valley (ID: 143)...");
    List<Season> seasons1 = client.getSeasons(143);
    seasons1.stream().forEach(s -> System.out.println(s));
  }

  public void testGetEpisodesFromSameSeasonAsGivenEpisodeId() {
    TVMazeClient client = new ClientBuilder().build();

    TVMaze4J.LOGGER.info("Attempting to get all episodes belonging in the same season... ");
    List<Episode> episodes = client.episodesBySeason(661); // 661: Silicon Valley, Season 1's ID.
    episodes.stream().forEach(e -> System.out.println(e));
  }

  public void testPeopleSearch() {
    TVMazeClient client = new ClientBuilder().build();

    TVMaze4J.LOGGER.info(
        "Attempting to get a bunch of matching People, using the search query: 'L'.");
    List<Person> people = client.peopleSearch("L");
    people.stream().forEach(p -> checkPerson(p));
  }

  private void checkPerson(Person person) {
    TVMaze4J.LOGGER.info("Person: " + person);
    if (person != null) {
      TVMaze4J.LOGGER.info("Person->getId: " + person.getId());
      TVMaze4J.LOGGER.info("Person->getUrl: " + person.getUrl());
      TVMaze4J.LOGGER.info("Person->getName: " + person.getName());
      checkImages(person.getImages());
      checkLinks(person.getLinks());
    }
  }

  private void checkLinks(Links links) {
    TVMaze4J.LOGGER.info("Links: " + links);
    if (links != null) {
      TVMaze4J.LOGGER.info("Links->getSelf: " + links.getSelf());
      TVMaze4J.LOGGER.info("Links->getPreviousEpisode: " + links.getPreviousEpisode());
      TVMaze4J.LOGGER.info("Links->getNextEpisode: " + links.getNextEpisode());
    }
  }

  private void checkImages(Images images) {
    TVMaze4J.LOGGER.info("Images: " + images);
    if (images != null) {
      TVMaze4J.LOGGER.info("Images->getMedium: " + images.getMedium());
      TVMaze4J.LOGGER.info("Images->getOriginal: " + images.getOriginal());
    }
  }

  public void testCastMembers() {
    TVMazeClient client = new ClientBuilder().build();

    TVMaze4J.LOGGER.info("Attempting to get a bunch of Cast Members from Silicon Valley");
    Show show = client.showInfo(143, true);
    checkShow(show);
  }

  private void checkCast(Cast cast) {
    TVMaze4J.LOGGER.info("Cast: " + cast);
    if (cast != null) {
      TVMaze4J.LOGGER.info("Cast->getActor: " + cast.getActor());
      TVMaze4J.LOGGER.info("Cast->getCharacter: " + cast.getCharacter());
    }
  }

  private void checkEpisode(Episode episode) {
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
    if (show != null) {
      checkShow(show);
    }
  }

  private void checkShow(Show showImpl) {
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
    if (rating != null) {
      TVMaze4J.LOGGER.info("rating->getAverage: " + rating.getAverage());
    }

    TVMaze4J.LOGGER.info("WEIGHT: " + showImpl.getWeight());

    Network network = showImpl.getNetwork();
    TVMaze4J.LOGGER.info("NETWORK: " + network);
    if (network != null) {
      TVMaze4J.LOGGER.info("network->getId: " + network.getId());
      TVMaze4J.LOGGER.info("network->getName: " + network.getName());
      TVMaze4J.LOGGER.info("network->getCountry: " + network.getCountry());
      if (network.getCountry() != null) {
        TVMaze4J.LOGGER.info("network->getCountry->getCode: " + network.getCountry().getCode());
        TVMaze4J.LOGGER.info("network->getCountry->getName: " + network.getCountry().getName());
        TVMaze4J.LOGGER.info(
            "network->getCountry->getTimeZone: " + network.getCountry().getTimeZone());
      }
    }

    WebChannel webChannel = showImpl.getWebChannel();
    TVMaze4J.LOGGER.info("WEB CHANNEL: " + webChannel);
    if (webChannel != null) {
      TVMaze4J.LOGGER.info("webChannel->getId: " + webChannel.getId());
      TVMaze4J.LOGGER.info("webChannel->getName: " + webChannel.getName());
      TVMaze4J.LOGGER.info("webChannel->getCountry: " + webChannel.getCountry());
      if (webChannel.getCountry() != null) {
        TVMaze4J.LOGGER.info(
            "webChannel->getCountry->getCode: " + webChannel.getCountry().getCode());
        TVMaze4J.LOGGER.info(
            "webChannel->getCountry->getName: " + webChannel.getCountry().getName());
        TVMaze4J.LOGGER.info(
            "webChannel->getCountry->getTimeZone: " + webChannel.getCountry().getTimeZone());
      }
    }

    TVMaze4J.LOGGER.info("EXTERNALS: " + showImpl.getExternals());
    TVMaze4J.LOGGER.info("IMAGES: " + showImpl.getImages());
    TVMaze4J.LOGGER.info("SUMMARY: " + showImpl.getSummary());
    TVMaze4J.LOGGER.info("UPDATED: " + showImpl.getUpdated());
    TVMaze4J.LOGGER.info("LINKS: " + showImpl.getLinks());
    Embedded embedded = showImpl.getEmbedded();
    TVMaze4J.LOGGER.info("EMBEDDED: " + embedded);
    if (embedded != null) {
      if (embedded.getShow() != null) {
        checkShow(embedded.getShow());
      }
      if (embedded.getEpisodes() != null) {
        embedded.getEpisodes().stream().forEach(e -> checkEpisode(e));
      }
      if (embedded.getCastMembers() != null) {
        embedded.getCastMembers().stream().forEach(c -> checkCast(c));
      }
    }

    List<Episode> episodes = showImpl.getEpisodes();
    TVMaze4J.LOGGER.info("EPISODES: " + episodes);
    if (episodes != null) {
      episodes.stream()
          .forEach(
              e -> {
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
