package com.test.user.controller;

import com.test.user.entity.User;
import com.test.user.service.UserService;
import com.test.user.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public ResponseVO getUserwithDepartment(@PathVariable("id") Long userId){
        return userService.getUserwithDepartment(userId);
    }
}


