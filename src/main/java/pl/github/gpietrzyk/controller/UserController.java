package pl.github.gpietrzyk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.github.gpietrzyk.domain.User;
import pl.github.gpietrzyk.service.UserService;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("app/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User addUser = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(addUser);
    }

}
