/**
 * 
 */
package com.portfolio.assigner.data;

import com.portfolio.assigner.data.builder.impl.CustomerBuilderImpl;
import com.portfolio.assigner.exceptions.CustomerInformationMissingException;
import com.portfolio.assigner.exceptions.InvalidDateFormatException;

/**
 * Director to call the builder and create the customer object
 * 
 * @author Ramanuj
 *
 */
public class CustomerDirector {

	/**
	 * Builder for creating the customer object
	 */
	private CustomerBuilderImpl builder;

	public CustomerDirector() {
		builder = new CustomerBuilderImpl();
	}

	/**
	 * Construct the builder object
	 * 
	 * @param firstName
	 * @param lastName
	 * @param dateOfBirth
	 * @param asset
	 * @throws InvalidDateFormatException
	 * @throws CustomerInformationMissingException
	 */
	public void contructCustomer(String firstName, String lastName, String dateOfBirth, String asset)
			throws InvalidDateFormatException, CustomerInformationMissingException {
		builder.createCustomer(firstName, lastName, dateOfBirth, asset);
		builder.setCustomerAge();
		builder.setCustomerPortfolio();
	}

	/**
	 * Get the Customer from the builder
	 * 
	 * @return Customer
	 */
	public Customer getCustomer() {
		return builder.getCustomer();
	}

}
