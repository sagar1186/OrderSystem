package com.hackathon.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hackathon.model.Employee;
import com.hackathon.model.Order;
import com.hackathon.model.Request;
import com.hackathon.model.Response;
import com.hackathon.services.OrderService;
import com.hackathon.services.OrderServiceImpl;

/**
 * Handles requests for the Employee service.
 */
@Controller
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	//Map to store employees, ideally we should use database
	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();
	OrderService orderService=new OrderServiceImpl();
	@RequestMapping(value = OrdRestURIConstants.DUMMY_EMP, method = RequestMethod.GET)
	public @ResponseBody Employee getDummyEmployee() {
		logger.info("Start getDummyEmployee");
		Employee emp = new Employee();
		emp.setId(9999);
		emp.setName("Dummy");
		emp.setCreatedDate(new Date());
		empData.put(9999, emp);
		return emp;
	}
	
	@RequestMapping(value = OrdRestURIConstants.GET_EMP, method = RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
		logger.info("Start getEmployee. ID="+empId);
		
		return empData.get(empId);
	}
	
	@RequestMapping(value = OrdRestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployees() {
		logger.info("Start getAllEmployees.");
		List<Employee> emps = new ArrayList<Employee>();
		Set<Integer> empIdKeys = empData.keySet();
		for(Integer i : empIdKeys){
			emps.add(empData.get(i));
		}
		return emps;
	}
	
	@RequestMapping(value = OrdRestURIConstants.CREATE_EMP, method = RequestMethod.POST)
	public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
		logger.info("Start createEmployee.");
		emp.setCreatedDate(new Date());
		empData.put(emp.getId(), emp);
		return emp;
	}
	
	@RequestMapping(value = OrdRestURIConstants.DELETE_EMP, method = RequestMethod.PUT)
	public @ResponseBody Employee deleteEmployee(@PathVariable("id") int empId) {
		logger.info("Start deleteEmployee.");
		Employee emp = empData.get(empId);
		empData.remove(empId);
		return emp;
	}
	
	
	/*@RequestMapping(value = OrdRestURIConstants.CREATE_ORDER, method = RequestMethod.POST)
	public @ResponseBody Response createOrder(@RequestBody Order  order) {
		System.out.println("Start createOrder.");
		Response response =orderService.createOrder(order);
		//order.setTimestamp(new Date());
		//empData.put(order.getId(), emp);
		return response;
	}*/
	
	
	@RequestMapping(value = OrdRestURIConstants.CREATE_ORDER, method = RequestMethod.POST)
	public @ResponseBody Response createOrder(@RequestBody Request  request) {
		System.out.println("Start createOrder.");
		Response response =orderService.createOrder(request);
		//order.setTimestamp(new Date());
		//empData.put(order.getId(), emp);
		return response;
	}
	
}
