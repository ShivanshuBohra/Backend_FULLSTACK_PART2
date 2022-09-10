package com.Shivanshu.restapi.restfulwebservice.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Shivanshu.restapi.restfulwebservice.Model.Todo;


@Service
public class TodoDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public List<Todo> getAllTodosForUser(String username) {
		
		Session currentSession = entityManager.unwrap(Session.class);

		//USE below to retrive foe particular username
		Query getAllTodosForUsername= currentSession.createQuery("from Todo where username = :username");
			getAllTodosForUsername.setParameter("username", username);
	//	Query getAllTodosForUsername= currentSession.createQuery("from Todo");
		
		
		 List<Todo> listOfTodos = getAllTodosForUsername.list();

		 for (Todo obj : listOfTodos) {
			 System.out.println(obj);
		 }
		  return listOfTodos;
	}

	@Transactional
	public void deleteTodoForID(long id) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Todo todoObj = currentSession.get(Todo.class, id);
		currentSession.delete(todoObj);
		System.out.println( "Employee has been deleted with id : "+ id);;
		
	}

	@Transactional
	public Todo getTodoForId(long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Todo todo = currentSession.get(Todo.class, id);
		return todo;
	}

	@Transactional
	public Todo UpdateTodoForId(Todo todo, long id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		//updating data with new todo from request body and saving latest one
		
		Todo existingTodo = getTodoForId(id);
		existingTodo.setDescription(todo.getDescription());
		existingTodo.setTargetDate(todo.getTargetDate());
		existingTodo.setIsDone(todo.getIsDone());
		
		currentSession.save(existingTodo);
		
	
		return existingTodo;
	}

	@Transactional
	public Todo saveTodo(Todo todo) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(todo);
		return todo;
	}

}
