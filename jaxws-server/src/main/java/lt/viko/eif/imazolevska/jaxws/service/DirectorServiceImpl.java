package lt.viko.eif.imazolevska.jaxws.service;

import jakarta.jws.WebService;
import lt.viko.eif.imazolevska.jaxws.model.Director;
import lt.viko.eif.imazolevska.jaxws.model.Movie;
import lt.viko.eif.imazolevska.jaxws.repository.DirectorRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return directorRepository.findAll(Sort.by("id"));
    }

    @Override
    public Director getDirectorById(int id) {
        return directorRepository.findById(id).orElse(null);
    }


    @Override
    public List<Director> getDirectorsByGenre(String genre) {
        List<Director> result = new ArrayList<>();
        if (genre == null || genre.isEmpty()) {
            return result;
        }

        char genreCode = Character.toUpperCase(genre.charAt(0));
        return directorRepository.findByMainGenre(genreCode);
    }

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        for (Director director : getAllDirectors()) {
            movies.addAll(director.getMovies());
        }
        return movies;
    }

    @Override
    public List<Movie> getMoviesByDirectorId(int id) {
        Director director = getDirectorById(id);
        if (director == null) {
            return new ArrayList<>();
        }
        return director.getMovies();
    }
}
