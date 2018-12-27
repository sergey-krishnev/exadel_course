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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/")
public class CRUDController {

    private final static Logger LOGGER = Logger.getLogger(CRUDController.class);

    @Autowired
    private CRUDService crudService;

    private int searchId;

    public Integer getSearchId() {
        return searchId;
    }

    public void setSearchId(Integer searchId) {
        this.searchId = searchId;
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(Model model) {
        List<Subject> searchAll = crudService.searchAll();
        model.addAttribute("searchAll", searchAll);
        LOGGER.debug("home");
        return "index";
    }

    @RequestMapping(value = "/home", params = {"action=newForm"})
    public String newForm(Model model) {
        List<Users> users = crudService.searchAllUsers();
        model.addAttribute("users", users);
        List<Topic> topics = crudService.searchAllTopic();
        model.addAttribute("topics", topics);
        LOGGER.debug("showAllUsers()");
        model.addAttribute("searchAll", crudService.searchAll());
        return "update";
    }
//
//    @RequestMapping(value = "/ActionServlet?action=editForm", method = RequestMethod.GET)
//    public String editForm(@RequestParam("subjectId") int subjectId, Model model) {
//
//        List<Users> users = crudService.searchAllUsers();
//        model.addAttribute("users", users);
//        List<Topic> topics = crudService.searchAllTopic();
//        model.addAttribute("topics", topics);
//        Subject subject = crudService.searchBySubjectId(subjectId);
//        model.addAttribute("subject", subject);
//        return "forward:update";
//    }
//
    @RequestMapping(value = "/delete/{subjectId}")
    public String delete(@PathVariable("subjectId") int subjectId) {
        crudService.deleteSubjectById(subjectId);
        return "redirect:/home";
    }
//
    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String add(@RequestParam("nickname") String nickname,
                      @RequestParam("topic") String topic, @RequestParam("subject") String subject, @RequestParam("message") String message, @RequestParam("date") String date,  Model model) {
        crudService.insertSubject(nickname, topic, subject, message, stringAsDate(date));
        return "redirect:/home";
    }
//
//    @RequestMapping(value = "/ActionServlet", method = RequestMethod.GET)
//    public String update(@RequestParam("nickname") String nickname,
//                         @RequestParam("topic") String topic, @RequestParam("subject") String subject, @RequestParam("message") String message, @RequestParam("date") String date,  Model model) {
//        Integer searchId = getSearchId();
//        crudService.updateSubjectById(searchId,nickname,
//                topic, subject, message,
//                stringAsDate(date));
//        return "redirect:/MainServlet";
//    }

    private static java.sql.Date stringAsDate(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new java.sql.Date(date.getTime());
    }
}
