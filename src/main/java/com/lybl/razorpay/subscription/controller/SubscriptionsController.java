package com.lybl.razorpay.subscription.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lybl.razorpay.subscription.service.SubscriptionsService;
import com.lybl.razorpay.subscriptions.vo.SubscriptionInput;

@RestController
public class SubscriptionsController {
	
	@Autowired
	private SubscriptionsService subscriptionsService;

	@GetMapping("/subscriptions")
	public String fetchAllSubscriptions() {
		return subscriptionsService.fetchAllSubscriptions();
	}

	@PostMapping("/subscriptions")
	public String createSubscription(@RequestBody SubscriptionInput subscriptionInput) throws JsonProcessingException {
		return subscriptionsService.createSubscription(subscriptionInput);
	}

	@GetMapping("/subscriptions/{id}")
	public String fetchSubscriptionById(@PathVariable("id") String subscriptionId) {
		return subscriptionsService.fetchSubscriptionById(subscriptionId);
	}
	
	@PatchMapping("/subscriptions/{id}")
	public String updateSubscription(@RequestBody Map<String, String> input, @PathVariable("id") String subscriptionId) throws JsonProcessingException {
		return subscriptionsService.updateSubscription(input, subscriptionId);
	}
	
	@PostMapping("/subscriptions/{id}/cancel")
	public String cancelSubscription(@RequestBody Map<String, String> input, @PathVariable("id") String subscriptionId) throws JsonProcessingException {
		return subscriptionsService.cancelSubscription(input, subscriptionId);
	}
	
	
}
