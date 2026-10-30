package lt.viko.eif.imazolevska.jaxws.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement (name = "directors")
@XmlAccessorType(XmlAccessType.FIELD)
public class DirectorCatalog {
    @XmlElement(name="director")
    private List<Director> directors = new ArrayList<>();

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }
}
