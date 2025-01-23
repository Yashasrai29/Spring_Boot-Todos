package com.thoughtclan.springdemos.services.impl;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtclan.springdemos.data.TodoDao;
import com.thoughtclan.springdemos.model.Todo;
import com.thoughtclan.springdemos.model.TodoStatus;
import com.thoughtclan.springdemos.services.TodoService;

/**
 * DAO based implementation of {@link TodoService}.
 */
public class TodoServiceImpl implements TodoService {
	private static final Logger logger = LoggerFactory.getLogger(TodoServiceImpl.class);
	
	private String todoPrefix;
	private TodoDao todoDao;
	private String timezone;
	
	public TodoServiceImpl(TodoDao todoDao) {
		logger.info("Creating a new instance of Todo service.");
		this.todoDao = todoDao;
	}
	
	public void setTodoPrefix(String todoPrefix) {
		this.todoPrefix = todoPrefix;
	}
	
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	@Override
	public Todo addTodo(Todo todo) {
		todo.setId(UUID.randomUUID().toString());
		todo.setDue(ZonedDateTime.now(ZoneId.of(timezone)));
		todo.setStatus(TodoStatus.PENDING);
		todo.setTitle(todoPrefix + " " + todo.getTitle());

		return todoDao.addTodo(todo);
	}

	@Override
	public Collection<Todo> getTodos() {
		return todoDao.getTodos();
	}
	
	/**
	 * To be triggered after bean initialization. Validates if timezone if present. If not
	 * initializes it with a default value.
	 */
	public void init() {
		logger.info("TodoServiceImpl is initialized.");
		if(timezone == null || timezone.isEmpty()) {
			timezone = "Asia/Calcutta";
		}
	}
	
	public void destroy() {
		logger.info("TodoServiceImpl is going to be destroyed.");
	}
}
