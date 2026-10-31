package lt.viko.eif.imazolevska.jaxws.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import lt.viko.eif.imazolevska.jaxws.model.Director;

import java.util.List;

@WebService
public interface DirectorService {

    @WebMethod
    List<Director> getAllDirectors();

    @WebMethod
    Director getDirectorById(int id);
}
