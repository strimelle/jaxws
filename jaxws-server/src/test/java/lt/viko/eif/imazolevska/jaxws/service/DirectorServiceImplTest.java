package lt.viko.eif.imazolevska.jaxws.service;

import lt.viko.eif.imazolevska.jaxws.model.Director;
import lt.viko.eif.imazolevska.jaxws.repository.DirectorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link DirectorServiceImpl}.
 */
@ExtendWith(MockitoExtension.class)
class DirectorServiceImplTest {

    @Mock
    DirectorRepository repository;

    @InjectMocks
    DirectorServiceImpl service;

    @Test
    void getDirectorByIdReturnsMatchingDirector() throws Exception {
        Director nolan = new Director();
        nolan.setId(1);
        nolan.setLastName("Nolan");
        Director spielberg = new Director();
        spielberg.setId(2);
        spielberg.setLastName("Spielberg");


        when(repository.findAll()).thenReturn(List.of(nolan, spielberg));

        Director director = service.getDirectorById(2);

        assertEquals("Spielberg", director.getLastName());
    }
}
