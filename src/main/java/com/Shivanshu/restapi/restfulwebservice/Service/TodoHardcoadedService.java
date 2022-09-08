package com.Shivanshu.restapi.restfulwebservice.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Shivanshu.restapi.restfulwebservice.Model.Todo;

@Service
public class TodoHardcoadedService {

	private static List<Todo> todos = new ArrayList<Todo>();
	
	private static int idCounter =0;
	
	static {
		todos.add(new Todo(++idCounter, "Shivanshu", "learn Java", false , new Date()));
		todos.add(new Todo(++idCounter, "Ayush", "learn Angular", false, new Date()));
	}
	
	public List<Todo> findAll(){
		
		return todos;
	}
}
