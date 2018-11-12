package com.todoapp.base.todoApp.services;

import com.todoapp.base.todoApp.models.Category;
import com.todoapp.base.todoApp.models.CategoryList;
import com.todoapp.base.todoApp.models.TodoAppUser;
import com.todoapp.base.todoApp.repositories.TodoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UtilService {

    @Autowired
    private TodoUserRepository todoUserRepository;

    public TodoAppUser getUser(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        TodoAppUser username = todoUserRepository.findByUsername(auth.getName());

        return username;
    }

    public Category getCategoryByCategoryName(TodoAppUser username, String categoryName){
        Category chosenCategory = null;
        for(Category c : username.getCategories()){
            if(c.getName().equals(categoryName)){
                return c;
            }
        }
        return null;
    }

    public CategoryList getListByListName(Category category, String listName){
        CategoryList chosenCategory = null;
        for(CategoryList c : category.getCategoryLists()){
            if(c.getName().equals(listName)){
                return c;
            }
        }
        return null;
    }

}
