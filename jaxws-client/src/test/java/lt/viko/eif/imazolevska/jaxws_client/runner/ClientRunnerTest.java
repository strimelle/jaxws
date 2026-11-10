package lt.viko.eif.imazolevska.jaxws_client.runner;

import jakarta.xml.ws.WebServiceException;
import lt.viko.eif.imazolevska.jaxws.client.DirectorService;
import lt.viko.eif.imazolevska.jaxws_client.TestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link ClientRunner}.
 */
@ExtendWith(MockitoExtension.class)
class ClientRunnerTest {

    @Mock
    private DirectorService directorSoapClient;

    @Test
    void runCallsSoapService() {
        when(directorSoapClient.getAllDirectors()).thenReturn(List.of(TestData.nolan()));

        new ClientRunner(directorSoapClient).run();

        verify(directorSoapClient).getAllDirectors();
    }

    @Test
    void runDoesNotFailWhenSoapServiceIsUnavailable() {
        when(directorSoapClient.getAllDirectors()).thenThrow(new WebServiceException("Connection refused"));
        ClientRunner runner = new ClientRunner(directorSoapClient);

        assertDoesNotThrow(() -> runner.run());
    }
}
