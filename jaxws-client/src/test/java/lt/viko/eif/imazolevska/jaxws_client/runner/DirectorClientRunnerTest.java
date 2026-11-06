package lt.viko.eif.imazolevska.jaxws_client.runner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Tests for {@link SoapConnectionCheckRunner}.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class DirectorClientRunnerTest {

    @Autowired
    private SoapConnectionCheckRunner runner;

    @Test
    void runCallsWebServiceWithoutErrors() {
        assertDoesNotThrow(() -> runner.run());
    }
}