package lt.viko.eif.imazolevska.jaxws.service;

import jakarta.jws.WebService;
import jakarta.xml.bind.JAXBException;
import lt.viko.eif.imazolevska.jaxws.model.Director;
import lt.viko.eif.imazolevska.jaxws.repository.DirectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * {@link DirectorService} implementation that gets directors from {@link DirectorRepository}.
 */

@Service
@WebService(endpointInterface = "lt.viko.eif.imazolevska.jaxws.service.DirectorService")
public class DirectorServiceImpl implements DirectorService {
    private final DirectorRepository directorRepository;

    /**
     * Creates the service with the given repository.
     *
     * @param directorRepository repository that provides director data
     */

    public DirectorServiceImpl(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public List<Director> getAllDirectors() {
        try {
            return directorRepository.findAll();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Director getDirectorById(int id){
        List<Director> directors = getAllDirectors();

        for(Director director : directors){
            if(id == director.getId()){
                return director;
            }
        }
        return null;
    }
}
