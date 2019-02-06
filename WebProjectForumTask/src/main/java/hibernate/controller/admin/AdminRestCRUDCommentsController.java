package hibernate.controller.admin;

import hibernate.dto.CommentDTO;
import hibernate.service.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AdminRestCRUDCommentsController {

    @Autowired
    private CRUDService crudService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public List<CommentDTO> getAllCommentDTO() {
        return crudService.searchAllComment();
    }

    @RequestMapping(value = "/comments/{commentId}", method = RequestMethod.GET)
    public CommentDTO getCommentDTO(@PathVariable int commentId) {
        return crudService.searchCommentById(commentId);
    }

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public ResponseEntity addCommentDTO(@RequestBody CommentDTO commentDTO) {
        crudService.insertComment(commentDTO);
        return ResponseEntity.ok(commentDTO);
    }

    @RequestMapping(value = "/comments/{commentId}", method = RequestMethod.PUT)
    public ResponseEntity updateCommentDTO(@RequestBody CommentDTO commentDTO, @PathVariable int commentId) {
        crudService.updateComment(commentId, commentDTO);
        return ResponseEntity.ok(commentDTO);
    }

    @RequestMapping(value = "/comments/{commentId}", method = RequestMethod.DELETE)
    public void deleteCommentDTO(@PathVariable int commentId) {
        crudService.deleteComment(commentId);
    }

}
