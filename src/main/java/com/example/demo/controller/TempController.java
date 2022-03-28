package com.example.demo.controller;

import com.example.demo.dto.response.ResponMessage;
import com.example.demo.model.Temperature;
import com.example.demo.model.User;
import com.example.demo.security.userprincal.UserDetailService;
import com.example.demo.service.ITempService;
import com.example.demo.service.impl.TempServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("")
public class TempController {

    @Autowired
    private TempServiceImpl tempService;
    @Autowired
    private UserDetailService userDetailService;
    @GetMapping("/list-temp")

    public ResponseEntity<?> pageTemp(@PageableDefault(sort = "name", direction = Sort.Direction.ASC) Pageable pageable){
        Page<Temperature> tempPage = tempService.findAll(pageable);
        if(tempPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tempPage, HttpStatus.OK);
    }
    @GetMapping("/temp-list")
    public ResponseEntity<?> showListTemp(){
        User user = userDetailService.getCurrentUser();
        if(user.getUsername().equals("Anonymous")){
            return new ResponseEntity<>(new ResponMessage("Please login!"), HttpStatus.OK);
        }
        List<Temperature> tempList = tempService.findAll();
        if(tempList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tempList,HttpStatus.OK);
    }
    @PostMapping("/create-temp")
    public ResponseEntity<?> createTemp(@RequestBody Temperature temperature){
        User user = userDetailService.getCurrentUser();
        if(user.getUsername().equals("Anonymous")){
            return new ResponseEntity<>(new ResponMessage("Please login!"), HttpStatus.OK);
        }

        Temperature  temperature1= new Temperature();
        temperature1.setTemperature(temperature.getTemperature());
        temperature1.setDatetime(temperature.getDatetime());
        temperature1.setUser(user);
        tempService.save(temperature1);
        return new ResponseEntity<>(new ResponMessage("yes"), HttpStatus.CREATED);
    }

    @PutMapping("/edit-temp/{id}")
    public ResponseEntity<?> editTemp(@RequestBody Temperature temperature, @PathVariable Long id){
        User user = userDetailService.getCurrentUser();
        if(user.getUsername().equals("Anonymous")){
            return new ResponseEntity<>(new ResponMessage("Please login!"), HttpStatus.OK);
        }
        Optional<Temperature> temperature1 = tempService.findById(id);
        if (!temperature1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        temperature1.get().setDatetime(temperature1.get().getDatetime());
        temperature1.get().setTemperature(temperature.getTemperature());

        tempService.save(temperature1.get());
        return new ResponseEntity<>(new ResponMessage("Done Edit!"), HttpStatus.OK);
    }

    @DeleteMapping("/delete-temp/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        User user = userDetailService.getCurrentUser();
        if(user.getUsername().equals("Anonymous")){
            return new ResponseEntity<>(new ResponMessage("Please login!"), HttpStatus.OK);
        }
        Temperature temperature = tempService.findById(id).get();
        if (temperature == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tempService.deleteById(id);
        return new ResponseEntity<>(new ResponMessage("Done Delete!"),HttpStatus.OK);
    }
    @GetMapping("/find-temp/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(tempService.findById(id).get(),HttpStatus.OK) ;
    }


}
