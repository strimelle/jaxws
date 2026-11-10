package lt.viko.eif.imazolevska.jaxws_client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Shows the home page where the user chooses a report and its format.
 */
@Controller
public class HomePageController {

    /**
     * Returns the home page template.
     *
     * @return name of the Thymeleaf template {@code index}
     */
    @RequestMapping("/")
    public String greet() {
        return "index";
    }
}
