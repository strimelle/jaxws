package lt.viko.eif.imazolevska.jaxws.transform;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for {@link PdfXslTransformer}.
 */
class PdfXslTransformerTest {

    @Test
    void transformCreatesPdfFile() throws Exception {

        PdfXslTransformer transformer = new PdfXslTransformer();
        transformer.transform("src/main/resources/xml/directors.xml", "src/main/resources/xsl/directors-pdf.xsl", "target/test-output/directors.pdf");
        assertTrue(new File("target/test-output/directors.pdf").exists());
    }
}