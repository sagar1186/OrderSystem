package com.hackathon.model;

import java.io.Serializable;
import java.util.Date;

public class Request implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;
	
	private int item_upc;
	private String customer_id;
	public int getItem_upc() {
		return item_upc;
	}
	public void setItem_upc(int item_upc) {
		this.item_upc = item_upc;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	
	
}
