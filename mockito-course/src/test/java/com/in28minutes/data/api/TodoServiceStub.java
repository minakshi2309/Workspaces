package com.in28minutes.data.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
//No dynamic flexibility. stubs used for very simple scenarios

	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
	}

	public void deleteTodo(String todo) {
		// TODO Auto-generated method stub
		
	}

}
