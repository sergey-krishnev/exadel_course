package hibernate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class IndexController {

    @RequestMapping(value = "/MainServlet/home", method = RequestMethod.GET)
    public String index(Model m) {
        m.addAttribute("someAttribute", "someValue");
        return "index";
    }
}
