package com.thoughtclan.springdemos.services.impl;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.thoughtclan.springdemos.data.TodoDao;
import com.thoughtclan.springdemos.exceptions.TodoNotFoundException;
import com.thoughtclan.springdemos.model.Todo;
import com.thoughtclan.springdemos.model.TodoStatus;
import com.thoughtclan.springdemos.services.TodoService;

/**
 * DAO based implementation of {@link TodoService}.
 */
@Service("todoService")
public class TodoServiceImpl implements TodoService {
	private static final Logger logger = LoggerFactory.getLogger(TodoServiceImpl.class);
	
	@Value("${todo.prefix}") // used to read config properties; provide the key within ${}
	private String todoPrefix;
	
	private TodoDao todoDao;
	
	@Value("#{ systemEnvironment['user.timezone'] }") 
	private String timezone;
	
	// used to evaluate expression against spring container; use #{}
	// e.g. #{inMemoryTodoDao.todos}
	@Value("#{inMemoryTodoDao.todos}")
	private Collection<Todo> todos;

	public TodoServiceImpl(@Autowired TodoDao fileTodoDao) {
		logger.info("Creating a new instance of Todo service.");
		this.todoDao = fileTodoDao;
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
	 * Triggered after bean initialization. Validates if timezone if present. If not
	 * initializes it with a default value.
	 */
	@PostConstruct
	public void init() {
		logger.info("Todo service is initialized.");
		if(timezone == null || timezone.isEmpty()) {
			timezone = "Asia/Calcutta";
		}
	}
	
	@PreDestroy
	public void destroy() {
		logger.info("Todo service is being destroyed.");
	}

	@Override
	public Todo getTodo(String id) {
		Todo todo = todoDao.getTodo(id);
		if(todo == null) {
			throw new TodoNotFoundException();
		}

		return todo;
	}
}
