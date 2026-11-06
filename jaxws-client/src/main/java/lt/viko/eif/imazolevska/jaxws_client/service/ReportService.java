package lt.viko.eif.imazolevska.jaxws_client.service;

import lt.viko.eif.imazolevska.jaxws_client.runner.ClientRunner;
import lt.viko.eif.imazolevska.jaxws_client.xml.DirectorList;

import java.util.List;

public class ReportService {

    /*Iškvieti SOAP klientą,*/
    ClientRunner runner = new ClientRunner();
    List<DirectorList> = runner.run();

   // rezultatą įdedi į DirectorList arba MovieList,
 //   paduodi marshaller’iui,
 //   tada transformeriui.
 //   Reikia tik sugalvoti, kaip pagal formatą (html/pdf) parinkti XSL failą ir transformerį. Tai paprastas if arba switch.
}
