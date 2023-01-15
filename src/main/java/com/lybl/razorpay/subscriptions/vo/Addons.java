package com.lybl.razorpay.subscriptions.vo;

public class Addons {

	private Item item;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Addons [item=" + item + "]";
	}

}
