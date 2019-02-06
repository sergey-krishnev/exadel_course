package hibernate.controller.admin;

import hibernate.dto.SubjectDTO;
import hibernate.service.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AdminRestCRUDSubjectsController {

    @Autowired
    private CRUDService crudService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/subjects", method = RequestMethod.GET)
    public List<SubjectDTO> getAllSubjectDTO() {
        return crudService.searchAllSubject();
    }

    @RequestMapping(value = "/subjects/{subjectId}", method = RequestMethod.GET)
    public SubjectDTO getSubjectDTO(@PathVariable int subjectId) {
        return crudService.searchSubjectById(subjectId);
    }

    @RequestMapping(value = "/subjects", method = RequestMethod.POST)
    public ResponseEntity addSubjectDTO(@RequestBody SubjectDTO subjectDTO) {
        crudService.insertSubject(subjectDTO);
        return ResponseEntity.ok(subjectDTO);
    }

    @RequestMapping(value = "/subjects/{subjectId}", method = RequestMethod.PUT)
    public ResponseEntity updateSubjectDTO(@RequestBody SubjectDTO subjectDTO, @PathVariable int subjectId) {
        crudService.updateSubject(subjectId, subjectDTO);
        return ResponseEntity.ok(subjectDTO);
    }

    @RequestMapping(value = "/subjects/{subjectId}", method = RequestMethod.DELETE)
    public void deleteSubjectDTO(@PathVariable int subjectId) {
        crudService.deleteSubject(subjectId);
    }

}
