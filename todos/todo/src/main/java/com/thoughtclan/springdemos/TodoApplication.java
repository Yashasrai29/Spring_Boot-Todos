package com.thoughtclan.springdemos;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thoughtclan.springdemos.model.Todo;
import com.thoughtclan.springdemos.services.TodoService;

/**
 * Bootstrapper class for the simple Java application.
 * On running, it prompts the user to input a "todo title" to create a todo. 
 */
public class TodoApplication {

	/**
	 * Entry point for the application. Creates a new {@link ApplicationContext} and waits for
	 * user input to be processed.
	 * 
	 * @param args Program arguments
	 */
	public static void main(String [] args) {
		// create application context and add a shutdown hook for the context...
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
        
		// continuously listen for user inputs till user enters "quit"
		try(Scanner scanner = new Scanner(System.in)) {
			while(true) {
				System.out.println("Enter a Todo to save:");
				String todoTitle = scanner.nextLine();

				if("quit".equalsIgnoreCase(todoTitle)) {
					break;
				}
				
				System.out.println("Todo saved:" + addTodo(todoTitle, context));
			}
		}
	}
	
	/**
	 * Triggers {@link TodoService} to add a todo. Returns the newly added todo.
	 * 
	 * @param title Todo title
	 * @param context Application context which contains {@link TodoService}
	 * @return Newly created todo
	 */
	private static Todo addTodo(String title, AbstractApplicationContext context) {
		Todo todo = new Todo(title);
		
		TodoService service = (TodoService) context.getBean("todoService");
		return service.addTodo(todo);
	}
}
