package hibernate.controller;

import hibernate.model.Subject;
import hibernate.model.Topic;
import hibernate.model.Users;
import hibernate.service.interfaces.CRUDService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.jsp.Implementations.EditFormAction.setSubjectId;

@Controller
public class CRUDController {

    private final static Logger LOGGER = Logger.getLogger(CRUDController.class);

    @Autowired
    private CRUDService crudService;

    @RequestMapping(value = "MainServlet?action=home", method = RequestMethod.GET)
    public String home(Model model) {
        List<Subject> searchAll = crudService.searchAll();
        model.addAttribute("searchAll", searchAll);
        LOGGER.debug("home");
        return "index.jsp";
    }

    @RequestMapping(value = "ActionServlet?action=newForm", method = RequestMethod.GET)
    public String newForm(Model model) {
        List<Users> users = crudService.searchAllUsers();
        model.addAttribute("users", users);
        List<Topic> topics = crudService.searchAllTopic();
        model.addAttribute("topics", topics);
        LOGGER.debug("showAllUsers()");
        model.addAttribute("users", crudService.searchAll());
        return "update.jsp";
    }

    @RequestMapping(value = "ActionServlet?action=editForm", method = RequestMethod.GET)
    public String editForm(@PathVariable("subjectId") int subjectId, Model model) {
        List<Users> users = crudService.searchAllUsers();
        model.addAttribute("users", users);
        List<Topic> topics = crudService.searchAllTopic();
        model.addAttribute("topics", topics);
        Subject subject = crudService.searchBySubjectId(subjectId);
        model.addAttribute("subject", subject);
        return "update.jsp";
    }

    @RequestMapping(value = "ActionServlet?action=delete&subjectId={subjectId}", method = RequestMethod.GET)
    public String delete(@PathVariable("subjectId") int subjectId, Model model) {
        crudService.deleteSubjectById(subjectId);
        List<Subject> searchAll = crudService.searchAll();
        model.addAttribute("searchAll", searchAll);
        return "index.jsp";
    }

    @RequestMapping(value = "/ActionServlet?action=add&subjectId={subjectId}", method = RequestMethod.GET)
    public String add(@PathVariable("subjectId") int subjectId, @PathVariable("nickname") String nickname,
                      @PathVariable("topic") Model model) {
        crudService.insertSubject(request.getParameter("nickname"),
                request.getParameter("topic"), request.getParameter("subject"), request.getParameter("message"),
                stringAsDate(request.getParameter("date")));
    }
}
