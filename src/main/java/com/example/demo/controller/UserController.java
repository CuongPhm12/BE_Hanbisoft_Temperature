package com.example.demo.controller;

import com.example.demo.dto.response.ResponMessage;
import com.example.demo.model.Temperature;
import com.example.demo.model.User;
import com.example.demo.security.userprincal.UserDetailService;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user-profile")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserDetailService userDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        Optional<User> userOptional = userService.findById(id);
        return new ResponseEntity<>(userService.findById(id).get(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        User currentUser = userDetailService.getCurrentUser();
        currentUser.setName(user.getName());
        currentUser.setEmail(user.getEmail());
        currentUser.setPosition(user.getPosition());
//        userService.save(user);
//        return new ResponseEntity<>(new ResponMessage("Done Edit!"), HttpStatus.OK);
        return new ResponseEntity<>(userService.save(currentUser), HttpStatus.OK);
    }

}
//    Optional<Temperature> temperature1 = tempService.findById(id);
//        if (!temperature1.isPresent()) {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        temperature1.get().setDatetime(temperature1.get().getDatetime());
//        temperature1.get().setTemperature(temperature.getTemperature());
//        temperature1.get().setStatus(temperature.isStatus());
//
//        tempService.save(temperature1.get());
//        return new ResponseEntity<>(new ResponMessage("Done Edit!"), HttpStatus.OK);