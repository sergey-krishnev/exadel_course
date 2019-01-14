package hibernate.controller;

import hibernate.dto.SubjectDTO;
import hibernate.model.Subject;
import hibernate.model.Topic;
import hibernate.model.Users;
import hibernate.service.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    private int searchId;

    public Integer getSearchId() {
        return searchId;
    }

    public void setSearchId(Integer searchId) {
        this.searchId = searchId;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home() {
        return "index";
    }

//    @RequestMapping(value = "/newForm", method = RequestMethod.GET)
//    public String newForm(Locale locale) {
//        return "add";
//    }
//
//    @RequestMapping(value = "/editForm/{subjectId}",method = RequestMethod.GET)
//    public String editForm(@PathVariable("subjectId") int subjectId,Locale locale, Model model) {
//        setSearchId(subjectId);
//        List<Users> users = crudService.searchAllUsers();
//        model.addAttribute("users", users);
//        List<Topic> topics = crudService.searchAllTopic();
//        model.addAttribute("topics", topics);
//        Subject subject = crudService.searchBySubjectId(subjectId);
//        SubjectDTO subjectDto = new SubjectDTO();
//        subjectDto.setSubject(subject.getName());
//        subjectDto.setMessage(subject.getMessage());
//        subjectDto.setDate(subject.getFormattedDateSending());
//        model.addAttribute("subjectDTO", subjectDto);
//        return "update";
//    }
//
    @RequestMapping(value = "subjects/delete/{subjectId}", method = RequestMethod.POST)
    public String delete(@PathVariable("subjectId") int subjectId) {
        return "redirect:/";
    }
//
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String add(Locale locale,@ModelAttribute("subjectDTO") @Valid SubjectDTO subjectDto, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            List<Users> users = crudService.searchAllUsers();
//            model.addAttribute("users", users);
//            List<Topic> topics = crudService.searchAllTopic();
//            model.addAttribute("topics", topics);
//
//            return "add";
//        }
//        crudService.insertSubject(subjectDto);
//        return "redirect:/";
//    }
//
//    @RequestMapping(value = "/editForm/update", method = RequestMethod.POST)
//    public String update(Locale locale,@ModelAttribute("subjectDTO") @Valid SubjectDTO subjectDto, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            List<Users> users = crudService.searchAllUsers();
//            model.addAttribute("users", users);
//            List<Topic> topics = crudService.searchAllTopic();
//            model.addAttribute("topics", topics);
//            return "update";
//        }
//        Integer searchId = getSearchId();
//        crudService.updateSubjectById(searchId,subjectDto);
//        return "redirect:/";
//    }
}
