package com.example.assignment_day8.Controller;

import com.example.assignment_day8.ApiResponse;
import com.example.assignment_day8.Model.User;
import com.example.assignment_day8.Service.UserServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/v1") @RequiredArgsConstructor
public class UserController {
    private final UserServices userServices;
    @GetMapping("/get")
    public ResponseEntity getUser(){
        List<User> users= userServices.getUser();
        return ResponseEntity.status(200).body(users);
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);}
        userServices.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User have been added!"));
    }
   @PutMapping("/update/{index}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));}
        userServices.updateUser(id,user);
        return ResponseEntity.status(200).body(new ApiResponse("User updated!"));
    }
    @DeleteMapping("/delete/{index}")
    public String deleteUser(Integer id){
        userServices.deleteUser(id);
        return "user has been deleted";
    }
}
