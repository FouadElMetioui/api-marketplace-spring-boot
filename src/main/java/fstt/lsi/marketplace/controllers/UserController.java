package fstt.lsi.marketplace.controllers;

import fstt.lsi.marketplace.models.User;
import fstt.lsi.marketplace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value="/api")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id)
    {
        return userService.getById(id);
    }


    @PutMapping("/user")
    public User updateUser(@RequestBody User user , @PathVariable Long id){
        return userService.updateUser(user,id);
    }

}