package at.ac.fhcampuswien.fhmdb.controller;

import at.ac.fhcampuswien.fhmdb.controller.HomeController;
import at.ac.fhcampuswien.fhmdb.model.Genre;
import at.ac.fhcampuswien.fhmdb.model.Movie;
import at.ac.fhcampuswien.fhmdb.model.SortedState;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {
    private final HomeController controller = new HomeController();

    // Given
    private final List<Movie> movies = Arrays.asList(
            new Movie("1", "Movie1", Arrays.asList("Action", "Adventure"), 2021, "Test description", "http://test.com",
                    120, List.of("Director 1"), List.of("Writer 1"), Arrays.asList("Actor 1", "Actor 2"), 8.0),
            new Movie("2", "Movie2", List.of("Comedy"), 2022, "Test description", "http://test.com",
                    90, List.of("Director 2"), List.of("Writer 2"), List.of("Actor 1"), 7.5),
            new Movie("3", "Movie3_Part1", List.of("Drama"), 2020, "Test description", "http://test.com",
                    150, Arrays.asList("Director 1", "Director 2"), Arrays.asList("Writer 1", "Writer 2"), List.of("Actor 3"), 9.0)
    );

    @Test
    public void isGetMostPopularActor_Actor_1() {
        // When
        String actual = controller.getMostPopularActor(movies);

        // Then
        assertEquals("Actor 1", actual);
    }

    @Test
    public void isGetLongestMovieTitle_12() {
        // When
        int actual = controller.getLongestMovieTitle(movies);

        // Then
        assertEquals(12, actual);
    }

    @Test
    public void isCountMoviesFrom_director_2() {
        // When
        long actual = controller.countMoviesFrom(movies, "Director 1");

        // Then
        assertEquals(2, actual);
    }

    @Test
    public void isGetMoviesBetweenYears_size_2() {
        // When
        List<Movie> moviesBetweenYears = controller.getMoviesBetweenYears(movies, 2020, 2021);

        // Then
        assertEquals(2, moviesBetweenYears.size());
    }

    @Test
    public void isGetFirstMovieBetweenYears_contain_movie_0() {
        // When
        List<Movie> moviesBetweenYears = controller.getMoviesBetweenYears(movies, 2020, 2021);

        // Then
        assertTrue(moviesBetweenYears.contains(movies.get(0)));
    }

    @Test
    public void isGetFirstMovieBetweenYears_contain_movie_2() {
        // When
        List<Movie> moviesBetweenYears = controller.getMoviesBetweenYears(movies, 2020, 2021);

        // Then
        assertTrue(moviesBetweenYears.contains(movies.get(2)));
    }
}