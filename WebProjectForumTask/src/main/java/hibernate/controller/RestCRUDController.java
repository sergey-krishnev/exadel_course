package hibernate.controller;

import hibernate.dto.SubjectDTO;
import hibernate.dto.TopicDTO;
import hibernate.dto.UsersDTO;
import hibernate.service.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    public ResponseEntity addSubjectDTO(@Valid @RequestBody SubjectDTO subjectDTO, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(ValidationErrorBuilder.fromBindingErrors(errors));
        }
        crudService.insertSubject(subjectDTO);
        return ResponseEntity.ok(subjectDTO);
    }

    //get subject by id
    @RequestMapping(value = "/subjects/{subjectId}",method = RequestMethod.GET)
    public SubjectDTO getSubjectDTOById(@PathVariable int subjectId) {
        return crudService.searchBySubjectId(subjectId);
    }

    //update subject
    @RequestMapping(value = "/subjects/{subjectId}", method = RequestMethod.PUT)
    public ResponseEntity updateSubjectDTO(@PathVariable("subjectId") int subjectId, @Valid @RequestBody SubjectDTO subjectDTO, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(ValidationErrorBuilder.fromBindingErrors(errors));
        }
        crudService.updateSubjectById(subjectId, subjectDTO);
        return ResponseEntity.ok(subjectDTO);
    }

    //delete subject by id
    @RequestMapping(value = "/subjects/{subjectId}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("subjectId") int subjectId) {
        crudService.deleteSubjectById(subjectId);
    }

}