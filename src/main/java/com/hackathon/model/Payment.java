package com.hackathon.model;

import java.io.Serializable;

public class Payment implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;
	
	
	private String merchantEmail;
	private String payerEmail;
	private String paymentTerms;
	private String transactionId;
//	private ItemList itemList;
	
	private String currencyCode;
	
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	/*public ItemList getItemList() {
		return itemList;
	}
	public void setItemList(ItemList itemList) {
		this.itemList = itemList;
	}*/
	
	public String getMerchantEmail() {
		return merchantEmail;
	}
	public void setMerchantEmail(String merchantEmail) {
		this.merchantEmail = merchantEmail;
	}
	/*public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}*/
	public String getPayerEmail() {
		return payerEmail;
	}
	public void setPayerEmail(String payerEmail) {
		this.payerEmail = payerEmail;
	}
	public String getPaymentTerms() {
		return paymentTerms;
	}
	public void setPaymentTerms(String paymentTerms) {
		this.paymentTerms = paymentTerms;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	
	
	
	
}
