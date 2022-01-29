package com.ba.customerservice.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity	
@Table
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID accountId;
	
	@NotEmpty
	@Max(800)
	private double creditScore;
	
	@NotEmpty
	private double accountBal;
	
}
