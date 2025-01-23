package com.thoughtclan.springdemos.services;

import java.util.Collection;

import com.thoughtclan.springdemos.model.Todo;

/**
 * Exposes service operations on Todo model.
 */
public interface TodoService {
	
	/**
	 * Adds given todo. Sets the following default values.
	 * 1) Random ID
	 * 2) A due date of current zoned time
	 * 3) A status of PENDING
	 * 4) Adds a configured todo prefix to given todo title.
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
