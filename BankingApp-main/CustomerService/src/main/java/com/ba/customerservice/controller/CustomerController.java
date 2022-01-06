package com.ba.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.ba.customerservice.service.CustomerService;

@RestController
@RequestMapping(value = "/customers")
//@Api(value="Customer Service", description="Customer Service")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/**
	 * This method is used to add customers
	 * 
	 * @param customer
	 * @return ResponseEntity<Customer>
	 */
	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		return ResponseEntity.ok(customerService.addCustomer(customer));
	}

	/**
	 * This method is used to get all customers
	 * 
	 * @return ResponseEntity<List<Customer>>
	 */
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return ResponseEntity.ok(customerService.getAllCustomer());
	}

	/**
	 * This method is used to get customers by gender
	 * 
	 * @param cGender
	 * @return ResponseEntity<List<Customer>>
	 */
	@GetMapping(value = "/gender/{customerGender}")
	public ResponseEntity<List<Customer>> getCustomersByGender(@PathVariable String customerGender) {
		return ResponseEntity.ok(customerService.getCustomersByGender(customerGender));
	}

	/**
	 * This method is used to get customer details by name
	 * 
	 * @param cName
	 * @return Customer
	 */
	@GetMapping(value = "/{customerName}")
	public ResponseEntity<Customer> getCustomersByName(@PathVariable String customerName) {
		return ResponseEntity.ok(customerService.getCustomersByName(customerName));
	}

	/**
	 * This method is used to find customer by date of Birth
	 * 
	 * @param cDateOfBirth
	 * @return Customer
	 */
	@GetMapping(value = "/dateofbirth/{customerDateOfBirth}")
	public ResponseEntity<List<Customer>> getCustomersByDateOfBirth(@PathVariable String customerDateOfBirth) {
		return ResponseEntity.ok(customerService.getCustomersByDateOfBirth(customerDateOfBirth));
	}
	
	
	/**
	 * This method is used to update customer date of birth
	 * @param customerGender
	 * @return
	 */
	@PutMapping(value = "/updatedateofbirth/{customerId}")
	public ResponseEntity<Customer> updateCustomersDateOfBirth(@PathVariable int customerId,@RequestBody String customerDateOfBirth) {
		return ResponseEntity.ok(customerService.updateCustomerDateOfBirth(customerId,customerDateOfBirth));
	}

	/**
	 * This method is used to update customer name
	 * 
	 * @param customer
	 * @return Customer
	 */
	@PutMapping(value = "/updatename/{customerId}")
	public ResponseEntity<Customer> updateCustomersName(@PathVariable int customerId,@RequestBody String customerName) {
		return ResponseEntity.ok(customerService.updateCustomerName(customerId,customerName));
	}
	
	@DeleteMapping(value="/{customerId}")
	public void deleteCustomerById(@PathVariable int customerId) {
		customerService.deleteCustomerById(customerId);
	}

}