package com.portfolio.assigner.strategy;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.portfolio.assigner.data.CustomerInputData;
import com.portfolio.assigner.data.CustomerOutput;

/**
 * Pick the best strategy based on the input type. Putting the methods as
 * default to ensure that we do not have to implement them if not needed.
 * 
 * @author Ramanuj
 *
 */
public interface ConvertionStrategy {

	default public CustomerOutput executeStrategy(MultipartFile file) throws IOException {
		return null;
	}

	default public CustomerOutput executeStrategy(List<CustomerInputData> inputList) {
		return null;
	}
}
