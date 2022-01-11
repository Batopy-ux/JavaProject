package com.ba.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ba.customerservice.model.Customer;
import com.ba.customerservice.service.CustomerServiceImpl;

@RestController
@RequestMapping(value="/customers")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		if(customerServiceImpl.createCustomer(customer)==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(customer);
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomer(){
		return ResponseEntity.ok(customerServiceImpl.getAllCustomerDetails());
	}
	
	@GetMapping(value = "/{customerName}")
	public ResponseEntity<Customer> getCustomersByName(@PathVariable String customerName) {
		return ResponseEntity.ok(customerServiceImpl.getCustomersByName(customerName));
	}
	
	@PutMapping(value = "/updatedateofbirth/{customerId}")
	public ResponseEntity<Customer> updateCustomersDateOfBirth(@PathVariable int customerId,@RequestBody String customerDateOfBirth) {
		return ResponseEntity.ok(customerServiceImpl.updateCustomerDateOfBirth(customerId,customerDateOfBirth));
	}
	
	@PutMapping(value = "/updatename/{customerId}")
	public ResponseEntity<Customer> updateCustomersName(@PathVariable int customerId,@RequestBody String customerName) {
		return ResponseEntity.ok(customerServiceImpl.updateCustomerName(customerId,customerName));
	}
	
	@DeleteMapping(value="/{customerId}")
	public void deleteCustomerById(@PathVariable int customerId) {
		customerServiceImpl.deleteCustomerById(customerId);
	}
}
