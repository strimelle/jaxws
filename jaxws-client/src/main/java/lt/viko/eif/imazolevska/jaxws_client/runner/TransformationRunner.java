package lt.viko.eif.imazolevska.jaxws_client.runner;

import lt.viko.eif.imazolevska.jaxws_client.transform.XslTransformer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;

/**
 * Generates HTML and PDF files from the directors XML on application startup.
 */


public class TransformationRunner implements CommandLineRunner {

    private final XslTransformer pdfTransformer;
    private final XslTransformer htmlTransformer;

    public TransformationRunner(@Qualifier("pdfXslTransformer") XslTransformer pdfTransformer, @Qualifier("htmlXslTransformer") XslTransformer htmlTransformer) {
        this.pdfTransformer = pdfTransformer;
        this.htmlTransformer = htmlTransformer;
    }

    /**
     * Transforms the directors XML to HTML and PDF.
     *
     * @param args command line arguments, not used
     * @throws Exception if a transformation fails
     */

    public void run(String... args) throws Exception {
        //   htmlTransformer.transform("src/main/resources/xsl/directors-html.xsl", "output/directors.html");
        //   pdfTransformer.transform("src/main/resources/xml/directors.xml", "src/main/resources/xsl/directors-pdf.xsl", "output/directors.pdf");


    }


}
