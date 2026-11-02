package lt.viko.eif.imazolevska.jaxws.repository;

import jakarta.xml.bind.JAXBException;
import lt.viko.eif.imazolevska.jaxws.model.Director;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for {@link XmlDirectorRepository}.
 */
class XmlDirectorRepositoryTest {

    @Test
    void findAllReturnsAllDirectorsFromXml() throws JAXBException {

        XmlDirectorRepository repository = new XmlDirectorRepository();
        List<Director> directorsList = repository.findAll();
        assertEquals(6, directorsList.size());
    }
}