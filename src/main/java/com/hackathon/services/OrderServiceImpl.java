package com.hackathon.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Environment;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;
import com.hackathon.model.Item;
import com.hackathon.model.ItemList;
import com.hackathon.model.Order;
import com.hackathon.model.Request;
import com.hackathon.model.Response;

public class OrderServiceImpl implements OrderService {
	
	
	
	private static BraintreeGateway gateway = new BraintreeGateway(
			  Environment.SANDBOX,
			  "9wkfxqbvz6qyf8jc",
			  "c3qcb5tpzm4p33y6",
			  "4e4f2f42bb3c16fa087144f134a24e94"
			);
	
	
	class CheaperItemPriceComp implements Comparator<Item>{
		 
	    @Override
	    public int compare(Item e1, Item e2) {
	        if(e1.getUnitPrice() > e2.getUnitPrice()){
	            return 1;
	        } else {
	            return -1;
	        }
	    }
	}
	
	Response response=new Response();
	public Response createOrder(Request requestUPC)
	{   
	 int item_upc=requestUPC.getItem_upc();
		
	 Order order=new Order();
	// order.getPayment("PayPal");
	 
		Item item1=new Item();
		item1.setItem_upc(12345);
		item1.setMerchant_id(11);;
		item1.setUnitPrice(11.2);
		item1.setQuantity(1);
		item1.setAvailability("true");
		
		Item item2=new Item();
		item2.setItem_upc(45636);
		item2.setMerchant_id(67);;
		item2.setUnitPrice(10.20);
		item2.setQuantity(1);
		item2.setAvailability("true");
		
		Item item3=new Item();
		item3.setItem_upc(23645);
		item3.setMerchant_id(234);;
		item3.setUnitPrice(11.55);
		item3.setQuantity(1);
		item3.setAvailability("true");
		
		 ArrayList<Item> items  =new ArrayList<Item>();
		 items.add(item1);
		 items.add(item2);
		 items.add(item3);
		
		//ArrayList<Item> items =order.getItemList().getItem();
		Collections.sort(items,new CheaperItemPriceComp());
		Item cheaperItem=items.get(0);
		
		System.out.println("**********cheaperItem-->"+cheaperItem.getUnitPrice());
		
		String nonceFromTheClient=gateway.clientToken().generate();
	    System.out.println("nonceFromTheClient-->"+nonceFromTheClient);
		TransactionRequest request = new TransactionRequest();
		System.out.println("request-->"+request);
	/*	request.merchantAccountId("9wkfxqbvz6qyf8jc");
		request.amount(new BigDecimal("10.00"));
		request.paymentMethodNonce(nonceFromTheClient);
		request.serviceFeeAmount(new BigDecimal("10.00"));
		//request.done();
*/		Result<Transaction> result = gateway.transaction().sale(request);
		System.out.println("result-->"+result.isSuccess());
		System.out.println("In service layer");
		Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
	    String strDate = sdf.format(date);
		int orderId=Calendar.getInstance().get(Calendar.MILLISECOND);
		response.setOrderId(orderId);
		response.setStatus("Success");
		response.setTimestamp(strDate);
		//response.setPayment(order.getPayment());
		
		return response;
		
	
		
	}

}
