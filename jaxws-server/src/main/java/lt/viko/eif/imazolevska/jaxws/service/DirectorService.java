package lt.viko.eif.imazolevska.jaxws.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import lt.viko.eif.imazolevska.jaxws.model.Director;
import lt.viko.eif.imazolevska.jaxws.model.Movie;

import java.util.List;

/**
 * SOAP web service that provides information about directors and their movies.
 */

@WebService
public interface DirectorService {

    /**
     * Returns all directors.
     *
     * @return list of directors
     */

    @WebMethod
    @WebResult(name = "director")
    List<Director> getAllDirectors();

    /**
     * Returns the director with the given identifier.
     *
     * @param id director identifier
     * @return director, or {@code null} if not found
     */

    @WebMethod
    @WebResult(name = "director")
    Director getDirectorById(@WebParam(name = "id") int id);


    /**
     * Returns directors whose main genre matches the given genre code.
     *
     * @param genre genre code, e.g. "S" for sci-fi
     * @return list of matching directors, empty if none match
     */
    @WebMethod
    @WebResult(name = "director")
    List<Director> getDirectorsByGenre(@WebParam(name = "genre") String genre);

    /**
     * Returns the movies of all directors.
     *
     * @return list of movies
     */
    @WebMethod
    @WebResult(name = "movie")
    List<Movie> getAllMovies();

    /**
     * Returns the movies of the director with the given identifier.
     *
     * @param id director identifier
     * @return list of movies, empty if the director is not found
     */
    @WebMethod
    @WebResult(name = "movie")
    List<Movie> getMoviesByDirectorId(@WebParam(name = "id") int id);
}
