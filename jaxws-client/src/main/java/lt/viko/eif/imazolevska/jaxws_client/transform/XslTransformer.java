package lt.viko.eif.imazolevska.jaxws_client.transform;

/**
 * Transforms an XML document to another format using an XSL stylesheet.
 */

public interface XslTransformer {

    /**
     * Transforms the XML document with the given XSL stylesheet.
     *
     * @param xml     XML document as text
     * @param xslPath path to the XSL stylesheet
     * @return transformation result as bytes
     * @throws Exception if the stylesheet cannot be read or the transformation fails
     */
    byte[] transform(String xml, String xslPath) throws Exception;

}
