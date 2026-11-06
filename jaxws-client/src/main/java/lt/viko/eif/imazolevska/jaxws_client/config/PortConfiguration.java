package lt.viko.eif.imazolevska.jaxws_client.config;

import jakarta.xml.ws.BindingProvider;
import lt.viko.eif.imazolevska.jaxws.client.DirectorService;
import lt.viko.eif.imazolevska.jaxws.client.DirectorServiceImplService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class PortConfiguration {

        @Bean
        public DirectorService directorSoapClient(@Value("${directors.service.url}") String url) {
            DirectorService port = new DirectorServiceImplService().getDirectorServiceImplPort();
            ((BindingProvider) port).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
            return port;
        }

}
