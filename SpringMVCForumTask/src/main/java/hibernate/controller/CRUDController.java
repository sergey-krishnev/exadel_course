package hibernate.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CRUDController extends MultiActionController {

    public ModelAndView home(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("home");
        model.addObject("message", "Home");
        return model;
    }

    public ModelAndView add(HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("subject");
        model.addObject("message", "Add");
        return model;
    }

    public ModelAndView remove(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("subject");
        model.addObject("message", "Remove");
        return model;
    }
}
