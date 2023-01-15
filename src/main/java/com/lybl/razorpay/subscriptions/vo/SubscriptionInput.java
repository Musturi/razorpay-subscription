package com.lybl.razorpay.subscriptions.vo;

import java.util.List;
import java.util.Map;

public class SubscriptionInput {

	private String plan_id;
	private int total_count;
	private int quantity;
	private int start_at;
	private int expire_by;
	private boolean customer_notify;
	private List<Addons> addons;
	private String offer_id;
	private Map<String, String> notes;

	public String getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(String plan_id) {
		this.plan_id = plan_id;
	}

	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getStart_at() {
		return start_at;
	}

	public void setStart_at(int start_at) {
		this.start_at = start_at;
	}

	public int getExpire_by() {
		return expire_by;
	}

	public void setExpire_by(int expire_by) {
		this.expire_by = expire_by;
	}

	public boolean isCustomer_notify() {
		return customer_notify;
	}

	public void setCustomer_notify(boolean customer_notify) {
		this.customer_notify = customer_notify;
	}

	public List<Addons> getAddons() {
		return addons;
	}

	public void setAddons(List<Addons> addons) {
		this.addons = addons;
	}

	public String getOffer_id() {
		return offer_id;
	}

	public void setOffer_id(String offer_id) {
		this.offer_id = offer_id;
	}

	public Map<String, String> getNotes() {
		return notes;
	}

	public void setNotes(Map<String, String> notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "SubscriptionInput [plan_id=" + plan_id + ", total_count=" + total_count + ", quantity=" + quantity
				+ ", start_at=" + start_at + ", expire_by=" + expire_by + ", customer_notify=" + customer_notify
				+ ", addons=" + addons + ", offer_id=" + offer_id + ", notes=" + notes + "]";
	}

}
