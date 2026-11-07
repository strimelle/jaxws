package lt.viko.eif.imazolevska.jaxws_client.controller;

import lt.viko.eif.imazolevska.jaxws.client.DirectorService;
import lt.viko.eif.imazolevska.jaxws_client.transform.HtmlXslTransformer;
import lt.viko.eif.imazolevska.jaxws_client.transform.PdfXslTransformer;
import lt.viko.eif.imazolevska.jaxws_client.transform.XmlTransformer;
import lt.viko.eif.imazolevska.jaxws_client.transform.XslTransformer;
import lt.viko.eif.imazolevska.jaxws_client.wrap.DirectorList;
import lt.viko.eif.imazolevska.jaxws_client.wrap.MovieList;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
public class RequestController {

    private final DirectorService directorSoapClient;

    public RequestController(DirectorService directorService) {
        this.directorSoapClient = directorService;
    }
    XmlTransformer xmlTransformer = new XmlTransformer();

    @GetMapping("/directors/{format}")
    public ResponseEntity<byte[]> directors(@PathVariable String format,
                                            @RequestParam(required = false) String genre) throws Exception {

        XslTransformer transformer = createTransformer(format);
        DirectorList directorList;

        if (genre == null) {
            directorList = new DirectorList(directorSoapClient.getAllDirectors());
        } else {
            directorList = new DirectorList(directorSoapClient.getDirectorsByGenre(genre));
        }


        String xml = xmlTransformer.transformToXML(directorList);

        if (format.equals("html")) {
            byte[] result = transformer.transform(xml, "src/main/resources/xsl/directors-html.xsl");
            return ResponseEntity.ok()
                    .contentType(new MediaType("text", "html", StandardCharsets.UTF_8))
                    .body(result);

        } else{

            byte[] result = transformer.transform(xml, "src/main/resources/xsl/directors-pdf.xsl");

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"director.pdf\"")
                    .body(result);


        }


    }

    @GetMapping("/director/{format}")
    public ResponseEntity<byte[]> director(@PathVariable String format,
                                           @RequestParam int id) throws Exception {

        XslTransformer transformer = createTransformer(format);
        DirectorList directorList;
        directorList = new DirectorList(List.of(directorSoapClient.getDirectorById(id)));

        String xml = xmlTransformer.transformToXML(directorList);

        if (format.equals("html")) {
            byte[] result = transformer.transform(xml, "src/main/resources/xsl/directors-html.xsl");
            return ResponseEntity.ok()
                    .contentType(new MediaType("text", "html", StandardCharsets.UTF_8))
                    .body(result);

        } else{

            byte[] result = transformer.transform(xml, "src/main/resources/xsl/directors-pdf.xsl");

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"director.pdf\"")
                    .body(result);
        }

    }

    @GetMapping("/movies/{format}")
    public ResponseEntity<byte[]> movies(@PathVariable String format,
                                         @RequestParam(required = false) Integer directorId) throws Exception {
        XslTransformer transformer = createTransformer(format);
        MovieList movieList;

        if (directorId == null) {
            movieList = new MovieList(directorSoapClient.getAllMovies());
        } else {
            movieList = new MovieList(directorSoapClient.getMoviesByDirectorId(directorId));
        }


        String xml = xmlTransformer.transformToXML(movieList);

        if (format.equals("html")) {
            byte[] result = transformer.transform(xml, "src/main/resources/xsl/movies-html.xsl");
            return ResponseEntity.ok()
                    .contentType(new MediaType("text", "html", StandardCharsets.UTF_8))
                    .body(result);

        } else{

            byte[] result = transformer.transform(xml, "src/main/resources/xsl/movies-pdf.xsl");

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"movies.pdf\"")
                    .body(result);
        }
    }

    private XslTransformer createTransformer(String format) {
        XslTransformer transformer;
        switch (format) {
            case "html":
                transformer = new HtmlXslTransformer();

                break;
            case "pdf":
                transformer = new PdfXslTransformer();
                break;
            default:
                transformer = new HtmlXslTransformer();
                break;
        }
        return transformer;
    }


}


