package com.practice.examportal.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.examportal.model.Role;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	
	

}
