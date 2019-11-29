package com.contemi.java.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.contemi.java.api.*;
import com.contemi.java.api.models.Employee;

@Component
public class SwaggerDelegateTest implements FindEmployeeDetailsApiDelegate{

	public SwaggerDelegateTest() {
		// TODO Auto-generated constructor stub
		System.out.println("A");
	};
	
	@Override
	public ResponseEntity<Employee> getEmployeeDetails(String employeeId) {
		// TODO Auto-generated method stub
		
		System.out.println("B");
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}