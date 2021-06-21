import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TodoDataService } from '../service/data/todo-data.service';

export class Todo {
  constructor(
    public id: number,
    public description: string,
    public done: boolean,
    public targetDate: Date
  ) {}
}

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {
 
  //commenting for getting the values from backend
  //todos = [
  //   new Todo(1, 'Learn to dance', false, new Date),
  //   new Todo(2, 'Become an expert in Angular', false, new Date),
  //   new Todo(3, 'Visit Switzerland', false, new Date)
  //   // {id: 1, description:'Learn to dance'},
  //   // {id: 2, description:'Become an expert in Angular'},
  //   // {id: 3, description:'Visit Switzerland'}
  // ]
  
  todos!: Todo[];
  message!: String

  constructor(
    private todoService: TodoDataService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.refreshTodo()

  }

  refreshTodo(){
    this.todoService.retrieveAllTodos('in28Minutes').subscribe(
      response => {
        //console.log(response)
        this.todos = response
      }
    );
  }

  deleteTodo(id: any){
    //console.log(`Delete Todo ${id}`);
    //console.log('id value'+id);
    this.todoService.deleteTodo('in28Minutes', id).subscribe(
      response => {
        //console.log('todo deleted');
        this.message= `Delete of Todo ${id} is successful!` 
        this.refreshTodo();
      }
    );
  }

  updateTodo(id: any){
    //console.log(`Update Todo ${id}`);
    this.router.navigate(['todos',id])
  }

  addTodo(){
    this.router.navigate(['todos',-1])
  }

}
