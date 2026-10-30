package lt.viko.eif.imazolevska.jaxws.repository;

import jakarta.jws.WebService;
import jakarta.xml.bind.JAXBException;
import lt.viko.eif.imazolevska.jaxws.model.Director;

import java.util.List;

public interface DirectorRepository {

    List<Director> findAll() throws JAXBException;

    //su vienu metodu „grąžink visus režisierius“
}
