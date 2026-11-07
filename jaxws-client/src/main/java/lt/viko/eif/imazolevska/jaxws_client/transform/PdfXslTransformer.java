package lt.viko.eif.imazolevska.jaxws_client.transform;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.stereotype.Service;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * {@link XslTransformer} implementation that transforms XML to PDF
 * using an XSL-FO stylesheet and Apache FOP.
 */

@Service
public class PdfXslTransformer implements XslTransformer {

    private static final FopFactory FOP_FACTORY = FopFactory.newInstance(new File(".").toURI());

    public byte[] transform(String xml, String xslName) throws Exception {

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Fop fop = FOP_FACTORY.newFop(MimeConstants.MIME_PDF, out);

            Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(xslName));
            transformer.transform(new StreamSource(new StringReader(xml)), new SAXResult(fop.getDefaultHandler()));

            return out.toByteArray();

    }
}
