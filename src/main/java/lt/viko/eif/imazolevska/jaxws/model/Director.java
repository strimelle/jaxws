package lt.viko.eif.imazolevska.jaxws.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Director {

    @XmlElement(name = "id")
    private int id;

    @XmlElement(name = "first-name")
    private String firstName;

    @XmlElement(name = "last-name")
    private String lastName;

    @XmlElement(name = "birth-year")
    private int birthYear;

    @XmlElement(name = "average-rating")
    private float averageRating;

    /**
     * Whether the director is currently active.
     */
    @XmlElement(name = "active")
    private boolean active;

    @XmlJavaTypeAdapter(CharAdapter.class)
    @XmlElement(name = "main-genre")
    private Character mainGenre;

    @XmlElementWrapper(name = "movies")
    @XmlElement(name = "movie")
    private List<Movie> movies = new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public Character getMainGenre() {
        return mainGenre;
    }

    public void setMainGenre(Character mainGenre) {
        this.mainGenre = mainGenre;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
