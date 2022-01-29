package com.ba.customerservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.client.RestTemplate;

import com.ba.customerservice.model.Customer;
import com.ba.customerservice.service.CustomerServiceImpl;

@RestController
@RequestMapping(value="/customers")
public class CustomerController {
	
	@Autowired
	private RestTemplate restTemplate;
	
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
		if(customerServiceImpl.getAllCustomerDetails()==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(customerServiceImpl.getAllCustomerDetails());
	}
	
	@GetMapping(value = "/{customerId}")
	public ResponseEntity<Optional<Customer>> getCustomersById(@PathVariable int customerId) {
		if(customerServiceImpl.getCustomerById(customerId)==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(customerServiceImpl.getCustomerById(customerId));
	}
	
	@GetMapping(value = "/name/{customerName}")
	public ResponseEntity<Customer> getCustomersByName(@PathVariable String customerName) {
		if(customerServiceImpl.getCustomersByName(customerName)==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(customerServiceImpl.getCustomersByName(customerName));
	}
	
	@GetMapping(value = "/dateofbirth/{customerDateOfBirth}")
	public ResponseEntity<Object> getCustomersByDateOfBirth(@PathVariable String customerDateOfBirth) {
		if(customerServiceImpl.getCustomersByDateOfBirth(customerDateOfBirth)==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(customerServiceImpl.getCustomersByDateOfBirth(customerDateOfBirth));
	}
	
	@GetMapping(value = "/gender/{customerGender}")
	public ResponseEntity<List<Customer>> getCustomersByGender(@PathVariable String customerGender) {
		if(customerServiceImpl.getCustomersByGender(customerGender)==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(customerServiceImpl.getCustomersByGender(customerGender));
	}
	
	@PutMapping(value = "/updatedateofbirth/{customerId}")
	public ResponseEntity<Optional<Customer>> updateCustomersDateOfBirth(@PathVariable int customerId,@RequestBody String customerDateOfBirth) {
		
		if(customerServiceImpl.updateCustomerDateOfBirth(customerId,customerDateOfBirth)==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(customerServiceImpl.getCustomerById(customerId));
	}
	
	@PutMapping(value = "/updatename/{customerId}")
	public ResponseEntity<Optional<Customer>> updateCustomersName(@PathVariable int customerId,@RequestBody String customerName) {

		if(customerServiceImpl.updateCustomerName(customerId,customerName)==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(customerServiceImpl.getCustomerById(customerId));
	}
	
	@DeleteMapping(value="/{customerId}")
	public ResponseEntity<Object> deleteCustomerById(@PathVariable int customerId) {
		if(customerServiceImpl.getCustomerById(customerId)==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		customerServiceImpl.deleteCustomerById(customerId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping(value="/transactions")
	public List<Object> getAlltransactions(){
		
		String transactionUri="http://localhost:2002/transactions";
		Object[] transaction=restTemplate.getForObject(transactionUri, Object[].class);
		
		return Arrays.asList(transaction);
		
		
		
		
	}
}
