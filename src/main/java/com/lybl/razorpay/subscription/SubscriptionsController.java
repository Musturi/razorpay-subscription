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
	public String createSubscription(@RequestBody SubscriptionInput subscriptionInput) throws JsonProcessingException {
		
		ObjectMapper objm = new ObjectMapper();
		String reqBody = objm.writeValueAsString(subscriptionInput);
		
		HttpEntity<String> entity = basicAuth.enableBasicAuth(reqBody);
		System.out.println(entity.getBody());
		
	    return restTemplate.exchange("https://api.razorpay.com/v1/subscriptions", HttpMethod.POST, entity, String.class).getBody();
	}

        @GetMapping("/subscriptions/{id}")
	public String fetchSubscriptionById(@PathVariable("id") String subscriptionId) {
		HttpEntity<String> entity = basicAuth.enableBasicAuth();
		System.out.println("subscriptionId: " + subscriptionId);
		
		return restTemplate.exchange("https://api.razorpay.com/v1/subscriptions/" + subscriptionId, HttpMethod.GET,
				entity, String.class).getBody();
	}
	
	@PatchMapping("/subscriptions/{id}")
	public String updateSubscription(@RequestBody Map<String, String> input, @PathVariable("id") String subscriptionId) throws JsonProcessingException {

		ObjectMapper objm = new ObjectMapper();
		String reqBody = objm.writeValueAsString(input);

		HttpEntity<String> entity = basicAuth.enableBasicAuth(reqBody);
		System.out.println(entity.getBody());

		return restTemplate.exchange("https://api.razorpay.com/v1/subscriptions/" + subscriptionId, HttpMethod.PATCH, entity, String.class)
				.getBody();
	}
	
	@PostMapping("/subscriptions/{id}/cancel")
	public String cancelSubscription(@RequestBody Map<String, String> input, @PathVariable("id") String subscriptionId) throws JsonProcessingException {

		ObjectMapper objm = new ObjectMapper();
		String reqBody = objm.writeValueAsString(input);

		HttpEntity<String> entity = basicAuth.enableBasicAuth(reqBody);
		System.out.println(entity.getBody());

		return restTemplate.exchange("https://api.razorpay.com/v1/subscriptions/" + subscriptionId + "/cancel", HttpMethod.POST, entity, String.class)
				.getBody();
	}
}
