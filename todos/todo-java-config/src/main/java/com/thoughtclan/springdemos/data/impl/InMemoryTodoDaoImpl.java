package com.thoughtclan.springdemos.data.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.thoughtclan.springdemos.data.TodoDao;
import com.thoughtclan.springdemos.model.Todo;

/**
 * Mock implementation of {@link TodoDao} which stores data in a Map.
 */
@Primary
@Repository("inMemoryTodoDao")
public class InMemoryTodoDaoImpl implements TodoDao {
	private static final Logger logger = LoggerFactory.getLogger(InMemoryTodoDaoImpl.class);
	
	private Map<String, Todo> todos;
	
	public InMemoryTodoDaoImpl() {
		logger.info("Creating a new instance of Todo Dao.");
	}
	
	@Override
	public Todo addTodo(Todo todo) {
		todos.put(todo.getId(), todo);
		return todo;
	}

	@Override
	public Collection<Todo> getTodos() {
		return todos.values();
	}

	@Override
	public Todo getTodo(String id) {
		return todos.get(id);
	}

	/**
	 * Triggered after bean initialization. Initializes the instance map.
	 */
	@PostConstruct
	public void init() {
		todos = new HashMap<>();
	}
}
