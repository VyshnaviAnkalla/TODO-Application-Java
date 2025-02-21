package com.example.mytodo.myownproject.controller;

import com.example.mytodo.myownproject.modelentity.ToDo;
import com.example.mytodo.myownproject.service.ToDoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/mytodos")
public class TodoController {
    private final ToDoService todoService;

    public TodoController(ToDoService toDoService) {
        this.todoService = toDoService;
    }

    @GetMapping("/{id}")
    public ToDo getTodoById(@PathVariable Long id){
        return todoService.getTodoById(id);
    }
    @GetMapping
    public List<ToDo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @PostMapping
    public ToDo createTodo(@RequestBody ToDo todo){
        return  todoService.createTodo(todo);
    }
    @PutMapping("/{id}")
    public  ToDo updateTodo(@PathVariable Long id, @RequestBody ToDo updateTodo){
        return todoService.updateTodo(id, updateTodo);
    }
    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
        return "HMM,,Todo Deleted";
    }

}
