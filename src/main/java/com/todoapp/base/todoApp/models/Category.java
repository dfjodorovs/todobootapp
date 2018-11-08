package com.todoapp.base.todoApp.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "todo_app_user_id")
    private TodoAppUser todoAppUser;

    @OneToMany
    private List<CategoryList> categoryLists = new ArrayList<>();

    public TodoAppUser getTodoAppUser() {
        return todoAppUser;
    }

    public void setTodoAppUser(TodoAppUser todoAppUser) {
        this.todoAppUser = todoAppUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryList> getCategoryLists() {
        return categoryLists;
    }

    public void setCategoryLists(List<CategoryList> categoryLists) {
        this.categoryLists = categoryLists;
    }
}
