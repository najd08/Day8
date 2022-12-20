package com.example.assignment_day8.Service;

import com.example.assignment_day8.Model.User;
import com.example.assignment_day8.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class UserServices {
    private final UserRepository userRepository;

    public List<User> getUser(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public boolean updateUser(Integer id, User user){
        User preUser= userRepository.getById(id);
        if (preUser==null)
            return false;
        preUser.setAge(user.getAge());
        preUser.setRole(user.getRole());
        preUser.setName(user.getName());
        preUser.setEmail(user.getEmail());
        preUser.setUsername(user.getUsername());
        preUser.setPassword(user.getPassword());

        userRepository.save(preUser);
        return true;
    }

    public boolean deleteUser(Integer id){
        User user= userRepository.getById(id);
        if (user==null)
            return false;

        userRepository.delete(user);
        return true;
    }
}
