package com.ba.customerservice.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class NomineeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nomineeId;
	private String nomineeTitle;
	private String nomineeName;
	private String nomineeRelationship;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date nomineeDateOfBirth;
	private int nomineeAge;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address nomineeAddress;
}
