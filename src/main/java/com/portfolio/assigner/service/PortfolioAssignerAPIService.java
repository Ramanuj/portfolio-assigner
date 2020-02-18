/**
 * 
 */
package com.portfolio.assigner.service;

import java.util.List;

import com.portfolio.assigner.data.Customer;
import com.portfolio.assigner.data.CustomerInputData;
import com.portfolio.assigner.data.CustomerOutput;

/**
 * Service for performing customer operations for the calling api
 * 
 * @author Ramanuj
 *
 */
public interface PortfolioAssignerAPIService {

	public CustomerOutput assignPortfolioToCustomers(List<CustomerInputData> customers);

	public List<Customer> getAllCustomers();
}
