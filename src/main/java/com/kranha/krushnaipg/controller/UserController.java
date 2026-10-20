package com.kranha.krushnaipg.controller;

import com.kranha.krushnaipg.dto.User;
import com.kranha.krushnaipg.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return service.getUser(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return service.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }

    @GetMapping("/ascid")
    public List<User> getUserByAsnID(){
          return service.getUserByAsnID();
    }

    @GetMapping("/dsc")
    public List<User> getUserByAsn(){
        return service.getUserByDsc();
    }
    //    Filter records where the name ends with a specific letter

    @GetMapping("/endwith/{letter}")
    public List<User> getUser(@PathVariable String letter){
        return service.getUserByEndingLetter(letter);
    }

    //    Search using the email address.
    @GetMapping("/search/{email}")
    public List<User> getUserByEmail(@PathVariable String email){
        return service.getUserByEmail(email);
    }
//    Sort the results in ascending order by name.

}



