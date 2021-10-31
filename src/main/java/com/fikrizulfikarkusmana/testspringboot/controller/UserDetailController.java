package com.fikrizulfikarkusmana.testspringboot.controller;

import com.fikrizulfikarkusmana.testspringboot.entity.UserDetail;
import com.fikrizulfikarkusmana.testspringboot.repo.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserDetailController {

    @Autowired
    private UserDetailRepo userDetailRepo;

    @PostMapping
    public UserDetail createOne(@RequestBody UserDetail userDetail){
        return userDetailRepo.save(userDetail);
    }
    @GetMapping
    public Iterable<UserDetail> findAll(){
        return userDetailRepo.findAll();
    }
}
