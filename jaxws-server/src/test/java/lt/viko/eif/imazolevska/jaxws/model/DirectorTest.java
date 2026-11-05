package lt.viko.eif.imazolevska.jaxws.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for {@link Director}.
 */
class DirectorTest {

    @Test
    void settersStoreValues() {
        Movie movie = new Movie();
        movie.setTitle("Inception");
        List<Movie> movies = new ArrayList<>();
        movies.add(movie);
        Director director = new Director();

        director.setId(1);
        director.setFirstName("Christopher");
        director.setLastName("Nolan");
        director.setBirthYear(1970);
        director.setAverageRating(8.6f);
        director.setActive(true);
        director.setMainGenre('S');
        director.setMovies(movies);

        assertEquals(1, director.getId());
        assertEquals("Christopher", director.getFirstName());
        assertEquals("Nolan", director.getLastName());
        assertEquals(1970, director.getBirthYear());
        assertEquals(8.6f, director.getAverageRating());
        assertTrue(director.isActive());
        assertEquals('S', director.getMainGenre());
        assertEquals("Inception", director.getMovies().get(0).getTitle());
    }
}