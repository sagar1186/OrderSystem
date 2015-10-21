package com.hackathon.model;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;
	private Payment payment;
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	private ItemList itemList;
	
	
	public ItemList getItemList() {
		return itemList;
	}
	public void setItemList(ItemList itemList) {
		this.itemList = itemList;
	}
	
	/*private Item item;
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}*/
	
	
	
	
}
