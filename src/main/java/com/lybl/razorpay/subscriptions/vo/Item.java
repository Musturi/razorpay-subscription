package com.lybl.razorpay.subscriptions.vo;

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
public class Item {

	private String name;
	private int amount;
	private String currency;
	private String description;

}
