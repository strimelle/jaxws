package lt.viko.eif.imazolevska.jaxws_client.runner;


import jakarta.xml.ws.WebServiceException;
import lt.viko.eif.imazolevska.jaxws.client.DirectorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SoapConnectionCheckRunner implements CommandLineRunner {

    private final DirectorService directorSoapClient;

    public SoapConnectionCheckRunner(DirectorService directorService) {
        this.directorSoapClient = directorService;
    }

    @Override
    public void run(String... args) {
        try {
            System.out.println("Directors received from SOAP service: "
                    + directorSoapClient.getAllDirectors().size());
        } catch (WebServiceException e) {
            System.out.println("SOAP service is not available: " + e.getMessage());
        }
    }
}