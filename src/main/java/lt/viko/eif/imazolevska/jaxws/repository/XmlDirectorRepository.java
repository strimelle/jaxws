package lt.viko.eif.imazolevska.jaxws.repository;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lt.viko.eif.imazolevska.jaxws.model.Director;
import lt.viko.eif.imazolevska.jaxws.model.DirectorCatalog;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
public class XmlDirectorRepository implements DirectorRepository {

    private static final String xmlPath = "resources/xml/directors.xml";

    @Override
    public List<Director> findAll() throws JAXBException {


        FileReader reader = null;
        try {
            reader = new FileReader(xmlPath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        JAXBContext jaxbContext = JAXBContext.newInstance(DirectorCatalog.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();


        DirectorCatalog catalog = (DirectorCatalog) jaxbUnmarshaller.unmarshal(reader);
        return catalog.getDirectors();
    }
}

