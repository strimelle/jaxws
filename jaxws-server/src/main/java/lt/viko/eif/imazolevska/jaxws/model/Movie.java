package lt.viko.eif.imazolevska.jaxws.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

/**
 * Represents a movie made by a director. Mapped to the {@code <movie>} element.
 */
@Entity
@Table(name = "movie")
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "release-year")
    private int releaseYear;

    @XmlElement(name = "rating")
    private float rating;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
