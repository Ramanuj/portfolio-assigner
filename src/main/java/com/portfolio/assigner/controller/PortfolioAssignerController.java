package com.portfolio.assigner.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portfolio.assigner.data.Customer;

/**
 * This interafce should be implemented by all the controllers. All common methods should go here
 * 
 * @author Ramanuj
 *
 */
@RequestMapping("portfolioassigner")
public interface PortfolioAssignerController {

	/**
	 * This method will send a list of all customers in the system
	 * 
	 * @return
	 */
	@GetMapping("getcustomers")
	public List<Customer> getAllCustomers();

}
