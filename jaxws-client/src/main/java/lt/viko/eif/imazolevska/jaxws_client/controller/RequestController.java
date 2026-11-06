package lt.viko.eif.imazolevska.jaxws_client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @GetMapping("/directors/{format}")
    public String directors(@PathVariable String format,
                            @RequestParam(required = false) String genre) {
        return "directors, format=" + format + ", genre=" + genre;
    }

    @GetMapping("/director/{format}")
    public String director(@PathVariable String format,
                           @RequestParam int id) {
        return "one director, format=" + format + ", id=" + id;
    }

    @GetMapping("/movies/{format}")
    public String movies(@PathVariable String format,
                         @RequestParam(required = false) Integer directorId) {
        return "movies, format=" + format + ", directorId=" + directorId;
    }

}
