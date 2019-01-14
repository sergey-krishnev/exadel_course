package hibernate.controller;

import hibernate.dto.SubjectDTO;
import hibernate.dto.TopicDTO;
import hibernate.dto.UsersDTO;
import hibernate.model.Subject;
import hibernate.model.Topic;
import hibernate.model.Users;
import hibernate.service.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/")
public class RestCRUDController {

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

    //Get all subjects
    @RequestMapping(value = "/subjects",method = RequestMethod.GET, headers="Accept=application/json")
    public List<SubjectDTO> subjects() {
        return crudService.searchAll();
    }

//    @RequestMapping(value = "/users",method = RequestMethod.GET, headers="Accept=application/json")
//    public List<UsersDTO> users() {
//        return crudService.searchAllUsers();
//    }
//
//    @RequestMapping(value = "/topics",method = RequestMethod.GET, headers="Accept=application/json")
//    public List<TopicDTO> topic() {
//        return crudService.searchAllTopic();
//    }

//
//    //Get subject by id
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
//    //Delete subject by id
    @RequestMapping(value = "/subjects/delete/{subjectId}", headers="Accept=application/json")
    public void delete(@PathVariable("subjectId") int subjectId,Locale locale) {
        crudService.deleteSubjectById(subjectId);
    }
//
//    //Create subject
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String add(Locale locale,@ModelAttribute("subjectDTO") @Valid SubjectDTO subjectDto, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "add";
//        }
//        crudService.insertSubject(subjectDto);
//        return "redirect:/";
//    }
//
//    //Update subject
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
