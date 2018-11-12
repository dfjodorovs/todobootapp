package com.todoapp.base.todoApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TodoItemController {

    @GetMapping("/singleList/{categoryName}/{listName}")
    public String getSingleList(
            @PathVariable("categoryName") String categoryName,
            @PathVariable("listName") String listName,
            Model model
    ){
        model.addAttribute("categoryName", categoryName);
        model.addAttribute("listName", listName);
        return "todoitem";
    }


}
