package com.Mayank.demo.service.ModelService;

import com.Mayank.demo.Model.User;
import com.Mayank.demo.repo.UserRepo;
import com.Mayank.demo.service.AuthService.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    private AuthService authService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User getByid(int id){
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("Not User found"));
    }

    public User updateUser(User update, int id){
        User fetched = userRepo.findById(id).orElse(null);
        if (fetched!=null){
            fetched.setName(update.getName());
            fetched.setEmail(update.getEmail());
            fetched.setPassword(update.getPassword());
            return userRepo.save(fetched);
        }
        throw new RuntimeException("GO to SignUp page");
    }

    public void delete(int id){
        userRepo.deleteById(id);
    }

    public void deleteAll(){
        userRepo.deleteAll();
    }

    public void addUsers(List<User> users){
        for (User eachUser : users){
            userRepo.save(eachUser);
        }
    }

    public User addUser(User user){
        return userRepo.save(user);
    }
}
