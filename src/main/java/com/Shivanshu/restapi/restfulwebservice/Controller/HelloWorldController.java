package com.Shivanshu.restapi.restfulwebservice.Controller;

import javax.management.RuntimeErrorException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Shivanshu.restapi.restfulwebservice.Service.HelloWorldBean;

@CrossOrigin("http://localhost:4200")
@RestController
public class HelloWorldController {
	
	
	//this will return a bean in JSon format so that it can be mapped with UI
	// so return object not generic string
	@GetMapping(path ="/hello-world-bean")
	public HelloWorldBean helloWorldbean() {
		//to test error in UI
	//	throw new RuntimeErrorException( null, "Some Eror hapnd");
		return new HelloWorldBean("Hello World Bean");
	}

}
