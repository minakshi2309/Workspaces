package com.minakshi.vending.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minakshi.vending.model.Product;

@Service
public class VendingServiceImpl implements VendingService {

	private static List<Product> products = new ArrayList<Product>();

    /*static {
    	products.add(new Product(1, "Coke", 10, 25));
    	products.add(new Product(2, "Lays", 10, 15));
    	products.add(new Product(3, "Snickers", 10, 35));
    }*/

	@Override
	public List<Product> retrieveAllProducts() {
		return products;
	}

    /*public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
    
    public Todo retrieveTodo(int id) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getId()==(id)) {
            	return todo;
            }
        }
        return null;
    }
    
    public void updateTodo(Todo todo) {
    	todos.remove(todo);
    	todos.add(todo);
    }

    public void addTodo(String name, String desc, Date targetDate,
            boolean isDone) {
        todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }*/

}
