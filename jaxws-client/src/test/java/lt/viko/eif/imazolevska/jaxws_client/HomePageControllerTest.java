package lt.viko.eif.imazolevska.jaxws_client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for {@link HomePageController}.
 */
class HomePageControllerTest {

    @Test
    void greetReturnsIndexTemplate() {
        HomePageController controller = new HomePageController();

        assertEquals("index", controller.greet());
    }
}
