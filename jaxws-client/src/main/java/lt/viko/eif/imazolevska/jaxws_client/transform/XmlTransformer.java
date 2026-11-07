package lt.viko.eif.imazolevska.jaxws_client.transform;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lt.viko.eif.imazolevska.jaxws.client.Director;
import lt.viko.eif.imazolevska.jaxws_client.wrap.DataList;
import lt.viko.eif.imazolevska.jaxws_client.wrap.DirectorList;

import java.io.StringWriter;
import java.util.List;

public class XmlTransformer {

    public String transformToXML(DataList dataList) throws JAXBException {
        JAXBContext jaxbcontext = JAXBContext.newInstance(dataList.getClass());
        Marshaller jaxbMarshaller = jaxbcontext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter writer = new StringWriter();
        jaxbMarshaller.marshal(dataList, writer);
        return writer.toString();

    }
}
