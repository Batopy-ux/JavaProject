package com.example.ts.profile.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.ts.profile.password.ValidPassword;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int profileId;
	
	@NotEmpty(message = "Email cannot be empty")
	@NotNull
	@Email
	@NotBlank
	@Column(unique=true)
	private String email;
	
	@ValidPassword
	private String password;
	
	private int noOfTransaction;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="account_id", referencedColumnName = "accountId" )
	private Account account;
	
}
