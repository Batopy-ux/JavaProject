package com.ba.customerservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="addresses")
@Entity
public class Address {
	@Id
//	@GeneratedValue
	@Column(name="addressId")
	private int addressId;
	
	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="countryId",referencedColumnName = "aId")
	private Country addressCountry;
	
}
