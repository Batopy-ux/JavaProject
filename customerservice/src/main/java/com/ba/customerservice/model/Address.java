package com.ba.customerservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Address {
	
	@Id
	@GeneratedValue
	@Column(name="addressId")
	private int addressId;
	private Boolean isPermanent;
	private String addressLine1;
	private String addressLine2;
	private String countryCode;
	private String stateCode;
	private String cityCode;
	private long pincode;
	

}
