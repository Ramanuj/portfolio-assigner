/**
 * 
 */
package com.portfolio.assigner.data.builder.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.portfolio.assigner.data.Customer;
import com.portfolio.assigner.data.Portfolio;
import com.portfolio.assigner.data.builder.CustomerBuilder;
import com.portfolio.assigner.exceptions.CustomerInformationMissingException;
import com.portfolio.assigner.exceptions.InvalidDateFormatException;
import com.portfolio.assigner.rules.RuleEngine;
import com.portfolio.assigner.rules.impl.PortfolioAllocationRuleEngine;
import com.portfolio.assigner.validator.CustomerRecordValidator;

/**
 * The builder is responsible for creating the Customer object after the information has been 
 * validated and required constraints have been run
 * 
 * @author Ramanuj
 *
 */
public class CustomerBuilderImpl implements CustomerBuilder {

	private static Logger logger = LoggerFactory.getLogger(CustomerBuilderImpl.class);

	private Customer customer;
	private Portfolio portfolio;

	private CustomerRecordValidator validator;
	private RuleEngine engine;

	/**
	 * Initializing the builder to set up customer
	 */
	public CustomerBuilderImpl() {
		logger.info("Initialising the Customer ");
		customer = new Customer();
		validator = new CustomerRecordValidator();
		engine = new PortfolioAllocationRuleEngine();
	}

	/**
	 * Setting the customer age
	 */
	@Override
	public void setCustomerAge() throws InvalidDateFormatException {

		long years;

		try {
			LocalDate end = LocalDate.now();
			years = ChronoUnit.YEARS.between(customer.getDateOfBirth(), end);
			if (years > 100) {
				throw new InvalidDateFormatException("Age of customer is not correct");
			}

			customer.setAge((int) years);
		} catch (Exception e) {
			throw new InvalidDateFormatException("Age of customer is not correct", e);
		}
	}

	/**
	 * get the portfolio based on the rules and assign it to the customer
	 */
	@Override
	public void setCustomerPortfolio() {
		portfolio = engine.executePortfolioAllocationRules(customer.getAge(), customer.getAsset());
		customer.setPortfolio(portfolio);
	}

	/**
	 * Create customer record
	 * 
	 * @throws CustomerInformationMissingException
	 */
	@Override
	public void createCustomer(String firstName, String lastName, String dateOfBirth, String asset)
			throws InvalidDateFormatException, CustomerInformationMissingException {

		String errorMsg = validator.validateAllRequiredInputs(firstName, lastName, dateOfBirth, asset);
		if (errorMsg != null) {
			throw new CustomerInformationMissingException(errorMsg);
		}

		/**
		 * Storing customer info
		 */
		customer.setFirstName(firstName).setLastName(lastName).setDateOfBirth(validator.dateOfBirth(dateOfBirth)).setAsset(validator.asset(asset));
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

}
