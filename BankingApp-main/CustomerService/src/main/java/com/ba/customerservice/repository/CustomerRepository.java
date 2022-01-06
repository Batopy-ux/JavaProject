package com.ba.customerservice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ba.customerservice.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findBycustomerNameIgnoreCase(String customerName);
	
	public List<Customer> findBycustomerGenderIgnoreCase(String customerGender);
	
	public List<Customer> findBycustomerDateOfBirth(Date customerDateofBirth);
}
