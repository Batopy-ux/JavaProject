package com.ba.customerservice.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ba.customerservice.model.Customer;
import com.ba.customerservice.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

//@Autowired
//private RestTemplate restTemplate;

	/**
	 * This method is used to add customer
	 * 
	 * @param cust
	 * @return Customer
	 */
	public Customer addCustomer(Customer cust) {

		Customer existingCustomer = customerRepository.findBycustomerNameIgnoreCase(cust.getCustomerName());
//	System.out.println(existingCustomer);
		if (existingCustomer == null) {
			Calendar birthDay = Calendar.getInstance();
			birthDay.setTimeInMillis(cust.getCustomerDateOfBirth().getTime());

			// create calendar object for current day
			long currentTime = System.currentTimeMillis();
			Calendar now = Calendar.getInstance();
			now.setTimeInMillis(currentTime);

			cust.setCustomerAge(now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR));

			return customerRepository.save(cust);
		} else {
			System.out.println("Customer " + cust.getCustomerName() + " already exists");
			return cust;
		}
	}

	/**
	 * This method is used to find all customers
	 * 
	 * @return List<Customer>
	 */
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	public Optional<Customer> getCustomerById(int customerId) {
		return customerRepository.findById(customerId);
	}

	/**
	 * This method is used to get customers by gender
	 * 
	 * @param cGender
	 * @return List<Customer>
	 */
	public List<Customer> getCustomersByGender(String customerGender) {
		return customerRepository.findBycustomerGenderIgnoreCase(customerGender);
	}

	/**
	 * This method is used to get customer details by name
	 * 
	 * @param cName
	 * @return Customer
	 */
	public Customer getCustomersByName(String customerName) {
		return customerRepository.findBycustomerNameIgnoreCase(customerName);
	}

	/**
	 * This method is used to find customer by date of Birth
	 * 
	 * @param cDateOfBirth
	 * @return List<Customer>
	 */
	public List<Customer> getCustomersByDateOfBirth(String customerDateOfBirth) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		long l = 0;
		try {
			l = sdf.parse(customerDateOfBirth).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long timezone = 19800000L;
		Date dob = new Date(l + timezone);

		return customerRepository.findBycustomerDateOfBirth(dob);
	}

	public Customer updateCustomerName(int customerId, String customerName) {
		if (customerRepository.existsById(customerId)) {
			Customer tempCustomer = customerRepository.getById(customerId);
			tempCustomer.setCustomerName(customerName);
			return customerRepository.save(tempCustomer);
		} else {
			System.out.println("Customer with ID: " + customerId + " doesnt exists.");
			return null;
		}
	}

	public Customer updateCustomerDateOfBirth(int customerId, String customerDateOfBirth) {
		if (customerRepository.existsById(customerId)) {
			Customer tempCustomer = customerRepository.getById(customerId);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			long l = 0;
			try {
				l = sdf.parse(customerDateOfBirth).getTime();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			long timezone = 19800000L;
			Date dob = new Date(l + timezone);
			tempCustomer.setCustomerDateOfBirth(dob);
			return customerRepository.save(tempCustomer);
		} else {
			System.out.println("Customer with ID: " + customerId + " doesnt exists.");
			return null;
		}
	}
	
	public void deleteCustomerById(int customerId) {
		if (customerRepository.existsById(customerId)) {
			customerRepository.deleteById(customerId);
		} else {
			System.out.println("Customer with ID: " + customerId + " doesnt exists.");
			
		}
		
	}

//	@Scheduled(fixedRate=5000)
//	public void logInConsole(){
//		
//		System.out.println(customerRepository.findAll().toString());
//		}

}
