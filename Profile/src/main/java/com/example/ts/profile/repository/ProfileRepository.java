package com.example.ts.profile.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ts.profile.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

	public Optional<Profile> findById(Integer id);
	public boolean existsById(Integer id);
	public boolean existsByEmail(String email);
	
}