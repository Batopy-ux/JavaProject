package com.ba.customerservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="cities")
@Entity
public class City {
	@Id
//	@GeneratedValue
	@Column(name="cityId")
	private int cityId;
	private String cityName;
	private Integer cityPincode;
	

}
