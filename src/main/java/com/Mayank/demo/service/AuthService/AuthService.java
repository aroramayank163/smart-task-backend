package com.Mayank.demo.service.AuthService;

import com.Mayank.demo.Model.User;
import com.Mayank.demo.Security.JwtGenerator;
import com.Mayank.demo.Security.LoginRequest;
import com.Mayank.demo.Security.LoginResponse;
import com.Mayank.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtGenerator jwtGenerator;

    public LoginResponse login(LoginRequest request){
        User user = userRepo.findByEmail(request.getEmail()).orElseThrow(()-> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Incorrect Password or Email");
        }

        String token  = jwtGenerator.generateTokenFromEmail(user.getEmail());

        return new LoginResponse(token, user.getEmail());
    }

    public User singnup( User user){
        if (userRepo.findByEmail(user.getEmail()).isEmpty()){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepo.save(user);
        }
        throw new RuntimeException("Already a existing account");
    }
}
