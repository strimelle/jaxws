package lt.viko.eif.imazolevska.jaxws.config;

import jakarta.xml.ws.Endpoint;
import lt.viko.eif.imazolevska.jaxws.service.DirectorService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Publishes the SOAP web service endpoints.
 */
@Configuration
public class WebServiceConfig {

    /**
     * Publishes the director service at {@code /services/directors}.
     *
     * @param bus             CXF bus created by Spring Boot
     * @param directorService service implementation to publish
     * @return published endpoint
     */

    @Bean
    public Endpoint directorEndpoint(Bus bus, DirectorService directorService) {
        EndpointImpl endpoint = new EndpointImpl(bus, directorService);
        endpoint.publish("/directors");
        return endpoint;
    }


}
