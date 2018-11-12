package com.todoapp.base.todoApp.services;

import com.todoapp.base.todoApp.models.Category;
import com.todoapp.base.todoApp.models.CategoryList;
import com.todoapp.base.todoApp.models.TodoAppUser;
import com.todoapp.base.todoApp.repositories.TodoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {

    @Autowired
    private UtilService utilService;

    @Autowired
    private TodoUserRepository todoUserRepository;

    public void saveNewList(String categoryName, CategoryList newList){
        TodoAppUser username = utilService.getUser();
        Category chosenCategory = utilService.getCategoryByCategoryName(username, categoryName);
        chosenCategory.getCategoryLists().add(newList);
        todoUserRepository.save(username);
    }

    public List<CategoryList> getLists(String categoryName) {
        TodoAppUser username = utilService.getUser();
        Category chosenCategory = utilService.getCategoryByCategoryName(username, categoryName);
        return chosenCategory.getCategoryLists();
    }
}
