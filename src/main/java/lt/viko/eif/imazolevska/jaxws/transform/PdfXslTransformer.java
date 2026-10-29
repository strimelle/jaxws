package lt.viko.eif.imazolevska.jaxws.transform;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.springframework.stereotype.Service;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

@Service
public class PdfXslTransformer implements XslTransformer {

    @Override
    public void transform(String xmlPath, String xslPath, String outputPath) throws Exception {

        new File(outputPath).getParentFile().mkdirs();

        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());

        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(outputPath))) {
            Fop fop = fopFactory.newFop("application/pdf", out);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(new File(xslPath)));

            transformer.transform(new StreamSource(new File(xmlPath)), new SAXResult(fop.getDefaultHandler()));

        }
    }
}
