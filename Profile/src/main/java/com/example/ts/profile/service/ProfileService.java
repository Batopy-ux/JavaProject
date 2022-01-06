package com.example.ts.profile.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ts.profile.model.Profile;
import com.example.ts.profile.repository.ProfileRepository;

@Service
public class ProfileService {
	
	Logger log = LoggerFactory.getLogger(ProfileService.class);

	@Autowired
	ProfileRepository profileRepository;
	
	public Profile addProfile(Profile profile) {
		log.info("Adding new Profile");
		return profileRepository.save(profile);
	}
	
	public void deleteProfile(Integer profileId) {
		if(profileRepository.existsById(profileId))
		{
			log.warn("Deleting the Profile");
			profileRepository.deleteById(profileId);}
		else {
			System.out.println("Profile with ID" + profileId + "does not exist");
			
		}
		
	}
	
	public List<Profile> getProfiles(){
		log.info("Getting all profiles");
		return profileRepository.findAll();
	}
	
	
	public Optional<Profile> findProfileById(Integer i){
		log.info("Finding profile by ID");
		return profileRepository.findById(i);
	}
	
	
	public Profile updateProfileDetails(Profile profile) {
		log.warn("updating the profile details");
		if(profileRepository.existsById(profile.getProfileId())) {
			profile.setNoOfTransaction(profile.getNoOfTransaction());
			profile.setEmail(profile.getEmail());
			profile.setPassword(profile.getPassword());
			profileRepository.save(profile);
			
			return profile;
			}else {
				System.out.println("Profile with ID" + profile.getProfileId() + "does not exist");
				return null;
			}
		}
}
	

