package com.lybl.razorpay.subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lybl.razorpay.subscriptions.vo.SubscriptionInput;

@RestController
public class SubscriptionsController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private BasicAuthProvider basicAuth;

	@GetMapping("/subscriptions")
	public String fetchAllSubscriptions() {
		HttpEntity<String> entity = basicAuth.enableBasicAuth();
	    return restTemplate.exchange("https://api.razorpay.com/v1/subscriptions", HttpMethod.GET, entity, String.class).getBody();
	}
	
	@PostMapping("/subscriptions")
	public String createPlan(@RequestBody SubscriptionInput subscriptionInput) throws JsonProcessingException {
		
		ObjectMapper objm = new ObjectMapper();
		String reqBody = objm.writeValueAsString(subscriptionInput);
		
		HttpEntity<String> entity = basicAuth.enableBasicAuth(reqBody);
		System.out.println(entity.getBody());
		
	    return restTemplate.exchange("https://api.razorpay.com/v1/subscriptions", HttpMethod.POST, entity, String.class).getBody();
	}
}
