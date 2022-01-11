package com.ba.customerservice.controller;

import lombok.Data;

@Data
public class UserDto {
	private int customerId;
	private String customerEmail;
	private String customerPassword;
}
