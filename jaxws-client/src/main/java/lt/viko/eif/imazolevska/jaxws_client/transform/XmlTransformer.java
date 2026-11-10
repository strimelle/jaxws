package lt.viko.eif.imazolevska.jaxws_client.transform;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lt.viko.eif.imazolevska.jaxws_client.wrap.DataList;
import lt.viko.eif.imazolevska.jaxws_client.wrap.DirectorList;
import lt.viko.eif.imazolevska.jaxws_client.wrap.MovieList;

import java.io.StringWriter;

/**
 * Converts data wrapped in a {@link DataList} to an XML document using JAXB.
 */
public class XmlTransformer {

    /**
     * Writes the given data as a formatted XML document.
     *
     * @param dataList data to convert, e.g. {@link DirectorList} or {@link MovieList}
     * @return XML document as text
     * @throws JAXBException if the data cannot be converted to XML
     */
    public String transformToXML(DataList dataList) throws JAXBException {
        JAXBContext jaxbcontext = JAXBContext.newInstance(dataList.getClass());
        Marshaller jaxbMarshaller = jaxbcontext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter writer = new StringWriter();
        jaxbMarshaller.marshal(dataList, writer);
        return writer.toString();

    }
}
