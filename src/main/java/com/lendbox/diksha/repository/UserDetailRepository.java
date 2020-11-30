package com.lendbox.diksha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lendbox.diksha.model.UserDetails;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetails, Integer> {

	@Query(value = "SELECT * FROM user_details WHERE email = ?1 AND pass = ?2", nativeQuery = true)
	  UserDetails findByEmailAddress(String email,String pass);
}
