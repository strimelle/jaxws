package lt.viko.eif.imazolevska.jaxws_client.wrap;

import lt.viko.eif.imazolevska.jaxws.client.Movie;
import lt.viko.eif.imazolevska.jaxws_client.TestData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for {@link MovieList}.
 */
class MovieListTest {

    @Test
    void defaultConstructorCreatesEmptyList() {
        assertTrue(new MovieList().getMovies().isEmpty());
    }

    @Test
    void constructorStoresGivenMovies() {
        MovieList movieList = new MovieList(List.of(TestData.memento()));

        assertEquals(1, movieList.getMovies().size());
        assertEquals("Memento", movieList.getMovies().get(0).getTitle());
    }

    @Test
    void constructorCopiesGivenList() {
        List<Movie> movies = new ArrayList<>(List.of(TestData.memento()));
        MovieList movieList = new MovieList(movies);

        movies.clear();

        assertEquals(1, movieList.getMovies().size());
    }
}
