package lt.viko.eif.imazolevska.jaxws_client.wrap;

import lt.viko.eif.imazolevska.jaxws.client.Director;
import lt.viko.eif.imazolevska.jaxws_client.TestData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for {@link DirectorList}.
 */
class DirectorListTest {

    @Test
    void defaultConstructorCreatesEmptyList() {
        assertTrue(new DirectorList().getDirectors().isEmpty());
    }

    @Test
    void constructorStoresGivenDirectors() {
        DirectorList directorList = new DirectorList(List.of(TestData.nolan()));

        assertEquals(1, directorList.getDirectors().size());
        assertEquals("Nolan", directorList.getDirectors().get(0).getLastName());
    }

    @Test
    void constructorCopiesGivenList() {
        List<Director> directors = new ArrayList<>(List.of(TestData.nolan()));
        DirectorList directorList = new DirectorList(directors);

        directors.clear();

        assertEquals(1, directorList.getDirectors().size());
    }
}
