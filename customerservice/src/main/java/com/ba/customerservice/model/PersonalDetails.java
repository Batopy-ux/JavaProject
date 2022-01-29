package com.ba.customerservice.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.ba.customerservice.password.ValidPassword;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class PersonalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerPersonalInfoId;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date customerDateOfBirth;
	private int customerAge;
	private String customerGender;
	private String customerReligion;
	
	@NotEmpty(message = "Email cannot be empty")
//	@NotNull
	@Email
	@NotBlank
	@Column(unique=true)
	private String customerEmail;
	
	//if needed for online login
	@ValidPassword
	private String customerPassword;
	
	private String customerOccupation;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address customerOccupationAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address customerPermanentAddress;
	private String customerPAN;

}
