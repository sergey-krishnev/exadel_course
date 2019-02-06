package hibernate.controller.admin;

import hibernate.dto.UsersDTO;
import hibernate.service.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AdminRestCRUDUsersController {

    @Autowired
    private CRUDService crudService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UsersDTO> getAllUsersDTO() { return crudService.searchAllUsers();
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public UsersDTO getUsersDTO(@PathVariable int userId) {
        return crudService.searchUserById(userId);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity addUsersDTO(@RequestBody UsersDTO usersDTO) {
        crudService.insertUsers(usersDTO);
        return ResponseEntity.ok(usersDTO);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
    public ResponseEntity updateUsersDTO(@RequestBody UsersDTO usersDTO, @PathVariable int userId) {
        crudService.updateUsers(userId, usersDTO);
        return ResponseEntity.ok(usersDTO);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
    public void deleteUsersDTO(@PathVariable int userId) {
        crudService.deleteUsers(userId);
    }

}
