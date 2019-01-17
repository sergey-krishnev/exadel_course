package hibernate.controller;

import hibernate.dto.SubjectDTO;
import hibernate.dto.TopicDTO;
import hibernate.dto.UsersDTO;
import hibernate.service.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class RestCRUDController {

    @Autowired
    private CRUDService crudService;

    @Autowired
    private MessageSource messageSource;

    //Get all subjects
    //headers="Accept=application/json"
    @RequestMapping(value = "/subjects",method = RequestMethod.GET)
    public List<SubjectDTO> getSubjectsDTO() {
        return crudService.searchAll();
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<UsersDTO> users() {
        return crudService.searchAllUsers();
    }

    @RequestMapping(value = "/topics",method = RequestMethod.GET)
    public List<TopicDTO> topic() {
        return crudService.searchAllTopic();
    }

    //add subject
    @RequestMapping(value = "/subjects",method = RequestMethod.POST)
    public void addSubjectDTO(@Valid @RequestBody SubjectDTO subjectDTO) {
        crudService.insertSubject(subjectDTO);
    }

    //get subject by id
    @RequestMapping(value = "/subjects/{subjectId}",method = RequestMethod.GET)
    public SubjectDTO getSubjectDTOById(@PathVariable int subjectId) {
        return crudService.searchBySubjectId(subjectId);
    }

    //update subject
    @RequestMapping(value = "/subjects/{subjectId}", method = RequestMethod.PUT)
    public void updateSubjectDTO(@Valid @RequestBody SubjectDTO subjectDTO, @PathVariable("subjectId") int subjectId) {
        crudService.updateSubjectById(subjectId, subjectDTO);
    }

    //delete subject by id
    @RequestMapping(value = "/subjects/{subjectId}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("subjectId") int subjectId) {
        crudService.deleteSubjectById(subjectId);
    }

}