package com.hackathon;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.hackathon.controller.OrdRestURIConstants;
import com.hackathon.model.Employee;
import com.hackathon.model.Request;
import com.hackathon.model.Response;

public class TestSpringRestExample {

	public static final String SERVER_URI = "http://127.0.0.1:13537/OMS";
	
	public static void main(String args[]){
		
		System.out.println("***Testing**");
		testCreateOrder();
		System.out.println("**End***");
		/*testGetDummyEmployee();
		System.out.println("*****");
		testCreateEmployee();
		System.out.println("*****");
		testGetEmployee();
		System.out.println("*****");
		testGetAllEmployee();*/
	}
	
	
	private static void testCreateOrder() {
		RestTemplate restTemplate = new RestTemplate();
		Request req = new Request();
		req.setItem_upc(4563);req.setCustomer_id("451");
		Response response = restTemplate.postForObject(SERVER_URI+OrdRestURIConstants.CREATE_ORDER, req, Response.class);
		printOrderData(response);
	}
	

	/*private static void testGetAllEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Employee> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI+OrdRestURIConstants.GET_ALL_EMP, List.class);
		System.out.println(emps.size());
		for(LinkedHashMap map : emps){
			System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",CreatedDate="+map.get("createdDate"));;
		}
	}

	private static void testCreateEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = new Employee();
		emp.setId(1);emp.setName("Pankaj Kumar");
		Employee response = restTemplate.postForObject(SERVER_URI+OrdRestURIConstants.CREATE_EMP, emp, Employee.class);
		printEmpData(response);
	}

	private static void testGetEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = restTemplate.getForObject(SERVER_URI+"/rest/emp/1", Employee.class);
		printEmpData(emp);
	}

	private static void testGetDummyEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = restTemplate.getForObject(SERVER_URI+OrdRestURIConstants.DUMMY_EMP, Employee.class);
		printEmpData(emp);
	}
	
	public static void printEmpData(Employee emp){
		System.out.println("ID="+emp.getId()+",Name="+emp.getName()+",CreatedDate="+emp.getCreatedDate());
	}*/
	
	public static void printOrderData(Response res){
		System.out.println("OrderID="+res.getOrderId()+",Status="+res.getStatus()+",CreatedDate="+res.getTimestamp());
	}
}
