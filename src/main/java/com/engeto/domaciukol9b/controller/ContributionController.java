package com.engeto.domaciukol9b.controller;

import com.engeto.domaciukol9b.service.ContributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.engeto.domaciukol9b.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController

public class ContributionController {
    private List<User> users=new ArrayList<>();

    @Autowired

    ContributionService contributionService;

    @PostMapping("user")
    public String createUser(@RequestBody User user) {
        users.add(user);
        if(!users.contains(user.getContributionId()))
        {
            contributionService.saveToFile(users);}

        return "409 Id exists";
    }




    @GetMapping("user")
    public List<User> getAllUserst(){
        return users;
    }
    @GetMapping("user/visible")
    public List<User>getVisibleUsers(){
        List<User>visibleUsers = new ArrayList<>();
        for (User user:users)
        if (user.getIsVisible()==true){
            visibleUsers.add((user));
        }return visibleUsers;
    }

}
