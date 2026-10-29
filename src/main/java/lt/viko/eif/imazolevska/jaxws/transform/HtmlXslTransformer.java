package lt.viko.eif.imazolevska.jaxws.transform;

import org.springframework.stereotype.Service;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

@Service //paduoti runneriui
public class HtmlXslTransformer implements XslTransformer{

    @Override
    public void transform(String xmlPath, String xslPath, String outputPath) throws Exception{

        new File(outputPath).getParentFile().mkdirs();

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(new File(xslPath)));
        transformer.transform(new StreamSource(new File(xmlPath)), new StreamResult(new File(outputPath)));

    }






}
