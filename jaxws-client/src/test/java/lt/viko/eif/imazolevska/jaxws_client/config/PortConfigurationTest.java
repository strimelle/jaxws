package lt.viko.eif.imazolevska.jaxws_client.config;

import jakarta.xml.ws.BindingProvider;
import lt.viko.eif.imazolevska.jaxws.client.DirectorService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/**
 * Unit tests for {@link PortConfiguration}.
 */
class PortConfigurationTest {

    private static final String URL = "http://localhost:9999/services/directors";

    @Test
    void directorSoapClientUsesConfiguredEndpointAddress() {
        DirectorService client = new PortConfiguration().directorSoapClient(URL);

        BindingProvider bindingProvider = assertInstanceOf(BindingProvider.class, client);
        assertEquals(URL, bindingProvider.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY));
    }
}
