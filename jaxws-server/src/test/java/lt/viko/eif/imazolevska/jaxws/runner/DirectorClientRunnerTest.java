package lt.viko.eif.imazolevska.jaxws.runner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Tests for {@link DirectorClientRunner}.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class DirectorClientRunnerTest {

    @Autowired
    private DirectorClientRunner runner;

    @Test
    void runCallsWebServiceWithoutErrors() {
        assertDoesNotThrow(() -> runner.run());
    }
}