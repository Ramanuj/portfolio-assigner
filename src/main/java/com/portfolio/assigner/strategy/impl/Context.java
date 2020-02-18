package com.portfolio.assigner.strategy.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.portfolio.assigner.common.InputType;
import com.portfolio.assigner.data.CustomerInputData;
import com.portfolio.assigner.data.CustomerOutput;
import com.portfolio.assigner.strategy.ConvertionStrategy;

/**
 * Selecting the best Strategy to be used based on the input type.
 * 
 * @author Ramanuj
 *
 */
@Component
public class Context {

	private static Logger logger = LoggerFactory.getLogger(Context.class);

	/**
	 * Strategy for converting CSV to CustomerOutput
	 */
	@Autowired
	@Qualifier("csvConverstionStrategyImpl")
	private ConvertionStrategy csvConverstionStrategyImpl;

	/**
	 * Strategy for converting Text to CustomerOutput
	 */
	@Autowired
	@Qualifier("textConverstionStrategyImpl")
	private ConvertionStrategy textConverstionStrategyImpl;

	/**
	 * Strategy for converting json to CustomerOutput
	 */
	@Autowired
	@Qualifier("jsonConverstionStrategyImpl")
	private ConvertionStrategy jsonConverstionStrategyImpl;

	/**
	 * Selects the correct execution strategy for the input type passed.
	 * 
	 * @param inputType
	 * @param file
	 * @param inputList
	 * @return CustomerOutput
	 * @throws IOException
	 */
	public CustomerOutput getConvertedCustomers(InputType inputType, MultipartFile file, List<CustomerInputData> inputList) throws IOException {
		logger.info("Getting Convereted Customers for input tpye " + inputType.toString());

		CustomerOutput customers = null;

		switch (inputType) {
		case CSV:
			customers = csvConverstionStrategyImpl.executeStrategy(file);
			break;
		case TXT:
			customers = textConverstionStrategyImpl.executeStrategy(file);
			break;
		case JSON:
			customers = jsonConverstionStrategyImpl.executeStrategy(inputList);
			break;
		default:
			// not supported
			customers = new CustomerOutput();
			Map<Integer, String> errorMessage = new HashMap<Integer, String>() {
				{
					put(0, String.format("Input type %s not supported", inputType));
				}
			};

			customers.setErrorMessageOutput(errorMessage);
			break;
		}

		logger.info("Customer Output successfully returned");
		return customers;
	}

}
