/**
 * 
 */
package com.portfolio.assigner.adapter.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.portfolio.assigner.adapter.InputFormatter;
import com.portfolio.assigner.common.AppConstants;
import com.portfolio.assigner.data.Customer;
import com.portfolio.assigner.data.CustomerDirector;
import com.portfolio.assigner.exceptions.CustomerInformationMissingException;
import com.portfolio.assigner.exceptions.InvalidDateFormatException;

/**
 * This class will translate the csv input and return back the Customer as output
 * 
 * @author Ramanuj
 *
 */
@Component("convertCsvToCustomer")
public class CsvToCustomerFormatter implements InputFormatter {

	private static Logger logger = LoggerFactory.getLogger(CsvToCustomerFormatter.class);

	/**
	 * The method translates the csv, processes it and returns exceptions in case there was an error processing the input.
	 * 
	 * @throws CustomerInformationMissingException
	 * @throws InvalidDateFormatException
	 */
	@Override
	public Customer formatInput(String text) throws CustomerInformationMissingException, InvalidDateFormatException {
		logger.info("formatting csv text input");

		String[] tokens = text.split(",");
		if (tokens.length != AppConstants.Total_Fields_Input) {
			throw new CustomerInformationMissingException("Invalid number of parameters supplied in the customer record");
		}

		CustomerDirector director = new CustomerDirector();
		director.contructCustomer(tokens[0], tokens[1], tokens[2], tokens[3]);

		Customer customer = director.getCustomer();
		return customer;
	}

}
