package lt.viko.eif.imazolevska.jaxws.repository;

import jakarta.xml.bind.JAXBException;
import lt.viko.eif.imazolevska.jaxws.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides access to director data.
 */
@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {
    List<Director> findByMainGenre(Character mainGenre);

}
