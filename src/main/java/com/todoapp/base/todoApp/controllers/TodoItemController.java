package com.todoapp.base.todoApp.controllers;

import com.todoapp.base.todoApp.models.TodoItem;
import com.todoapp.base.todoApp.models.TodoItemDao;
import com.todoapp.base.todoApp.services.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoItemController {

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/singleList/{categoryName}/{listName}")
    public String getSingleList(
            @PathVariable("categoryName") String categoryName,
            @PathVariable("listName") String listName,
            Model model
    ){
        model.addAttribute("categoryName", categoryName);
        model.addAttribute("listName", listName);
        model.addAttribute("newItem", new TodoItem());
        model.addAttribute("todoItemDAO", new TodoItemDao(
                todoItemService.getTodoItems(categoryName,listName)
        ));

        return "todoitem";
    }

    @PostMapping("/createTodoItem/{categoryName}/{listName}")
    public String createTodoItem(
            TodoItem todoItem,
            @PathVariable("categoryName") String categoryName,
            @PathVariable("listName") String listName
    ){
                todoItemService.saveItem(todoItem, categoryName, listName);
                return "redirect:/singleList/"+categoryName+"/"+listName+"";
    }

    @PostMapping("/updateTodoItems/{categoryName}/{listName}")
    public String updateTodoItem(
            TodoItemDao todoItemDao,
            @PathVariable("categoryName") String categoryName,
            @PathVariable("listName") String listName
    ){
        todoItemService.updateItem(todoItemDao.getTodoItems(), categoryName, listName);
        return "redirect:/singleList/"+categoryName+"/"+listName+"";
    }


}
