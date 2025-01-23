package com.example.demo.controller;

import com.example.demo.model.Todo;
import com.example.demo.repo.TodoRepo;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/todoitem")
@CrossOrigin(origins = "*")
public class TodoControl {
    @Autowired
    private TodoRepo todoRepo;
    @GetMapping
    public List<Todo> findAll(){return todoRepo.findAll();}

//    @GetMapping
//    public Optional<Todo> findById(){return todoRepo.findById(Integer Id);}

    @PostMapping
    public Todo save(@NotNull@RequestBody Todo todo){
        return todoRepo.save(todo);
    }

    @GetMapping
    public List<Todo> getall(Todo todo){return todoRepo.findAll();}

    @PutMapping
    public Todo update(@NotNull@RequestBody Todo todo){
        return todoRepo.save(todo);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Integer id){
        todoRepo.deleteById(id);
    }

    @PatchMapping
    public Todo patch(@NotNull@RequestBody Todo todo) {
        return todoRepo.save(todo);
    }

//
//    private TodoDto entityToDto(TodoItem todoItem){
//        TodoDto dto=new TodoDto();
//        dto.setId(todoItem.getId());
//        dto.setName(todoItem.getName());
//        dto.setDuedate(todoItem.getDuedate());
//        dto.setStatus(todoItem.getStatus());
//
//        return dto;
//    }
//    private TodoItem dtoToEntity(TodoDto todoDto){
//        TodoItem todoItem=new TodoItem();
//        todoItem.setName(todoDto.getName());
//        todoItem.setName(todoDto.getName());
//        todoItem.setDuedate(todoDto.getDuedate());
//        todoItem.setStatus(todoDto.getStatus());
//
//        return todoItem;
//    }
}
