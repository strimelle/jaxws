package lt.viko.eif.imazolevska.jaxws_client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @GetMapping("/directors.html")
    public String getHtml(@RequestParam(name = "genre", required = false) String genre){
         return "Main genre is: " + genre;
    }


    @GetMapping("/directors.pdf")
    public String getPdf(@RequestParam(name = "genre", required = false) String genre){
        return "Main genre is: " + genre;
    }

}
