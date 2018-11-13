package com.todoapp.base.todoApp.controllers;

import com.todoapp.base.todoApp.models.Category;
import com.todoapp.base.todoApp.models.CategoryList;
import com.todoapp.base.todoApp.models.TodoAppUser;
import com.todoapp.base.todoApp.models.TodoItem;
import com.todoapp.base.todoApp.repositories.TodoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private TodoUserRepository todoUserRepository;

    @GetMapping("/")
    private String getWelcomePage(){
        return "index";
    }

    @GetMapping("/login")
    private String getLoginPage(){
        return "login";
    }

    @GetMapping("/signup")
    private String getNewUserPage(Model model){
        model.addAttribute("newUser",new TodoAppUser());
        return "signup";
    }

    @PostMapping("/signup")
    private String createNewUser(TodoAppUser user, Model model){
        todoUserRepository.save(user);
        model.addAttribute("saveOk","Saved!");
        model.addAttribute("newUser",new TodoAppUser());
        return "signup";
    }

}
