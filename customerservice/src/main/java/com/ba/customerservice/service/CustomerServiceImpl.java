package com.ba.customerservice.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ba.customerservice.model.Customer;
import com.ba.customerservice.repository.CustomerRepository;

@Service
public class CustomerServiceImpl {
	
	Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer createCustomer(Customer customer) {
		Customer existingCustomer = customerRepository.findBycustomerNameIgnoreCase(customer.getCustomerName());
		
		if (existingCustomer == null) {
			Calendar birthDay = Calendar.getInstance();
			birthDay.setTimeInMillis(customer.getPersonalDetails().getCustomerDateOfBirth().getTime());

			// create calendar object for current day
			long currentTime = System.currentTimeMillis();
			Calendar now = Calendar.getInstance();
			now.setTimeInMillis(currentTime);

			customer.getPersonalDetails().setCustomerAge(now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR));

			customerRepository.save(customer);
			log.info("Customer " + customer.getCustomerName() + " added successfully!");
			return customer;
		} else {
			log.info("Customer " + customer.getCustomerName() + " already exists");
			return null;
		}
	}
	
	
	public List<Customer> getAllCustomerDetails(){
		log.info("Getting all customers");
		return customerRepository.findAll();
	}
	
	public Optional<Customer> getCustomerById(int customerId) {
		log.info("Finding customer with ID: "+customerId);
		return customerRepository.findById(customerId);
	}

	
//	public List<Customer> getCustomersByGender(String customerGender) {
//		return customerRepository.findBycustomerGenderIgnoreCase(customerGender);
//	}

	
	public Customer getCustomersByName(String customerName) {
		log.info("Finding customer with name: "+customerName);
		return customerRepository.findBycustomerNameIgnoreCase(customerName);
	}

//	public List<Customer> getCustomersByDateOfBirth(String customerDateOfBirth) {
//
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//
//		long l = 0;
//		try {
//			l = sdf.parse(customerDateOfBirth).getTime();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		long timezone = 19800000L;
//		Date dob = new Date(l + timezone);
//
//		return customerRepository.findBycustomerDateOfBirth(dob);
//	}

	public Customer updateCustomerName(int customerId, String customerName) {
		if (customerRepository.existsById(customerId)) {
			Customer tempCustomer = customerRepository.getById(customerId);
			tempCustomer.setCustomerName(customerName);
			return customerRepository.save(tempCustomer);
		} else {
			log.info("Customer with ID: " + customerId + " doesnt exists.");
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
			tempCustomer.getPersonalDetails().setCustomerDateOfBirth(dob);
			return customerRepository.save(tempCustomer);
		} else {
			log.info("Customer with ID: " + customerId + " doesnt exists.");
			return null;
		}
	}
	
	public void deleteCustomerById(int customerId) {
		if (customerRepository.existsById(customerId)) {
			log.warn("Deleting Customer with ID: " + customerId);
			customerRepository.deleteById(customerId);
		} else {
			log.info("Customer with ID: " + customerId + " doesnt exists.");
			
		}
		
	}
	
	
//	public Profile updateProfileDetails(Profile profile) {
//		log.warn("updating the profile details");
//		if(profileRepository.existsById(profile.getProfileId())) {
//			profile.setNoOfTransaction(profile.getNoOfTransaction());
//			profile.setEmail(profile.getEmail());
//			profile.setPassword(profile.getPassword());
//			profileRepository.save(profile);
//			
//			return profile;
//			}else {
//				System.out.println("Profile with ID" + profile.getProfileId() + "does not exist");
//				return null;
//			}
//		}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Profile profile=profileRepository.findByEmail(username);
//		if(profile==null) {
//			throw new UsernameNotFoundException("Invalid Username or password.");
//					}
//		return new User(profile.getEmail(),profile.getPassword(),null);
//	}

}
