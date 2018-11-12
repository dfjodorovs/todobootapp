package com.todoapp.base.todoApp.models;

import java.util.ArrayList;
import java.util.List;

public class TodoItemDao {

    private List<TodoItem> todoItems = new ArrayList<>();

    public TodoItemDao(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }
}
