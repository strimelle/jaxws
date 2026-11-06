package lt.viko.eif.imazolevska.jaxws_client.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lt.viko.eif.imazolevska.jaxws.client.Director;

import java.util.ArrayList;
import java.util.List;

/**
 * Root element {@code <directors>} that wraps the directors received from the SOAP service,
 * so they can be written to an XML document and transformed with the XSL stylesheets.
 */
@XmlRootElement(name = "directors")
@XmlAccessorType(XmlAccessType.FIELD)
public class DirectorList {

    @XmlElement(name = "director")
    private List<Director> directors = new ArrayList<>();

    /**
     * Creates an empty list. Required by JAXB.
     */
    public DirectorList() {
    }

    /**
     * Creates a list with the given directors.
     *
     * @param directors directors to wrap
     */
    public DirectorList(List<Director> directors) {
        this.directors = new ArrayList<>(directors);
    }

    /**
     * Returns the wrapped directors.
     *
     * @return list of directors
     */
    public List<Director> getDirectors() {
        return directors;
    }
}