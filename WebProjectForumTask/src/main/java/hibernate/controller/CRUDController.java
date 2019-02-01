package hibernate.controller;

import hibernate.dto.SubjectDTO;
import hibernate.model.Subject;
import hibernate.model.Topic;
import hibernate.model.Users;
import hibernate.service.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class CRUDController {

    @Autowired
    private CRUDService crudService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home() {
        return "index2";
    }

    @RequestMapping(value = "/{topicId}", method = RequestMethod.GET)
    public String getSpecificTopic(@PathVariable int topicId) {
        crudService.searchTopicById(topicId); //create exception
        return "index2";
    }

    @RequestMapping(value = "/post/{subjectId}", method = RequestMethod.GET)
    public String getSpecificSubject(@PathVariable int subjectId) {
        crudService.searchSubjectById(subjectId);
        return "index3";
    }

    @RequestMapping(value = "/admin/comments", method = RequestMethod.GET)
    public String getAdminComments() {
        return "admin";
    }

    @RequestMapping(value = "/admin/subjects", method = RequestMethod.GET)
    public String getAdminSubjects() {
        return "admin";
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String getAdminUsers() {
        return "admin";
    }

    @RequestMapping(value = "/admin/topics", method = RequestMethod.GET)
    public String getAdminTopics() {
        return "admin";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

}