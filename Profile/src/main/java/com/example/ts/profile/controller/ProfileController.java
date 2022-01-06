package com.example.ts.profile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ts.profile.model.Profile;
import com.example.ts.profile.service.ProfileService;

/**
 * Controller for Profile
 * @author prath
 *
 */
@RestController
@RequestMapping(value = "/profiles")

public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
	/**
	 * Method to add new profile to database
	 * @param profile
	 * @return Profile
	 */
	@PostMapping 
	public ResponseEntity<Profile> addNewProfile(@RequestBody Profile profile){
		return ResponseEntity.ok(profileService.addProfile(profile));
	}
	
	@GetMapping
	public ResponseEntity<List<Profile>> getProfiles(){
		return ResponseEntity.ok(profileService.getProfiles());
	}
	
//	/**
//	 * Method to find profile by email and password in database
//	 * @param email
//	 * @param password
//	 * @return Profile
//	 */
//	@GetMapping(value = "/signin")
//	public ResponseEntity<Profile> getProfile(@RequestBody String email, String password){
//		return ResponseEntity.ok(profileService.getProfile(email, password));
//	}
//	
	/**
	 * Method to delete a profile from database
	 * @param id
	 */
	@DeleteMapping
	public void deleteProfile(@RequestBody int id) {
		profileService.deleteProfile(id);
	}

	/**
	 * Method to update profile details (account balance, credit score, Number of transactions, email and password)
	 * @param profile
	 * @return Profile
	 */
	@PutMapping
	public ResponseEntity<Profile> updateProfileDetails(@RequestBody Profile profile){
		return ResponseEntity.ok(profileService.updateProfileDetails(profile));
	}


}