/**
 * 
 */
package com.portfolio.assigner.service.impl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.assigner.common.InputType;
import com.portfolio.assigner.data.Customer;
import com.portfolio.assigner.data.CustomerInputData;
import com.portfolio.assigner.data.CustomerOutput;
import com.portfolio.assigner.repository.CustomerRepository;
import com.portfolio.assigner.service.PortfolioAssignerAPIService;
import com.portfolio.assigner.strategy.impl.Context;

/**
 * This class will handle the customer-portfolio operations for requests from the API.
 * 
 * @author Ramanuj
 *
 */
@Service("portfolioAssignerAPIServiceImpl")
public class PortfolioAssignerAPIServiceImpl implements PortfolioAssignerAPIService {

	private static Logger logger = LoggerFactory.getLogger(PortfolioAssignerAPIServiceImpl.class);

	/**
	 * To execute the required strategy
	 */
	@Autowired
	private Context context;
	
	/**
	 * Repository to manage database operations of the customers
	 */
	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * Assign portfolio of the list of customers and return the processed result
	 */
	@Override
	public CustomerOutput assignPortfolioToCustomers(List<CustomerInputData> customers) {

		CustomerOutput processedCustomersData = null;

		try {
			processedCustomersData = context.getConvertedCustomers(InputType.JSON, null, customers);
		} catch (IOException e) {
			logger.error("There was an error processing the customer records");
		}

		return processedCustomersData;
	}
	
	/**
	 * Get list of all customers from the repository
	 */
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}

}
