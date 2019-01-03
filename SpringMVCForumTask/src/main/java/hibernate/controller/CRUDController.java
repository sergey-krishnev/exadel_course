package hibernate.controller;

import hibernate.dto.SubjectDTO;
import hibernate.model.Subject;
import hibernate.model.Topic;
import hibernate.model.Users;
import hibernate.service.interfaces.CRUDService;
import hibernate.validator.SubjectValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/")
public class CRUDController {

    private final static Logger LOGGER = Logger.getLogger(CRUDController.class);

    @Autowired
    private CRUDService crudService;

    @Autowired
    private SubjectValidator subjectValidator;

    private int searchId;

    public Integer getSearchId() {
        return searchId;
    }

    public void setSearchId(Integer searchId) {
        this.searchId = searchId;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(subjectValidator);
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(Model model) {
        List<Subject> subjects = crudService.searchAll();
        model.addAttribute("subjects", subjects);
        LOGGER.debug("home");
        return "index";
    }

    @RequestMapping(value = "/home", params = {"action=newForm"})
    public String newForm(Model model) {
        List<Users> users = crudService.searchAllUsers();
        model.addAttribute("users", users);
        List<Topic> topics = crudService.searchAllTopic();
        model.addAttribute("topics", topics);
        List<Subject> subjects = crudService.searchAll();
        model.addAttribute("subjects", subjects);
        return "update";
    }
//
    @RequestMapping(value = "/home",params = {"action=editForm"})
    public String editForm(@RequestParam("subjectId") int subjectId, Model model) {
        setSearchId(subjectId);
        List<Users> users = crudService.searchAllUsers();
        model.addAttribute("users", users);
        List<Topic> topics = crudService.searchAllTopic();
        model.addAttribute("topics", topics);
        Subject subject = crudService.searchBySubjectId(subjectId);
        model.addAttribute("subject", subject);
        return "update";
    }

    @RequestMapping(value = "/delete/{subjectId}")
    public String delete(@PathVariable("subjectId") int subjectId) {
        crudService.deleteSubjectById(subjectId);
        return "redirect:/home";
    }

    @RequestMapping(value = "/home",params = {"action=add"},method = RequestMethod.POST)
    public String add(@ModelAttribute("subjectDTO") @Validated SubjectDTO subjectDto) {
        crudService.insertSubject(subjectDto.getNickname(), subjectDto.getTopic(), subjectDto.getSubject(), subjectDto.getMessage(), stringAsDate(subjectDto.getDate()));
        return "redirect:/home";
    }

//    @RequestMapping(value = "/home",params = {"action=add"},method = RequestMethod.POST)
//    public String add(@RequestParam("nickname") String nickname,
//                      @RequestParam("topic") String topic, @RequestParam("subject") String subject, @RequestParam("message") String message, @RequestParam("date") String date) {
//        crudService.insertSubject(nickname, topic, subject, message, stringAsDate(date));
//        return "redirect:/home";
//    }

    @RequestMapping(value = "/home",params = {"action=update"}, method = RequestMethod.POST)
    public String update(@ModelAttribute("subjectDTO") SubjectDTO subjectDto) {
        Integer searchId = getSearchId();
        crudService.updateSubjectById(searchId,subjectDto.getNickname(), subjectDto.getTopic(), subjectDto.getSubject(), subjectDto.getMessage(), stringAsDate(subjectDto.getDate()));
        return "redirect:/home";
    }

//    @RequestMapping(value = "/home",params = {"action=update"}, method = RequestMethod.POST)
//    public String update(@RequestParam("nickname") String nickname,
//                         @RequestParam("topic") String topic, @RequestParam("subject") String subject, @RequestParam("message") String message, @RequestParam("date") String date,  Model model) {
//        Integer searchId = getSearchId();
//        crudService.updateSubjectById(searchId,nickname,
//                topic, subject, message,
//                stringAsDate(date));
//        return "redirect:/home";
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
