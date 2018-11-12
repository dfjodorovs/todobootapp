package com.todoapp.base.todoApp.services;

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

}
