package com.example.ts.profile.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="states")
@Entity
public class State {
	@Id
//	@GeneratedValue
	@Column(name="stateId")
	private int stateId;
	
	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="cityId",referencedColumnName = "sId")
	private City stateCity;
	
	
//	public int getsId() {
//		return sId;
//	}
//	public void setsId(int sId) {
//		this.sId = sId;
//	}
//	public City getsCity() {
//		return sCity;
//	}
//	public void setsCity(City sCity) {
//		this.sCity = sCity;
//	}
//	
	
}
