package com.example.demo.repo;

import com.example.demo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepo extends JpaRepository<Todo, Integer> {
   //Optional<Todo> findById();
}
