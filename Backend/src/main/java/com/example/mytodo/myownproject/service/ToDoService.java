package com.example.mytodo.myownproject.service;

import com.example.mytodo.myownproject.modelentity.ToDo;
import com.example.mytodo.myownproject.repository.MyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private final MyRepository myRepository;

    public ToDoService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }
    //GEt by single ID
    public ToDo getTodoById(Long id) {
        return myRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
    }
    // get by All ids
    public List<ToDo> getAllTodos() {
        return myRepository.findAll();
    }
    public ToDo createTodo(ToDo toDo){
        return myRepository.save(toDo);
    }

    public ToDo updateTodo(Long id, ToDo updatedTodo) {
        return myRepository.findById(id).map(todo -> {
            todo.setTitle(updatedTodo.getTitle());
            todo.setCompleted(updatedTodo.isCompleted());
            return myRepository.save(todo);
        }).orElseThrow(() -> new RuntimeException("Todo not found")); //getAllTodos() → Gets all tasks.
                                                                       //createTodo() → Saves a new task.
    }                                                                   //updateTodo() → Updates a task by ID.
                                                                        //deleteTodo() → Deletes a task by ID.

    public void deleteTodo(Long id) {
        myRepository.deleteById(id);
    }
}
