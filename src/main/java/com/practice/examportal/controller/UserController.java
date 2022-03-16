package com.practice.examportal.controller;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.examportal.model.Role;
import com.practice.examportal.model.User;
import com.practice.examportal.model.UserRole;
import com.practice.examportal.service.interfaces.IUserService;
import com.practice.examportal.utility.wsrest.UniversalCustomResponseObject;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private IUserService userService;

//	@Autowired
//	private UniversalCustomResponseObject custUniResObj;

	// Creating user
	@PostMapping("/create")
	public ResponseEntity<UniversalCustomResponseObject> create(@RequestBody User newUser) {

		Role tempRole = new Role();
		tempRole.setId(45L);
		tempRole.setRoleName("USER");

		UserRole userRole = new UserRole();
		userRole.setUsers(newUser);
		userRole.setRoles(tempRole);

		Set<UserRole> roles = new HashSet<UserRole>();
		roles.add(userRole);

		User user = null;
		UniversalCustomResponseObject tempObj = new UniversalCustomResponseObject();
		try {
			user = this.userService.createUser(newUser, roles);

			if (user != null) {

				tempObj.setResponseObject(Optional.of(user));
				tempObj.setMessage(Optional.of("OK"));
				tempObj.setExceptionMessage(null);
				tempObj.setResponseDate(ZonedDateTime.now());

				return ResponseEntity.created(new URI("/")).body(tempObj);

			} else {

				tempObj.setResponseObject(null);
				tempObj.setMessage(Optional.of("KO"));
				tempObj.setExceptionMessage(null);
				tempObj.setResponseDate(ZonedDateTime.now());
				
				return ResponseEntity.badRequest().body(tempObj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tempObj.setResponseObject(null);
			tempObj.setMessage(Optional.of("KO"));
			tempObj.setExceptionMessage(Optional.of(e.getMessage() == null ? e.getClass().getSimpleName() : e.getMessage()));
			tempObj.setResponseDate(ZonedDateTime.now());
			return ResponseEntity.badRequest().body(tempObj);
		}

	}

	@GetMapping("/get/{username}")
	public ResponseEntity<UniversalCustomResponseObject> getUserByUserName(@PathVariable("username") String name) {
		User user = null;
		UniversalCustomResponseObject tempObj = new UniversalCustomResponseObject();
		try {
			user = this.userService.getUser(name);

			if (user != null) {

				tempObj.setResponseObject(Optional.of(user));
				tempObj.setMessage(Optional.of("OK"));
				tempObj.setExceptionMessage(null);
				tempObj.setResponseDate(ZonedDateTime.now());

				return ResponseEntity.created(new URI("/")).body(tempObj);

			} else {

				tempObj.setResponseObject(null);
				tempObj.setMessage(Optional.of("KO"));
				tempObj.setExceptionMessage(null);
				tempObj.setResponseDate(ZonedDateTime.now());
				
				return ResponseEntity.badRequest().body(tempObj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tempObj.setResponseObject(null);
			tempObj.setMessage(Optional.of("KO"));
			tempObj.setExceptionMessage(Optional.of(e.getMessage() == null ? e.getClass().getSimpleName() : e.getMessage()));
			tempObj.setResponseDate(ZonedDateTime.now());
			
			return ResponseEntity.badRequest().body(tempObj);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<UniversalCustomResponseObject> updateUserByOldUser(@RequestBody User oldUser) {
		User user = null;
		UniversalCustomResponseObject tempObj = new UniversalCustomResponseObject();
		try {
			user = this.userService.updateUser(oldUser);

			if (user != null) {

				tempObj.setResponseObject(Optional.of(user));
				tempObj.setMessage(Optional.of("OK"));
				tempObj.setExceptionMessage(null);
				tempObj.setResponseDate(ZonedDateTime.now());

				return ResponseEntity.created(new URI("/")).body(tempObj);

			} else {

				tempObj.setResponseObject(null);
				tempObj.setMessage(Optional.of("KO"));
				tempObj.setExceptionMessage(null);
				tempObj.setResponseDate(ZonedDateTime.now());
				
				return ResponseEntity.badRequest().body(tempObj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tempObj.setResponseObject(null);
			tempObj.setMessage(Optional.of("KO"));
			tempObj.setExceptionMessage(Optional.of(e.getMessage() == null ? e.getClass().getSimpleName() : e.getMessage()));
			tempObj.setResponseDate(ZonedDateTime.now());
			
			return ResponseEntity.badRequest().body(tempObj);
		}
	}

	@DeleteMapping("/delete/{username}")
	public ResponseEntity<UniversalCustomResponseObject> deleteUserByUserName(@PathVariable("username") String name) {
		Integer user = null;
		UniversalCustomResponseObject tempObj = new UniversalCustomResponseObject();
		try {
			user = this.userService.deleteUser(name);

			if (user != null) {

				tempObj.setResponseObject(Optional.of(user));
				tempObj.setMessage(Optional.of("OK"));
				tempObj.setExceptionMessage(null);
				tempObj.setResponseDate(ZonedDateTime.now());

				return ResponseEntity.created(new URI("/")).body(tempObj);

			} else {

				tempObj.setResponseObject(null);
				tempObj.setMessage(Optional.of("KO"));
				tempObj.setExceptionMessage(null);
				tempObj.setResponseDate(ZonedDateTime.now());
				
				return ResponseEntity.badRequest().body(tempObj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tempObj.setResponseObject(null);
			tempObj.setMessage(Optional.of("KO"));
			tempObj.setExceptionMessage(Optional.of(e.getMessage() == null ? e.getClass().getSimpleName() : e.getMessage()));
			tempObj.setResponseDate(ZonedDateTime.now());
			
			return ResponseEntity.badRequest().body(tempObj);
		}
	}

}
