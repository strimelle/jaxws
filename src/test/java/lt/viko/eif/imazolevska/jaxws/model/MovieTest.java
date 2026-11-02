package lt.viko.eif.imazolevska.jaxws.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for {@link Movie}.
 */
class MovieTest {

    @Test
    void settersStoreValues() {
        Movie movie = new Movie();

        movie.setTitle("Inception");
        movie.setReleaseYear(2010);
        movie.setRating(8.8f);

        assertEquals("Inception", movie.getTitle());
        assertEquals(2010, movie.getReleaseYear());
        assertEquals(8.8f, movie.getRating());
    }
}