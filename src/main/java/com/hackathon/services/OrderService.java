package com.hackathon.services;

import com.hackathon.model.Order;
import com.hackathon.model.Request;
import com.hackathon.model.Response;

public interface OrderService {

	public Response createOrder(Request request);
}
