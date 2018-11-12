package com.todoapp.base.todoApp.controllers;

import com.todoapp.base.todoApp.models.Category;
import com.todoapp.base.todoApp.models.CategoryList;
import com.todoapp.base.todoApp.models.TodoAppUser;
import com.todoapp.base.todoApp.services.ListService;
import com.todoapp.base.todoApp.services.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryListController {

    @Autowired
    private ListService listService;

    @GetMapping("/lists/{categoryName}")
    public String getList(@PathVariable(value = "categoryName")String categoryName, Model model){
        model.addAttribute("categoryName", categoryName);
        model.addAttribute("newList", new CategoryList());
        model.addAttribute("categoryList", listService.getLists(categoryName));
        return "lists";
    }

    @PostMapping("/createNewList/{categoryName}")
    public String saveCategory(
            CategoryList newList,
            @PathVariable(value = "categoryName")String categoryName,
            Model model){

        listService.saveNewList(categoryName, newList);
        return "redirect:/lists/"+categoryName;
    }
}
