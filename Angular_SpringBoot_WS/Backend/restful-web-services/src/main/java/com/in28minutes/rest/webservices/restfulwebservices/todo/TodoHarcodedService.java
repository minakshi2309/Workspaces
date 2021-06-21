package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHarcodedService {

	private static List<Todo> todos = new ArrayList<>();
	private static int idCounter = 0;
	
	static {
		todos.add(new Todo(++idCounter, "in28Minutes", "Learn to Dance", new Date(), false));
		todos.add(new Todo(++idCounter, "in28Minutes", "Learn about Microservices", new Date(), false));
		todos.add(new Todo(++idCounter, "in28Minutes", "Learn about Cloud Tech", new Date(), false));
	}
	
	public List<Todo> findAll() {
		return todos;
	}
	
	public Todo deleteTodo(long id) {
		Todo todo = findById(id);
		if(todo!=null) {
			todos.remove(todo);
			return todo;
		}
		return null;
	}
	
	public Todo findById(long id) {
		for(Todo todo : todos) {
			if(todo.getId()==id)
				return todo;
		}
		return null;
	}
	
	public Todo saveTodo(Todo todo) {
		if(todo.getId()<1) {
			todo.setId(++idCounter);
			todo.setUsername("in28Minutes");
			System.out.println("todo.getID() value in save: "+todo.getId());
			todos.add(todo);
		}else {
			System.out.println("todo.getID() value in update: "+todo.getId());
			deleteTodo(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
}
