package lt.viko.eif.imazolevska.jaxws.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import lt.viko.eif.imazolevska.jaxws.model.Director;

import java.util.List;

@WebService
public interface DirectorService {

    @WebMethod @WebResult(name = "director")
    List<Director> getAllDirectors();

    @WebMethod
    Director getDirectorById(@WebParam(name = "id")int id);
}
