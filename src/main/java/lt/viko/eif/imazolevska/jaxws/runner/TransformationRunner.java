package lt.viko.eif.imazolevska.jaxws.runner;

import lt.viko.eif.imazolevska.jaxws.transform.XslTransformer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TransformationRunner implements CommandLineRunner {

    private final XslTransformer pdfTransformer;
    private final XslTransformer htmlTransformer;

    public TransformationRunner(@Qualifier("pdfXslTransformer") XslTransformer pdfTransformer, @Qualifier("htmlXslTransformer") XslTransformer htmlTransformer) {
        this.pdfTransformer = pdfTransformer;
        this.htmlTransformer = htmlTransformer;
    }


    public void run(String... args) throws Exception {
        htmlTransformer.transform("src/main/resources/xml/directors.xml", "src/main/resources/xsl/directors-html.xsl", "output/directors.html");
        pdfTransformer.transform("src/main/resources/xml/directors.xml", "src/main/resources/xsl/directors-pdf.xsl", "output/directors.pdf");


    }


}
