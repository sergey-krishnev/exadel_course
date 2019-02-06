package hibernate.controller.admin;

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
public class AdminRestCRUDTopicsController {

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
    public ResponseEntity addTopicDTO(@RequestBody TopicDTO topicDTO) {
        crudService.insertTopic(topicDTO);
        return ResponseEntity.ok(topicDTO);
    }

    @RequestMapping(value = "/topics/{topicId}", method = RequestMethod.PUT)
    public ResponseEntity updateTopicDTO(@RequestBody TopicDTO topicDTO, @PathVariable int topicId) {
        crudService.updateTopic(topicId,topicDTO);
        return ResponseEntity.ok(topicDTO);
    }

    @RequestMapping(value = "/topics/{topicId}", method = RequestMethod.DELETE)
    public void deleteTopicDTO(@PathVariable int topicId) {
        crudService.deleteTopic(topicId);
    }
}