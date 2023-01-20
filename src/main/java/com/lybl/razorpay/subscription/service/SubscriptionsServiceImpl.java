package com.lybl.razorpay.subscription.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lybl.razorpay.subscription.util.BasicAuthProvider;
import com.lybl.razorpay.subscriptions.vo.SubscriptionInput;

@Service
public class SubscriptionsServiceImpl implements SubscriptionsService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private BasicAuthProvider basicAuth;

	@Override
	public String fetchAllSubscriptions() {
		HttpEntity<String> entity = basicAuth.enableBasicAuth();
		return restTemplate.exchange("https://api.razorpay.com/v1/subscriptions", HttpMethod.GET, entity, String.class)
				.getBody();
	}

	@Override
	public String createSubscription(SubscriptionInput subscriptionInput) throws JsonProcessingException {
		ObjectMapper objm = new ObjectMapper();
		String reqBody = objm.writeValueAsString(subscriptionInput);

		HttpEntity<String> entity = basicAuth.enableBasicAuth(reqBody);
		System.out.println(entity.getBody());

		return restTemplate.exchange("https://api.razorpay.com/v1/subscriptions", HttpMethod.POST, entity, String.class)
				.getBody();
	}

	@Override
	public String fetchSubscriptionById(String subscriptionId) {
		HttpEntity<String> entity = basicAuth.enableBasicAuth();
		System.out.println("subscriptionId: " + subscriptionId);

		return restTemplate.exchange("https://api.razorpay.com/v1/subscriptions/" + subscriptionId, HttpMethod.GET,
				entity, String.class).getBody();
	}

	@Override
	public String updateSubscription(Map<String, String> input, String subscriptionId) throws JsonProcessingException {
		ObjectMapper objm = new ObjectMapper();
		String reqBody = objm.writeValueAsString(input);

		HttpEntity<String> entity = basicAuth.enableBasicAuth(reqBody);
		System.out.println(entity.getBody());

		return restTemplate.exchange("https://api.razorpay.com/v1/subscriptions/" + subscriptionId, HttpMethod.PATCH,
				entity, String.class).getBody();
	}

	@Override
	public String cancelSubscription(Map<String, String> input, String subscriptionId) throws JsonProcessingException {
		ObjectMapper objm = new ObjectMapper();
		String reqBody = objm.writeValueAsString(input);

		HttpEntity<String> entity = basicAuth.enableBasicAuth(reqBody);
		System.out.println(entity.getBody());

		return restTemplate.exchange("https://api.razorpay.com/v1/subscriptions/" + subscriptionId + "/cancel",
				HttpMethod.POST, entity, String.class).getBody();
	}

}
