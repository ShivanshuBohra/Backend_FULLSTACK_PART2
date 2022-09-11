package com.Shivanshu.restapi.restfulwebservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Shivanshu.restapi.restfulwebservice.Service.AwsSnsService;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;

@CrossOrigin
@RestController
public class AwsSnsController {

	@Autowired
	private AwsSnsService awsSnsService;

   //Add a subscriber if they approve 
	//theey will be mapped to the topic
// all the subscriber will be notified when something is pushed into that topic
	@GetMapping("/addSubscription/{email}")
	public String addSubscription(@PathVariable String email) {
		return awsSnsService.addSubscription(email);
	}
	
	//If you want to push some messages to all subscribers
	@GetMapping("/sendNotification")
	public String publishMessageToTopic(){
		return awsSnsService.publishMessage();
	}

}
