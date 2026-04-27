package com.Mayank.demo.Controller;

import com.Mayank.demo.Model.User;
import com.Mayank.demo.service.ModelService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // Retrieve all users from database
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    // Update user details only if user exists
    @PutMapping("/{id}")
    public User UpdateByid(@RequestBody User user, @PathVariable int id){
        return userService.updateUser(user, id);
    }

    // Delete a specific user by id
    @DeleteMapping("/{id}")
    public void deleteByid(@PathVariable int id){
        userService.delete(id);
    }

    // Remove all users from database
    @DeleteMapping("/delete")
    public void deletaeAll(){
        userService.deleteAll();
    }

    // Bulk insert multiple users
    @PostMapping("/addUsers")
    public void addUsers(@RequestBody List<User> users){
        userService.addUsers(users);
    }

    // Create and persist a single user
    @PostMapping("/adduser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}