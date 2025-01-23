package com.thoughtclan.springdemos.model;

import java.time.ZonedDateTime;

/**
 * Stores Todo data.
 */
public class Todo {
	public String id;
	public String title;
	public ZonedDateTime due;
	public boolean completed;
	public TodoStatus status;
	
	public Todo() {
		// no-op
	}
	
	public Todo(String title) {
		this.title = title;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ZonedDateTime getDue() {
		return due;
	}
	public void setDue(ZonedDateTime due) {
		this.due = due;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public TodoStatus getStatus() {
		return status;
	}
	public void setStatus(TodoStatus status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", due=" + due + ", completed=" + completed + ", status="
				+ status + "]";
	}
}
