package com.lybl.razorpay.subscription.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lybl.razorpay.subscription.service.PlansService;
import com.lybl.razorpay.subscriptions.vo.PlanInput;

@RestController
public class PlansController {
	
	@Autowired
	private PlansService plansService;

	@GetMapping("/plans")
	public String fetchAllPlans() {
		return plansService.fetchAllPlans();
	}
	
	@PostMapping("/plans")
	public String createPlan(@RequestBody PlanInput planInput) throws JsonProcessingException {
	    return plansService.createPlan(planInput);
	}

}
