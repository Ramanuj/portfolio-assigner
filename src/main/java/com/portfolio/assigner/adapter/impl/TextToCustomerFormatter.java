package com.portfolio.assigner.adapter.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.portfolio.assigner.adapter.InputFormatter;
import com.portfolio.assigner.common.AppConstants;
import com.portfolio.assigner.data.Customer;
import com.portfolio.assigner.data.CustomerDirector;
import com.portfolio.assigner.exceptions.CustomerInformationMissingException;
import com.portfolio.assigner.exceptions.InvalidDateFormatException;
import com.portfolio.assigner.repository.CustomerRepository;

/**
 * This class will translate the text input and return back the Customer as output
 * 
 * @author Ramanuj
 *
 */
@Component("convertTextToCustomer")
public class TextToCustomerFormatter implements InputFormatter {

	private static Logger logger = LoggerFactory.getLogger(TextToCustomerFormatter.class);
	
	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * The method translates the plain text, processes it and returns exceptions in case there was an error processing the input.
	 */
	@Override
	public Customer formatInput(String text) throws CustomerInformationMissingException, InvalidDateFormatException {
		logger.info("formatting plain text input " + text);

		// Can get the total fields in the input class by reflection and compare with
		// tokens.length, instead of a hard coded constant we can make it dynamic.
		// Avoiding Reflection
		// Field[] fields = CustomerInputData.class.getDeclaredFields();

		String[] tokens = text.split("\\|");
		if (tokens.length != AppConstants.Total_Fields_Input) {
			throw new CustomerInformationMissingException("Invalid number of parameters supplied in the customer record");
		}

		CustomerDirector director = new CustomerDirector();
		director.contructCustomer(tokens[0], tokens[1], tokens[2], tokens[3]);

		Customer customer = director.getCustomer();
		
		customerRepository.save(customer);
		
		return customer;
	}

}
