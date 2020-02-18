/**
 * 
 */
package com.portfolio.assigner.exceptions;

/**
 * Exception in case there is any required customer information missing
 * 
 * @author Ramanuj
 *
 */
public class CustomerInformationMissingException extends Exception {

	private static final long serialVersionUID = -3303140394530385882L;

	public CustomerInformationMissingException(String errorMessage) {
		super(errorMessage);
	}

	public CustomerInformationMissingException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
