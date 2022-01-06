package com.ba.customerservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="countries")
@Entity
public class Country {
	@Id
//	@GeneratedValue
	@Column(name="countryId")
	private int countryId;
	
	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="stateId")
	private State countryState;
	
}
