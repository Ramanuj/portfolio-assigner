package com.portfolio.assigner.strategy.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.portfolio.assigner.adapter.InputFormatter;
import com.portfolio.assigner.data.Customer;
import com.portfolio.assigner.data.CustomerInputData;
import com.portfolio.assigner.data.CustomerOutput;
import com.portfolio.assigner.strategy.ConvertionStrategy;

@Component("jsonConverstionStrategyImpl")
public class JsonConverstionStrategyImpl implements ConvertionStrategy {

	private static Logger logger = LoggerFactory.getLogger(JsonConverstionStrategyImpl.class);

	/*
	 * Text to Customer Formatter
	 */
	@Autowired
	@Qualifier("convertTextToCustomer")
	InputFormatter convertTextToCustomer;

	@Override
	public CustomerOutput executeStrategy(List<CustomerInputData> inputList) {
		logger.info("Executing conversion strategy for json conversion");

		CustomerOutput output = new CustomerOutput();

		List<Customer> customersListToBeAdded = new ArrayList<Customer>();

		int recordSequence = 0;
		int recordsProcessed = 0;

		Map<Integer, String> errorMessageOutput = new HashMap<Integer, String>();

		for (CustomerInputData customerInputData : inputList) {
			recordSequence++;
			try {
				customersListToBeAdded.add(convertTextToCustomer.formatInput(customerInputData.toString()));
				recordsProcessed++;
			} catch (Exception e) {
				logger.error("\t Record Sequence : " + recordSequence + " not processed, reason : " + e.getMessage());
				errorMessageOutput.put(recordSequence, e.getMessage());
			}
		}

		// setting the customer data and processing details to the output
		output.setCustomers(customersListToBeAdded).setTotalRecords(recordSequence)
				.setTotalRecordsProcessed(recordsProcessed).setErrorMessageOutput(errorMessageOutput);

		logger.info("Total Records " + recordSequence + " and total records processed " + recordsProcessed);

		return output;
	}

}
