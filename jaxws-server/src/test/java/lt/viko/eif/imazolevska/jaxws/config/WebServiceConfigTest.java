package lt.viko.eif.imazolevska.jaxws.config;

import jakarta.xml.ws.Endpoint;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for {@link WebServiceConfig}.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class WebServiceConfigTest {

    @Autowired
    private Endpoint directorEndpoint;

    @Test
    void directorEndpointIsPublished() {
        assertTrue(directorEndpoint.isPublished());
    }
}