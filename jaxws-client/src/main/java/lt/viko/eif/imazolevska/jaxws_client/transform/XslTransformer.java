package lt.viko.eif.imazolevska.jaxws_client.transform;

/**
 * Transforms an XML document to another format using an XSL stylesheet.
 */

public interface XslTransformer {

    byte[] transform(String xml, String xslPath) throws Exception;

}
