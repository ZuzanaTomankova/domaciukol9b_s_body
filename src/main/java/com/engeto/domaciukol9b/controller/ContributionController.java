package com.engeto.domaciukol9b.controller;

import com.engeto.domaciukol9b.service.ContributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.engeto.domaciukol9b.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController

public class ContributionController {
    private List<User> users=new ArrayList<>();

    @Autowired

    ContributionService contributionService;

    @PostMapping("user")
    public String createUser(@RequestBody User user) {
        boolean idExists = false;
        for (User existingUser : users) {
            if (Objects.equals(existingUser.getContributionId(), user.getContributionId())) {
                idExists = true;
                break;
            }
        }

        if (!idExists) {
            users.add(user);
            contributionService.saveToFile(users);
            return "Uživatel vytvořen.";
        } else {
            return "409 Id already exists";
        }
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
