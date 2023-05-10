package com.dxtracoded.EmployeeInformationSystem.controller;

import com.dxtracoded.EmployeeInformationSystem.exception.USernotFoundException;
import com.dxtracoded.EmployeeInformationSystem.model.User;
import com.dxtracoded.EmployeeInformationSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/getuser")
    List<User> getuser(){
        return userRepository.findAll();
    }
    @PostMapping("/save")
    User newUser(@RequestBody User newuser){
        return  userRepository.save(newuser);
    }

    @GetMapping("/user/{id}")
    User getUserById (@PathVariable Integer id){

        return userRepository.findById(id)
                .orElseThrow(()->new USernotFoundException(id));
    }

    @PostMapping("/user/p/{id}")
    User getUserPById (@PathVariable Integer id){

        return userRepository.findById(id)
                .orElseThrow(()->new USernotFoundException(id));
    }

    @PutMapping("user/{id}")
    User updateUser(@RequestBody User newuser,@PathVariable Integer id){
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newuser.getUsername());
                    user.setEmail(newuser.getEmail());
                    user.setName(newuser.getName());
                    return userRepository.save(user);
                }).orElseThrow(()-> new USernotFoundException(id));
    }

    @DeleteMapping("/user/{id}")

    String deleteUser(@PathVariable Integer id){
        if (!userRepository.existsById(id)){
            throw new USernotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id "+id+ "has been deleted   ";
    }
// we use User in methods Cause we are returing user
    //we String ncause we are returing String
}
