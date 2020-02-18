package com.portfolio.assigner.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.portfolio.assigner.common.InputType;
import com.portfolio.assigner.data.Customer;
import com.portfolio.assigner.data.CustomerOutput;
import com.portfolio.assigner.exceptions.InValidFileException;
import com.portfolio.assigner.exceptions.UnsupportedContentTypeException;
import com.portfolio.assigner.repository.CustomerRepository;
import com.portfolio.assigner.service.PortfolioAssignerUIService;
import com.portfolio.assigner.strategy.impl.Context;
import com.portfolio.assigner.util.FileOperationsUtil;

/**
 * This class will handle the customer-portfolio operations for requests from the UI(thymeleaf).
 * 
 * @author Ramanuj
 *
 */
@Service("portfolioAssignerUIServiceImpl")
public class PortfolioAssignerUIServiceImpl implements PortfolioAssignerUIService {

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
	 * Assign portfolio to the list of customers in the files passed and return the processed result
	 */
	@Override
	public CustomerOutput assignPortfolioToCustomers(MultipartFile[] files) {

		CustomerOutput customers = null;

		for (MultipartFile file : files) {
			try {
				Optional<InputType> inputType = FileOperationsUtil.getFileInputType(file);
				if (inputType.isPresent()) {
					customers = context.getConvertedCustomers(inputType.get(), file, null);
				}
			} catch (UnsupportedContentTypeException | InValidFileException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return customers;
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
