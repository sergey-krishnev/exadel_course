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
import org.springframework.security.access.annotation.Secured;
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

    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    public void addTopicDTO(@RequestBody TopicDTO topicDTO) {
        crudService.insertTopic(topicDTO);
    }

    @RequestMapping(value = "/topics/{topicId}", method = RequestMethod.PUT)
    public void updateTopicDTO(@RequestBody TopicDTO topicDTO, @PathVariable int topicId) {
        crudService.updateTopic(topicId,topicDTO);
    }

    @RequestMapping(value = "/topics/{topicId}", method = RequestMethod.DELETE)
    public void deleteTopicDTO(@PathVariable int topicId) {
        crudService.deleteTopic(topicId);
    }

    @RequestMapping(value = "/topics/{topicId}/subjects", method = RequestMethod.GET)
    public List<SubjectDTO> getSubjectsByTopicId(@PathVariable int topicId) {
        TopicDTO topicDTO = crudService.searchTopicById(topicId);
        return topicDTO.getSubjects();
    }

    @RequestMapping(value = "/subjects", method = RequestMethod.GET)
    public List<SubjectDTO> getAllSubjectDTO() {
        return crudService.searchAllSubject();
    }

    @RequestMapping(value = "/subjects/{subjectId}", method = RequestMethod.GET)
    public SubjectDTO getSubjectDTO(@PathVariable int subjectId) {
        return crudService.searchSubjectById(subjectId);
    }

    @RequestMapping(value = "/subjects", method = RequestMethod.POST)
    public void addSubjectDTO(@RequestBody SubjectDTO subjectDTO) { crudService.insertSubject(subjectDTO);}

    @RequestMapping(value = "/subjects/{subjectId}", method = RequestMethod.PUT)
    public void updateSubjectDTO(@RequestBody SubjectDTO subjectDTO, @PathVariable int subjectId) {
        crudService.updateSubject(subjectId, subjectDTO);
    }

    @RequestMapping(value = "/subjects/{subjectId}", method = RequestMethod.DELETE)
    public void deleteSubjectDTO(@PathVariable int subjectId) {
        crudService.deleteSubject(subjectId);
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

    @RequestMapping(value = "/comments/{commentId}", method = RequestMethod.GET)
    public CommentDTO getCommentDTO(@PathVariable int commentId) {
        return crudService.searchCommentById(commentId);
    }

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public void addCommentDTO(@RequestBody CommentDTO commentDTO) { crudService.insertComment(commentDTO);}

    @RequestMapping(value = "/comments/{commentId}", method = RequestMethod.PUT)
    public void updateCommentDTO(@RequestBody CommentDTO commentDTO, @PathVariable int commentId) {
        crudService.updateComment(commentId, commentDTO);
    }

    @RequestMapping(value = "/comments/{commentId}", method = RequestMethod.DELETE)
    @Secured("ROLE_ADMIN")
    public void deleteCommentDTO(@PathVariable int commentId) {
        crudService.deleteComment(commentId);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UsersDTO> getAllUsersDTO() { return crudService.searchAllUsers();
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public UsersDTO getUsersDTO(@PathVariable int userId) {
        return crudService.searchUserById(userId);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void addUsersDTO(@RequestBody UsersDTO usersDTO) {
        crudService.insertUsers(usersDTO);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
    public void updateUsersDTO(@RequestBody UsersDTO usersDTO, @PathVariable int userId) {
        crudService.updateUsers(userId, usersDTO);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
    public void deleteUsersDTO(@PathVariable int userId) {
        crudService.deleteUsers(userId);
    }
}