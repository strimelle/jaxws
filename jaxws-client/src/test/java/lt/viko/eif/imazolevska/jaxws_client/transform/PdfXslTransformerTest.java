package lt.viko.eif.imazolevska.jaxws_client.transform;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for {@link PdfXslTransformer}.
 */
class PdfXslTransformerTest {

    private static final String DIRECTORS_XSL = "src/main/resources/xsl/directors-pdf.xsl";
    private static final String MOVIES_XSL = "src/main/resources/xsl/movies-pdf.xsl";

    private static final String DIRECTORS_XML = "<directors><director>"
            + "<id>1</id><first-name>Christopher</first-name><last-name>Nolan</last-name>"
            + "<birth-year>1970</birth-year><average-rating>8.6</average-rating>"
            + "<active>true</active><main-genre>S</main-genre>"
            + "<movies><movie><title>Memento</title><release-year>2000</release-year>"
            + "<rating>8.4</rating></movie></movies>"
            + "</director></directors>";

    private final PdfXslTransformer transformer = new PdfXslTransformer();

    @Test
    void transformCreatesPdfDocumentForDirectors() throws Exception {
        byte[] pdf = transformer.transform(DIRECTORS_XML, DIRECTORS_XSL);

        assertEquals("%PDF", header(pdf));
    }

    @Test
    void transformCreatesPdfDocumentWhenThereAreNoMovies() throws Exception {
        byte[] pdf = transformer.transform("<movies/>", MOVIES_XSL);

        assertEquals("%PDF", header(pdf));
    }

    @Test
    void transformFailsForMissingStylesheet() {
        assertThrows(Exception.class,
                () -> transformer.transform(DIRECTORS_XML, "src/main/resources/xsl/missing.xsl"));
    }

    private static String header(byte[] pdf) {
        return new String(pdf, 0, 4, StandardCharsets.US_ASCII);
    }
}
