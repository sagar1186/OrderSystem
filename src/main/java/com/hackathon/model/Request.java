package com.hackathon.model;

import java.io.Serializable;
import java.util.Date;

public class Request implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;
	
	private int item_upc;
	private String macId;
	public int getItem_upc() {
		return item_upc;
	}
	public void setItem_upc(int item_upc) {
		this.item_upc = item_upc;
	}
	public String getMacId() {
		return macId;
	}
	public void setMacId(String macId) {
		this.macId = macId;
	}
	
	
	
}
