package com.lybl.razorpay.subscription.service;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lybl.razorpay.subscriptions.vo.SubscriptionInput;

public interface SubscriptionsService {
	
	public String fetchAllSubscriptions();
	
	public String createSubscription(SubscriptionInput subscriptionInput) throws JsonProcessingException;
	
	public String fetchSubscriptionById(String subscriptionId);
	
	public String updateSubscription(Map<String, String> input, String subscriptionId) throws JsonProcessingException;
	
	public String cancelSubscription(Map<String, String> input, String subscriptionId) throws JsonProcessingException;

}
