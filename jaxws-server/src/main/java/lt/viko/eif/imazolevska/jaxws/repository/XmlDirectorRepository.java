package lt.viko.eif.imazolevska.jaxws.repository;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lt.viko.eif.imazolevska.jaxws.model.Director;
import lt.viko.eif.imazolevska.jaxws.model.DirectorCatalog;
import org.springframework.stereotype.Repository;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * {@link DirectorRepository} implementation that reads directors from an XML file using JAXB.
 */

@Repository
public class XmlDirectorRepository implements DirectorRepository {

    private static final String XML_PATH = "src/main/resources/xml/directors.xml";

    @Override
    public List<Director> findAll() throws JAXBException {


        FileReader reader = null;
        try {
            reader = new FileReader(XML_PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        JAXBContext jaxbContext = JAXBContext.newInstance(DirectorCatalog.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();


        DirectorCatalog catalog = (DirectorCatalog) jaxbUnmarshaller.unmarshal(reader);
        return catalog.getDirectors();
    }
}

