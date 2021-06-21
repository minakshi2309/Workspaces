import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_URL } from 'src/app/app.constants';
import { Todo } from 'src/app/list-todos/list-todos.component';

@Injectable({
  providedIn: 'root'
})
export class TodoDataService {

  constructor(
    private http: HttpClient
  ) { }

  retrieveAllTodos(username: any) {
    // return this.http.get<Todo[]>(`http://localhost:8080/users/${username}/todos`);
    return this.http.get<Todo[]>(`${API_URL}/users/${username}/todos`);
  }

  deleteTodo(username: any, id: any){
    //return this.http.delete(`http://localhost:8080/users/${username}/todos/${id}`);
    return this.http.delete(`${API_URL}/users/${username}/todos/${id}`);
  }

  retrieveTodo(username: any, id: any){
    //return this.http.get<Todo>(`http://localhost:8080/users/${username}/todos/${id}`);
    return this.http.get<Todo>(`${API_URL}/users/${username}/todos/${id}`);
  }

  updateTodo(username: any, id: any, todo: Todo){
    //return this.http.put(`http://localhost:8080/users/${username}/todos/${id}`, todo);
    return this.http.put(`${API_URL}/users/${username}/todos/${id}`, todo);
  }

  createTodo(username: any, todo: Todo){
    //return this.http.post(`http://localhost:8080/users/${username}/todos`, todo);
    return this.http.post(`${API_URL}/users/${username}/todos`, todo);
  }
}
