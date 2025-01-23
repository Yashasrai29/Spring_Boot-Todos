package com.thoughtclan.springdemos.data.impl;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Repository;

import com.thoughtclan.springdemos.data.TodoDao;
import com.thoughtclan.springdemos.model.Todo;

@Repository("fileTodoDao")
public class FileTodoDaoImpl implements TodoDao {

	@Override
	public Todo addTodo(Todo todo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Todo> getTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Todo getTodo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostConstruct
	public void initializeFileReaderWriter() {
		
	}
	
	@PreDestroy
	public void closeReaderWriter() {
		
	}
}
