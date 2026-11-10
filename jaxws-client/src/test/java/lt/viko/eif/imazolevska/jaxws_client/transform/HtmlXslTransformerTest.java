package lt.viko.eif.imazolevska.jaxws_client.transform;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for {@link HtmlXslTransformer}.
 */
class HtmlXslTransformerTest {

    private static final String DIRECTORS_XSL = "src/main/resources/xsl/directors-html.xsl";
    private static final String MOVIES_XSL = "src/main/resources/xsl/movies-html.xsl";

    private static final String DIRECTORS_XML = "<directors><director>"
            + "<id>1</id><first-name>Christopher</first-name><last-name>Nolan</last-name>"
            + "<birth-year>1970</birth-year><average-rating>8.6</average-rating>"
            + "<active>true</active><main-genre>S</main-genre>"
            + "<movies><movie><title>Memento</title><release-year>2000</release-year>"
            + "<rating>8.4</rating></movie></movies>"
            + "</director></directors>";

    private final HtmlXslTransformer transformer = new HtmlXslTransformer();

    @Test
    void transformCreatesHtmlTableWithDirectorData() throws Exception {
        String html = new String(transformer.transform(DIRECTORS_XML, DIRECTORS_XSL), StandardCharsets.UTF_8);

        assertTrue(html.contains("<table"));
        assertTrue(html.contains("Nolan"));
        assertTrue(html.contains("Memento"));
    }

    @Test
    void transformShowsMessageWhenThereAreNoMovies() throws Exception {
        String html = new String(transformer.transform("<movies/>", MOVIES_XSL), StandardCharsets.UTF_8);

        assertTrue(html.contains("No movies found."));
    }

    @Test
    void transformFailsForMissingStylesheet() {
        assertThrows(Exception.class,
                () -> transformer.transform(DIRECTORS_XML, "src/main/resources/xsl/missing.xsl"));
    }
}
