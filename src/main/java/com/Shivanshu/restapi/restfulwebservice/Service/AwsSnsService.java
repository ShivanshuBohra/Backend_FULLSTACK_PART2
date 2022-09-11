package com.Shivanshu.restapi.restfulwebservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;

@Service
public class AwsSnsService {
	
	@Autowired
	private AmazonSNSClient snsClient;

	//Add TOPIC_ARN from amazon aws security
	String TOPIC_ARN="" ;
	
	public String addSubscription(String email) {
		SubscribeRequest request = new SubscribeRequest(TOPIC_ARN, "email", email);
		snsClient.subscribe(request);
		return "Subscription request is pending. To confirm the subscription, check your email : " + email;
		
	}

	public String publishMessage() {
		PublishRequest publishRequest=new PublishRequest(TOPIC_ARN,buildEmailBody(),"Notification: Network connectivity issue");
		snsClient.publish(publishRequest);
		return "Notification send successfully !!";
	}
	

	private String buildEmailBody(){
		return "Dear User ,\n" +
				"\n" +
				"\n" +
				"Hope You are liking the application."+"\n"+
				"This a sample body of mail to test aws SNS(Send notification service) ! \n" ;	}

}
