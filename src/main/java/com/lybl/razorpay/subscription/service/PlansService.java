package com.lybl.razorpay.subscription.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lybl.razorpay.subscriptions.vo.PlanInput;

public interface PlansService {

	public String fetchAllPlans();

	public String createPlan(PlanInput planInput) throws JsonProcessingException;

}
