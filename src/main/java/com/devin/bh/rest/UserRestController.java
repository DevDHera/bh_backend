package com.devin.bh.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devin.bh.entity.Authorities;
import com.devin.bh.entity.Customer;
import com.devin.bh.entity.User;
import com.devin.bh.entity.UserDetails;
import com.devin.bh.service.CustomerService;
import com.devin.bh.service.UserService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/api")
public class UserRestController {

	// Autowire the CustomerService
	@Autowired
	private UserService userService;
	
	// Add Mapping for GET /customers
	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	// Add mapping for GET /customers/{customerId}
	@GetMapping("/users/{userName}")
	public User getUser(@PathVariable String userName) {
		User theUser = userService.getUser(userName);
		
//		if(theUser == null) {
//			throw new CustomerNotFoundException("User Not Found - " + userName);
//		}
		
		return theUser;
	}
	
	// Add mapping for POST /customers -  add new customer
	@PostMapping("/users")
	public UserDetails addUser(@RequestBody ObjectNode json) {
		
		// Set User Object
		User theUser = new User();
		theUser.setUsername(json.get("username").asText());
		
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		theUser.setPassword(encoder.encode(json.get("password").asText()));
		
		theUser.setEnabled(1);
		
		// Set Authority Object
		Authorities theAutority = new Authorities("ROLE_CUSTOMER");
		
		// Set User Details Object
		UserDetails theUserDetail = new UserDetails();
		theUserDetail.setId(0);
		theUserDetail.setFirst_name(json.get("first_name").asText());
		theUserDetail.setLast_name(json.get("last_name").asText());
		
		
		userService.saveUser(theUser, theAutority, theUserDetail);
		
		return theUserDetail;
	}
	
	// Add mapping for PUT /customers - update an existing customer
	@PutMapping("/users")
	public UserDetails updateUser(@RequestBody ObjectNode json) {
		
		// Set User Object
		User theUser = new User();
		theUser.setUsername(json.get("username").asText());
		
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		theUser.setPassword(encoder.encode(json.get("password").asText()));
		
		theUser.setEnabled(1);
		
		// Set Authority Object
		Authorities theAutority = new Authorities("ROLE_CUSTOMER");
		
		// Set User Details Object
		UserDetails theUserDetail = new UserDetails();
		theUserDetail.setId(0);
		theUserDetail.setFirst_name(json.get("first_name").asText());
		theUserDetail.setLast_name(json.get("last_name").asText());
		
		
		userService.saveUser(theUser, theAutority, theUserDetail);
		
		
		return theUserDetail;
	}
	
	// Add mapping for DELETE /customers/{customerId} - delete an existing customer
	@DeleteMapping("/users/{username}")
	public String deleteUser(@PathVariable String userName) {
		
		User tempUser = userService.getUser(userName);
		
//		if(tempUser == null) {
//			throw new CustomerNotFoundException("Customer Id Not Found - " + userName );
//		}
		
		userService.deleteUser(userName);
		
		return "Deleted User - " + userName;
	}
}
