package com.portfolio.assigner.data;

import java.util.List;
import java.util.Map;

/**
 * This will carry the customer data back as the output.
 * 
 * @author Ramanuj
 *
 */
public class CustomerOutput {

	/**
	 * Total number of customer records that were passed to be inserted.
	 */
	private int totalRecords;

	/**
	 * Total number of customer records successfully processed.
	 */
	private int totalRecordsProcessed;

	/**
	 * Error message for the record sequence that could not be inserted.
	 */
	private Map<Integer, String> errorMessageOutput;

	/**
	 * List of customers that were inserted. To be displayed along with their
	 * portfolio.
	 */
	private List<Customer> customers;

	/**
	 * @return the totalRecords
	 */
	public int getTotalRecords() {
		return totalRecords;
	}

	/**
	 * @param totalRecords the totalRecords to set
	 */
	public CustomerOutput setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
		return this;
	}

	/**
	 * @return the totalRecordsProcessed
	 */
	public int getTotalRecordsProcessed() {
		return totalRecordsProcessed;
	}

	/**
	 * @param totalRecordsProcessed the totalRecordsProcessed to set
	 */
	public CustomerOutput setTotalRecordsProcessed(int totalRecordsProcessed) {
		this.totalRecordsProcessed = totalRecordsProcessed;
		return this;
	}

	/**
	 * @return the errorMessageOutput
	 */
	public Map<Integer, String> getErrorMessageOutput() {
		return errorMessageOutput;
	}

	/**
	 * @param errorMessageOutput the errorMessageOutput to set
	 */
	public CustomerOutput setErrorMessageOutput(Map<Integer, String> errorMessageOutput) {
		this.errorMessageOutput = errorMessageOutput;
		return this;
	}

	/**
	 * @return the customers
	 */
	public List<Customer> getCustomers() {
		return customers;
	}

	/**
	 * @param customers the customers to set
	 */
	public CustomerOutput setCustomers(List<Customer> customers) {
		this.customers = customers;
		return this;
	}

}
