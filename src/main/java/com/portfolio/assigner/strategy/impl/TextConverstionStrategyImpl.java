/**
 * 
 */
package com.portfolio.assigner.strategy.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.portfolio.assigner.adapter.InputFormatter;
import com.portfolio.assigner.data.Customer;
import com.portfolio.assigner.data.CustomerOutput;
import com.portfolio.assigner.strategy.ConvertionStrategy;

/**
 * Strategy to parse the file passed and convert it to CustomerOutput.
 * 
 * @author Ramanuj
 *
 */
@Component("textConverstionStrategyImpl")
public class TextConverstionStrategyImpl implements ConvertionStrategy {

	private static Logger logger = LoggerFactory.getLogger(TextConverstionStrategyImpl.class);

	/*
	 * Text to Customer Formatter
	 */
	@Autowired
	@Qualifier("convertTextToCustomer")
	InputFormatter convertTextToCustomer;

	@Override
	public CustomerOutput executeStrategy(MultipartFile file) throws IOException {
		logger.info("Executing conversion strategy for text conversion");

		CustomerOutput output = new CustomerOutput();

		List<Customer> customersListToBeAdded = new ArrayList<Customer>();

		Map<Integer, String> errorMessageOutput = new HashMap<Integer, String>();

		String line;

		int recordSequence = 0;
		int recordsProcessed = 0;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

			while ((line = br.readLine()) != null) {
				logger.info("processing the text " + line);
				recordSequence++;

				try {
					customersListToBeAdded.add(convertTextToCustomer.formatInput(line));
					recordsProcessed++;
				} catch (Exception e) {
					logger.error("\t Record Sequence : " + recordSequence + " not processed, reason : " + e.getMessage());
					errorMessageOutput.put(recordSequence, e.getMessage());
				}
			}
		} catch (Exception e) {
			throw new IOException("There was an error reading the file");
		}

		// setting the customer data and processing details to the output
		output.setCustomers(customersListToBeAdded).setTotalRecords(recordSequence).setTotalRecordsProcessed(recordsProcessed)
				.setErrorMessageOutput(errorMessageOutput);

		logger.info("Total Records " + recordSequence + " and total records processed " + recordsProcessed);

		return output;
	}

}
