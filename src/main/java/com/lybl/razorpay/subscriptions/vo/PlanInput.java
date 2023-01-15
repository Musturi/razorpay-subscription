package com.lybl.razorpay.subscriptions.vo;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlanInput {
	
	private String period;
	private int interval;
	private Item item;
	private Map<String, String> notes;
}
