package lt.viko.eif.imazolevska.jaxws_client.transform;

import org.springframework.stereotype.Service;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

/**
 * {@link XslTransformer} implementation that transforms XML to HTML.
 */

@Service
public class HtmlXslTransformer implements XslTransformer {


    @Override
    public byte[] transform(String xml, String xslPath) throws Exception {
        StringWriter result = new StringWriter();

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(xslPath));
        transformer.transform(new StreamSource(new StringReader(xml)), new StreamResult(result));

        return result.toString().getBytes(StandardCharsets.UTF_8);

    }


}
