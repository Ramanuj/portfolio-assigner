package com.portfolio.assigner.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.assigner.controller.PortfolioAssignerController;
import com.portfolio.assigner.data.Customer;
import com.portfolio.assigner.data.CustomerInputData;
import com.portfolio.assigner.data.CustomerOutput;
import com.portfolio.assigner.service.PortfolioAssignerAPIService;

/**
 * This controller will handle all the requests for portfolio assignment and
 * customer information display
 * 
 * @author Ramanuj
 *
 */
@RestController
@RequestMapping("api")
public class PortfolioAssignerAPIController implements PortfolioAssignerController {

	private static Logger logger = LoggerFactory.getLogger(PortfolioAssignerAPIController.class);

	@Autowired
	@Qualifier("portfolioAssignerAPIServiceImpl")
	private PortfolioAssignerAPIService service;
	
	@Override
	public List<Customer> getAllCustomers() {
		logger.info("Getting all customers from the system");
		return null;
	}

	@PostMapping(path = "addCusomers", consumes = "application/json")
	public CustomerOutput addCustomers(@RequestBody List<CustomerInputData> customers) {
		logger.info("I am adding customers : " + customers.size());

		CustomerOutput output = service.assignPortfolioToCustomers(customers);
		
		return output;
	}

}
