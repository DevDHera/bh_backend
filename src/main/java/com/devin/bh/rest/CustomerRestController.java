package com.devin.bh.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devin.bh.entity.Customer;
import com.devin.bh.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// Autowire the CustomerService
	@Autowired
	private CustomerService customerService;
	
	// Add Mapping for GET /customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	// Add mapping for GET /customers/{customerId}
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer theCustomer = customerService.getCustomer(customerId);
		
		if(theCustomer == null) {
			throw new CustomerNotFoundException("Customer Id Not Found - " + customerId);
		}
		
		return theCustomer;
	}
	
	// Add mapping for POST /customers -  add new customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	// Add mapping for PUT /customers - update an existing customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	// Add mapping for DELETE /customers/{customerId} - delete an existing customer
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer tempCustomer = customerService.getCustomer(customerId);
		
		if(tempCustomer == null) {
			throw new CustomerNotFoundException("Customer Id Not Found - " + customerId );
		}
		
		customerService.deleteCustomer(customerId);
		
		return "Deleted Customer Id - " + customerId;
	}
}
