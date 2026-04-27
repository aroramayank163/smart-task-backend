package com.Mayank.demo.Controller;

import com.Mayank.demo.Model.User;
import com.Mayank.demo.Security.LoginRequest;
import com.Mayank.demo.Security.LoginResponse;
import com.Mayank.demo.service.AuthService.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AuthController {

    @Autowired
    private AuthService authService;

    // signup endpoint
    @PostMapping("/signup")
    public User signup(@RequestBody User user){
        return authService.singnup(user);
    }

    // login endpoint
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        return authService.login(request);
    }
}