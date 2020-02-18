package com.portfolio.assigner.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.portfolio.assigner.data.Customer;
import com.portfolio.assigner.data.CustomerOutput;

/**
 * Service for performing customer operations for the files loaded
 * 
 * @author Ramanuj
 *
 */
public interface PortfolioAssignerUIService {

	public CustomerOutput assignPortfolioToCustomers(MultipartFile[] files);

	public List<Customer> getAllCustomers();
}
