package com.ba.customerservice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ba.customerservice.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findBycustomerNameIgnoreCase(String customerName);

	@Query(value="select * from CUSTOMER inner join PERSONAL_DETAILS on PERSONAL_DETAILS_CUSTOMER_PERSONAL_INFO_ID=CUSTOMER_PERSONAL_INFO_ID where CUSTOMER_GENDER =:customerGender", nativeQuery=true)
	public List<Customer> findByCustomersGenderIgnoreCase(String customerGender);
	
	@Query(value="select * from CUSTOMER inner join PERSONAL_DETAILS on PERSONAL_DETAILS_CUSTOMER_PERSONAL_INFO_ID=CUSTOMER_PERSONAL_INFO_ID where CUSTOMER_DATE_OF_BIRTH =:customerDateOfBirth", nativeQuery=true)
	public List<Customer> findByCustomersDateOfBirth(Date customerDateOfBirth);

}
