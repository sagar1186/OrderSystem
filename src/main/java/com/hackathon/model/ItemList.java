package com.hackathon.model;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemList implements Serializable{

	private static final long serialVersionUID = -7788619177798333712L;
	
	private ArrayList<Item> item =new ArrayList<Item>();

	public ArrayList<Item> getItem() {
		return item;
	}

	public void setItem(ArrayList<Item> item) {
		this.item = item;
	}

	

	
	
}
