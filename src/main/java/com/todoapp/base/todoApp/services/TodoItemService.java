package com.todoapp.base.todoApp.services;

import com.todoapp.base.todoApp.models.Category;
import com.todoapp.base.todoApp.models.CategoryList;
import com.todoapp.base.todoApp.models.TodoAppUser;
import com.todoapp.base.todoApp.models.TodoItem;
import com.todoapp.base.todoApp.repositories.TodoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoItemService {

    @Autowired
    private UtilService utilService;

    @Autowired
    private TodoUserRepository todoUserRepository;

    public void saveItem(TodoItem todoItem, String categoryName, String listName) {
        TodoAppUser todoAppUse = utilService.getUser();
        Category category = utilService.getCategoryByCategoryName(todoAppUse, categoryName);
        CategoryList list = utilService.getListByListName(category, listName);
        list.getTodoItems().add(todoItem);
        todoUserRepository.save(todoAppUse);
    }

    public List<TodoItem> getTodoItems(String categoryName, String listName){
        CategoryList list = getCategoryList(categoryName, listName);
        return list.getTodoItems();
    }

    public void updateItem(List<TodoItem> todoItems, String categoryName, String listName) {
        TodoAppUser todoAppUse = utilService.getUser();
        CategoryList list = getCategoryList(categoryName, listName);
        list.setTodoItems(todoItems);
        todoUserRepository.save(todoAppUse);
    }

    public CategoryList getCategoryList(String categoryName, String listName){
        TodoAppUser todoAppUse = utilService.getUser();
        Category category = utilService.getCategoryByCategoryName(todoAppUse, categoryName);
        CategoryList list = utilService.getListByListName(category, listName);
        return list;
    }
}
