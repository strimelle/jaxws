package lt.viko.eif.imazolevska.jaxws.transform;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for {@link HtmlXslTransformer}.
 */
class HtmlXslTransformerTest {

    @Test
    void transformCreatesHtmlFile() throws Exception {

        HtmlXslTransformer transformer = new HtmlXslTransformer();
        transformer.transform("src/main/resources/xml/directors.xml", "src/main/resources/xsl/directors-html.xsl", "target/test-output/directors.html");
        assertTrue(new File("target/test-output/directors.html").exists());


    }
}