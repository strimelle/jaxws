package lt.viko.eif.imazolevska.jaxws_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point of the client application. Starts Spring Boot, which serves the web page
 * and creates HTML and PDF reports from the data of the SOAP web service.
 */
@SpringBootApplication
public class JaxwsClientApplication {
    /**
     * Starts the client application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(JaxwsClientApplication.class, args);
    }

}
