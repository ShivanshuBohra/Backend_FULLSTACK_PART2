package com.Shivanshu.restapi.restfulwebservice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Shivanshu.restapi.restfulwebservice.Dao.TodoDao;
import com.Shivanshu.restapi.restfulwebservice.Model.Todo;

@Service
public class TodoService {
	
	@Autowired 
	private TodoDao toDodao;
	
	@Transactional
	public List<Todo> getAllTodosForUser(String username) {
		return toDodao.getAllTodosForUser(username);
	}

	@Transactional
	public void deleteTodoForID(long id) {
		// TODO Auto-generated method stub
		toDodao.deleteTodoForID(id);
		
	}

	@Transactional
	public Todo getTodoForUserId(long id) {
		// TODO Auto-generated method stub
		return toDodao.getTodoForId(id);
	}

	@Transactional
	public Todo updateTodoForUserId(Todo todo , long id) {
		// TODO Auto-generated method stub
		return toDodao.UpdateTodoForId(todo, id);
	}

	@Transactional
	public Todo saveTodo(Todo todo) {
		// TODO Auto-generated method stub
		return toDodao.saveTodo(todo);
	}

}
