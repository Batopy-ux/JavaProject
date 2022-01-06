package com.example.ts.profile.model;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Table(name = "customers")
@Entity

public class Customer {
	@Id
	@GeneratedValue//(strategy = GenerationType.IDENTITY)
	@Column(name = "customerId")
	private int customerId;
	private String customerName;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date customerDateOfBirth;
	private String customerGender;
	private int customerAge;

	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="addressId")
	private Address customerAddress;

}
