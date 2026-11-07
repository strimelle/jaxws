package lt.viko.eif.imazolevska.jaxws_client.wrap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lt.viko.eif.imazolevska.jaxws.client.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Root element {@code <movies>} that wraps the movies received from the SOAP service,
 * so they can be written to an XML document and transformed with the XSL stylesheets.
 */
@XmlRootElement(name = "movies")
@XmlAccessorType(XmlAccessType.FIELD)
public class MovieList implements DataList {

    @XmlElement(name = "movie")
    private List<Movie> movies = new ArrayList<>();

    /**
     * Creates an empty list. Required by JAXB.
     */
    public MovieList() {
    }

    /**
     * Creates a list with the given movies.
     *
     * @param movies movies to wrap
     */
    public MovieList(List<Movie> movies) {
        this.movies = new ArrayList<>(movies);
    }

    /**
     * Returns the wrapped movies.
     *
     * @return list of movies
     */
    public List<Movie> getMovies() {
        return movies;
    }
}
