/**
 * 
 */
package com.portfolio.assigner.adapter;

import com.portfolio.assigner.data.Customer;
import com.portfolio.assigner.exceptions.CustomerInformationMissingException;
import com.portfolio.assigner.exceptions.InvalidDateFormatException;

/**
 * Implementor of this interface will provide mechanisms to format the input
 * data into Customer object
 * 
 * @author Ramanuj
 *
 */
public interface InputFormatter {

	public Customer formatInput(String text) throws CustomerInformationMissingException, InvalidDateFormatException;
}
