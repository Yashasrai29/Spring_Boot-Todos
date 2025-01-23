package com.thoughtclan.springdemos.exceptions;

/**
 * Exception thrown when given todo id does not fetch any Todo object.
 */
public class TodoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -4133825039024545022L;
}
