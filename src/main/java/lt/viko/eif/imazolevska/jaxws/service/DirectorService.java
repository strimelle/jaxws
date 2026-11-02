package lt.viko.eif.imazolevska.jaxws.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import lt.viko.eif.imazolevska.jaxws.model.Director;

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

    @WebMethod @WebResult(name = "director")
    List<Director> getAllDirectors();

    /**
     * Returns the director with the given identifier.
     *
     * @param id director identifier
     * @return director, or {@code null} if not found
     */

    @WebMethod @WebResult(name = "director")
    Director getDirectorById(@WebParam(name = "id")int id);
}
