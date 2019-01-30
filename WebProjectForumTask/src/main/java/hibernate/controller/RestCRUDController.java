package hibernate.controller;

import hibernate.dto.CommentDTO;
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

    @RequestMapping(value = "/topics",method = RequestMethod.GET)
    public List<TopicDTO> getTopicsDTO() {
        return crudService.searchAllTopic();
    }

    @RequestMapping(value = "/topics/{topicId}", method = RequestMethod.GET)
    public TopicDTO getTopicDTO(@PathVariable int topicId) {
        return crudService.searchTopicById(topicId);
    }

    @RequestMapping(value = "/topics/{topicId}/subjects", method = RequestMethod.GET)
    public List<SubjectDTO> getSubjectsByTopicId(@PathVariable int topicId) {
        TopicDTO topicDTO = crudService.searchTopicById(topicId);
        return topicDTO.getSubjects();
    }

    @RequestMapping(value = "/topics/subjects", method = RequestMethod.GET)
    public List<SubjectDTO> getAllSubjectDTO() {
        return crudService.searchAllSubject();
    }

    @RequestMapping(value = "/subjects/{subjectId}", method = RequestMethod.GET)
    public SubjectDTO getSubjectDTO(@PathVariable int subjectId) {
        return crudService.searchSubjectById(subjectId);
    }

    @RequestMapping(value = "/subjects/{subjectId}/comments", method = RequestMethod.GET)
    public List<CommentDTO> getCommentsDTO(@PathVariable int subjectId) {
        SubjectDTO subjectDTO = crudService.searchSubjectById(subjectId);
        return subjectDTO.getComments();
    }

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public List<CommentDTO> getAllCommentDTO() {
        return crudService.searchAllComment();
    }
}