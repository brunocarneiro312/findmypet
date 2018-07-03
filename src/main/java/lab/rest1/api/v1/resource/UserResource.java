package lab.rest1.api.v1.resource;

import lab.rest1.api.v1.model.UserDTO;
import lab.rest1.domain.User;
import lab.rest1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(UserResource.API_V1_USERS)
public class UserResource {

    public static final String API_V1_USERS = "/api/v1/users";

    private UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        return new ResponseEntity<UserDTO>(user.convert(), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getUsers() {
        List users = new ArrayList<>();
        userService.list().forEach(users::add);
        return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO) {
        userService.save(userDTO.convert());
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    }
}
