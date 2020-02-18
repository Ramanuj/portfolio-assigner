/**
 * 
 */
package com.portfolio.assigner.exceptions;

/**
 * Exception in case the date format of the input is inlviad
 * 
 * @author Ramanuj
 *
 */
public class InvalidDateFormatException extends Exception {

	private static final long serialVersionUID = -3303140394530385882L;

	public InvalidDateFormatException(String errorMessage) {
		super(errorMessage);
	}

	public InvalidDateFormatException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
