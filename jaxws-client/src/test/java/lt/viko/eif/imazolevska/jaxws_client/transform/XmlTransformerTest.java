package lt.viko.eif.imazolevska.jaxws_client.transform;

import lt.viko.eif.imazolevska.jaxws_client.TestData;
import lt.viko.eif.imazolevska.jaxws_client.wrap.DirectorList;
import lt.viko.eif.imazolevska.jaxws_client.wrap.MovieList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for {@link XmlTransformer}.
 */
class XmlTransformerTest {

    private final XmlTransformer xmlTransformer = new XmlTransformer();

    @Test
    void transformToXmlWritesDirectorsInXslFormat() throws Exception {
        String xml = xmlTransformer.transformToXML(new DirectorList(List.of(TestData.nolan())));

        assertTrue(xml.contains("<directors"));
        assertTrue(xml.contains("<director>"));
        assertTrue(xml.contains("<first-name>Christopher</first-name>"));
        assertTrue(xml.contains("<main-genre>S</main-genre>"));
        assertTrue(xml.contains("<title>Memento</title>"));
    }

    @Test
    void transformToXmlWritesMoviesInXslFormat() throws Exception {
        String xml = xmlTransformer.transformToXML(new MovieList(List.of(TestData.memento())));

        assertTrue(xml.contains("<movies"));
        assertTrue(xml.contains("<movie>"));
        assertTrue(xml.contains("<release-year>2000</release-year>"));
    }

    @Test
    void transformToXmlWritesEmptyRootForEmptyList() throws Exception {
        String xml = xmlTransformer.transformToXML(new DirectorList(List.of()));

        assertTrue(xml.contains("<directors"));
    }
}
