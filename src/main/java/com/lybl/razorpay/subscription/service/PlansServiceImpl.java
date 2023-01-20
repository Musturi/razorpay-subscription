package com.lybl.razorpay.subscription.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lybl.razorpay.subscription.util.BasicAuthProvider;
import com.lybl.razorpay.subscriptions.vo.PlanInput;

@Service
public class PlansServiceImpl implements PlansService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private BasicAuthProvider basicAuth;

	@Override
	public String fetchAllPlans() {
		HttpEntity<String> entity = basicAuth.enableBasicAuth();
	    return restTemplate.exchange("https://api.razorpay.com/v1/plans", HttpMethod.GET, entity, String.class).getBody();
	}

	@Override
	public String createPlan(PlanInput planInput) throws JsonProcessingException {
		ObjectMapper objm = new ObjectMapper();
		String reqBody = objm.writeValueAsString(planInput);
		
		HttpEntity<String> entity = basicAuth.enableBasicAuth(reqBody);
		System.out.println(entity.getBody());
		
	    return restTemplate.exchange("https://api.razorpay.com/v1/plans", HttpMethod.POST, entity, String.class).getBody();
	}

}
