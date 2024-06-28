package org.redisCache.controller;

import lombok.AllArgsConstructor;
import org.redisCache.entity.UserInfo;
import org.redisCache.service.UserServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class UserController {
    private UserServices userServices;
    @GetMapping("/users")
    public List<UserInfo> getAllUsers(){
        return userServices.getAllUsers();
    }

    @GetMapping("/user-data/{id}")
    public UserInfo getUserData(@PathVariable Long id){
        return userServices.findUserById(id);
    }
}
