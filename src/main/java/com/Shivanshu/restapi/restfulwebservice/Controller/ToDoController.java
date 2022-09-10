package com.Shivanshu.restapi.restfulwebservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Shivanshu.restapi.restfulwebservice.Model.AuthenticatedUserResponse;
import com.Shivanshu.restapi.restfulwebservice.Model.LoginDetails;
import com.Shivanshu.restapi.restfulwebservice.Model.Todo;
import com.Shivanshu.restapi.restfulwebservice.Service.LoginDetailsAuthenticateService;
import com.Shivanshu.restapi.restfulwebservice.Service.TodoHardcoadedService;
import com.Shivanshu.restapi.restfulwebservice.Service.TodoService;

//@CrossOrigin(origins = {"http://localhost:4200","http://todoangularcode.s3-website-us-west-2.amazonaws.com"})
@CrossOrigin
@RestController
public class ToDoController {


	@Autowired
	private TodoService todoService;
	
	@Autowired
	private LoginDetailsAuthenticateService loginDetailsAuthenticateService;

	//retreive all todos for a User logged in 
	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodosForUser(@PathVariable String username){
		return todoService.getAllTodosForUser(username);	
	}

	//retreive single todo for a ID
	@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodoForUserId(@PathVariable long id){
		return todoService.getTodoForUserId(id);	
	}
	
	//adding new todo
		@PostMapping("/users/{username}/todos")
		public Todo saveTodo(@RequestBody Todo todo , @PathVariable String username){
			todo.setUserName(username);
			return todoService.saveTodo(todo);	
		}

	//Update a particular todo
	@PutMapping("/users/{username}/todos/{id}")
	public Todo updateTodoForUserId(@PathVariable String username,@PathVariable long id, @RequestBody Todo todo){
		return todoService.updateTodoForUserId(todo,id);	
	}

	//	Delete the Todo for a spcific ID
	@DeleteMapping("/deleteTodo/{id}")
	public  void deleteTodo(@PathVariable long id) {
		todoService.deleteTodoForID(id);	
	}
	
	@PostMapping("/authenticateUser")
	public AuthenticatedUserResponse  authenticateUser(@RequestBody LoginDetails loginDetails){
		return loginDetailsAuthenticateService.authenticate(loginDetails);	
		
	}
	@PostMapping("/registerUser")
	public AuthenticatedUserResponse  registerUser(@RequestBody LoginDetails loginDetails){
		return loginDetailsAuthenticateService.registerUser(loginDetails);	
		
	}
	
	
	
}
