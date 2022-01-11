package com.ba.customerservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ba.customerservice.model.Customer;
import com.ba.customerservice.repository.CustomerRepository;

@Service
public class CustomerServiceOnline implements CustomerService{
	
Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerRepository customerRepository;

	public Customer updateCustomerPassword(int customerId, String customerEmail, String customerPassword) {
		if (customerRepository.existsById(customerId)) {
			Customer tempCustomer = customerRepository.getById(customerId);
			tempCustomer.getPersonalDetails().setCustomerPassword(customerPassword);
			tempCustomer.getPersonalDetails().setCustomerEmail(customerEmail);
			return customerRepository.save(tempCustomer);
		} else {
			log.info("Customer with ID: " + customerId + " doesnt exists.");
			return null;
		}
	}
}
