package com.thoughtclan.springdemos.data;

import java.util.Collection;

import com.thoughtclan.springdemos.model.Todo;

/**
 * Exposes CRUD operations on Todo model.
 */
public interface TodoDao {
	/**
	 * Adds given todo.
	 * 
	 * @param Todo to add
	 * @return Newly added Todo
	 */
	public Todo addTodo(Todo todo);
	
	/**
	 * Returns all todos.
	 * 
	 * @return 
	 */
	public Collection<Todo> getTodos();
}
