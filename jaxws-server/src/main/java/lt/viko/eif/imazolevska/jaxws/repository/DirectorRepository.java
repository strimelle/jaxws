package lt.viko.eif.imazolevska.jaxws.repository;

import jakarta.xml.bind.JAXBException;
import lt.viko.eif.imazolevska.jaxws.model.Director;

import java.util.List;

/**
 * Provides access to director data.
 */

public interface DirectorRepository {

    /**
     * Returns all directors.
     *
     * @return list of directors
     * @throws JAXBException if the data cannot be read
     */

    List<Director> findAll() throws JAXBException;
}
