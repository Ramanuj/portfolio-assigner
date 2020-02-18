/**
 * 
 */
package com.portfolio.assigner.data.builder;

import com.portfolio.assigner.exceptions.CustomerInformationMissingException;
import com.portfolio.assigner.exceptions.InvalidDateFormatException;

/**
 * Creating the Customer object
 * 
 * @author Ramanuj
 *
 */
public interface CustomerBuilder {

	/**
	 * Create the customer with the required parameters after validating the required input
	 * 
	 * @param firstName
	 * @param lastName
	 * @param dateOfBirth
	 * @param asset
	 * @throws InvalidDateFormatException
	 * @throws CustomerInformationMissingException
	 */
	public void createCustomer(String firstName, String lastName, String dateOfBirth, String asset)
			throws InvalidDateFormatException, CustomerInformationMissingException;

	/**
	 * validating and setting the customer age
	 * 
	 * @throws InvalidDateFormatException
	 */
	void setCustomerAge() throws InvalidDateFormatException;

	/**
	 * Setting the customer portfolio after running the business rules
	 */
	void setCustomerPortfolio();

}
