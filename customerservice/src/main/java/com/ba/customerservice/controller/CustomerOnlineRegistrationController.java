package com.ba.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ba.customerservice.service.CustomerServiceOnline;

@Controller
@RequestMapping("/registration")
public class CustomerOnlineRegistrationController {
	
	@Autowired
	private CustomerServiceOnline customerServiceOnline;
	
	@ModelAttribute("userdto")
	public UserDto userDto() {
		return new UserDto();
	}
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@GetMapping(value="/error")
	public String errorPage() {
		return "error";
	}
	
	
	@PostMapping 
	public String customerRegistration(@ModelAttribute("userdto") UserDto userdto,BindingResult bindingResult,RedirectAttributes redirectAttributes){
//		redirectAttributes.addFlashAttribute("message", "Failed");
//	    redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
//	    if (bindingResult.hasErrors()) {
//
//	    	System.out.println(bindingResult);
//	    	return "redirect:/registration";
//	    }
//	    	    
//	    redirectAttributes.addFlashAttribute("message", "Success");
//	    redirectAttributes.addFlashAttribute("alertClass", "alert-success");
//	    
	    
	    if(customerServiceOnline.updateCustomerPassword(userdto.getCustomerId(), userdto.getCustomerEmail(), userdto.getCustomerPassword())==null) {
	    	redirectAttributes.addFlashAttribute("message", "Failed");
		    redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
	    }else{
	    	redirectAttributes.addFlashAttribute("message", "Success");
		    redirectAttributes.addFlashAttribute("alertClass", "alert-success");
	    };
	    
		return "redirect:/registration";
	}
	

}
