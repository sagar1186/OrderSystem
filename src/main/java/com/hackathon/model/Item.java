package com.hackathon.model;

import java.io.Serializable;

public class Item implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;
	
	private int item_upc;	
	private String availability;
	private int merchant_id;
	private int itemId;
	private String name;
	private String description;
	private String taxName;
	private float taxRate;
	private int quantity;
	private double unitPrice;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTaxName() {
		return taxName;
	}
	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	public float getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(float taxRate) {
		this.taxRate = taxRate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public int getItem_upc() {
		return item_upc;
	}
	public void setItem_upc(int item_upc) {
		this.item_upc = item_upc;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public int getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(int merchant_id) {
		this.merchant_id = merchant_id;
	}
	
	
	
}
