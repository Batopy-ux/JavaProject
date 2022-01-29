package com.ba.customerservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@GetMapping("/")
	public String home() {
		return "<h1>Home</h1>";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "<h1>admin</h1>";
	}
	
	@GetMapping("/user")
	public String user() {
		return "<h1>User</h1>";
	}
	
	@GetMapping("/test")
	public String test() {
		return "<h1>test</h1>";
	}
}
