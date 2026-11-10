package lt.viko.eif.imazolevska.jaxws_client.controller;

import lt.viko.eif.imazolevska.jaxws.client.DirectorService;
import lt.viko.eif.imazolevska.jaxws_client.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit tests for {@link RequestController}. The SOAP client is replaced with a mock,
 * the XML marshalling and XSL transformations run for real.
 */
@ExtendWith(MockitoExtension.class)
class RequestControllerTest {

    @Mock
    private DirectorService directorSoapClient;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new RequestController(directorSoapClient)).build();
    }

    @Test
    void allDirectorsReturnsHtmlReport() throws Exception {
        when(directorSoapClient.getAllDirectors()).thenReturn(List.of(TestData.nolan()));

        mockMvc.perform(get("/directors/html"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(content().string(containsString("Nolan")));
    }

    @Test
    void directorsByGenreReturnsPdfReport() throws Exception {
        when(directorSoapClient.getDirectorsByGenre("S")).thenReturn(List.of(TestData.nolan()));

        mockMvc.perform(get("/directors/pdf").param("genre", "S"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_PDF));

        verify(directorSoapClient).getDirectorsByGenre("S");
    }

    @Test
    void oneDirectorReturnsHtmlReport() throws Exception {
        when(directorSoapClient.getDirectorById(1)).thenReturn(TestData.nolan());

        mockMvc.perform(get("/director/html").param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Christopher")));
    }

    @Test
    void oneDirectorReturnsPdfReport() throws Exception {
        when(directorSoapClient.getDirectorById(1)).thenReturn(TestData.nolan());

        mockMvc.perform(get("/director/pdf").param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_PDF));
    }

    @Test
    void allMoviesReturnsHtmlReport() throws Exception {
        when(directorSoapClient.getAllMovies()).thenReturn(List.of(TestData.memento()));

        mockMvc.perform(get("/movies/html"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(content().string(containsString("Memento")));
    }

    @Test
    void moviesOfDirectorReturnsPdfReport() throws Exception {
        when(directorSoapClient.getMoviesByDirectorId(1)).thenReturn(List.of(TestData.memento()));

        mockMvc.perform(get("/movies/pdf").param("directorId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_PDF));

        verify(directorSoapClient).getMoviesByDirectorId(1);
    }

    @Test
    @Disabled("Enable after RequestController handles a director that does not exist")
    void oneDirectorReturnsEmptyReportWhenDirectorIsNotFound() throws Exception {
        when(directorSoapClient.getDirectorById(99)).thenReturn(null);

        mockMvc.perform(get("/director/html").param("id", "99"))
                .andExpect(status().isOk());
    }

    @Test
    @Disabled("Enable after RequestController rejects unsupported formats")
    void unsupportedFormatReturnsBadRequest() throws Exception {
        mockMvc.perform(get("/directors/docx"))
                .andExpect(status().isBadRequest());
    }
}
