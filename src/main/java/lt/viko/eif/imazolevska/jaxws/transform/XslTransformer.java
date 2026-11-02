package lt.viko.eif.imazolevska.jaxws.transform;

/**
 * Transforms an XML document to another format using an XSL stylesheet.
 */

public interface XslTransformer {

    /**
     * Transforms the XML file with the XSL stylesheet and writes the result to a file.
     *
     * @param xmlPath path to the XML file
     * @param xslPath path to the XSL stylesheet
     * @param outputPath path to the result file
     * @throws Exception if the transformation fails
     */

    void transform(String xmlPath, String xslPath, String outputPath) throws Exception;



}
