package com.example.ts.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ts.profile.model.Profile;
import com.example.ts.profile.service.ProfileService;   


@Controller
@RequestMapping("/registration")
public class ProfileRegistrationController {
	
	@Autowired
	private ProfileService profileService;
	
	
	@ModelAttribute("profiledto")
	public ProfileDto profiledto() {
		return new ProfileDto();
	}
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@GetMapping(value="/error")
	public String errorPage() {
		return "error";
	}
	
	
	/**
	 * Method to add new profile to database
	 * @param profile
	 * @return Profile
	 */
	@PostMapping 
	public String profileRegistration(@ModelAttribute("profiledto") ProfileDto profiledto,BindingResult bindingResult,RedirectAttributes redirectAttributes){
		redirectAttributes.addFlashAttribute("message", "Failed");
	    redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
	    if (bindingResult.hasErrors()) {

	    	System.out.println(bindingResult);
	    	return "redirect:/registration";
	    }
	    redirectAttributes.addFlashAttribute("message", "Success");
	    redirectAttributes.addFlashAttribute("alertClass", "alert-success");
	    
	    
		Profile newProfile=new Profile(0,null,null,0,null);
		newProfile.setEmail(profiledto.getEmail());
		newProfile.setPassword(profiledto.getPassword());
		profileService.addProfile(newProfile);
		return "redirect:/registration";
	}

}
