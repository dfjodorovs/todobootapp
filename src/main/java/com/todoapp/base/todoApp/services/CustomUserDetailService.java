package com.todoapp.base.todoApp.services;

import com.todoapp.base.todoApp.models.TodoAppUser;
import com.todoapp.base.todoApp.repositories.TodoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("customUserDetailService")
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    private TodoUserRepository todoUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TodoAppUser username = todoUserRepository.findByUsername(s);
        if(username == null){
            throw new UsernameNotFoundException("User not found!");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "USER";
            }
        });

        return new User(
                username.getUsername(),
                passwordEncoder.encode(username.getPassword()),
                grantedAuthorities);
    }

    public void setTodoUserRepository(TodoUserRepository todoUserRepository) {
        this.todoUserRepository = todoUserRepository;
    }
}
