package lt.viko.eif.imazolevska.jaxws.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for {@link DirectorCatalog}.
 */
class DirectorCatalogTest {

    @Test
    void setDirectorsStoresDirectors() {
        Director director = new Director();
        director.setLastName("Nolan");
        List<Director> directors = new ArrayList<>();
        directors.add(director);
        DirectorCatalog catalog = new DirectorCatalog();

        catalog.setDirectors(directors);

        assertEquals(1, catalog.getDirectors().size());
        assertEquals("Nolan", catalog.getDirectors().get(0).getLastName());
    }
}