package lt.viko.eif.imazolevska.jaxws_client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

    @RequestMapping("/")
    public String greet(){return "index";}
}
