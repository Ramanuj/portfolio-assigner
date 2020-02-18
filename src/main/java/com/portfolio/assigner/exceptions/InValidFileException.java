/**
 * 
 */
package com.portfolio.assigner.exceptions;

/**
 * Exception in case the file passed for processing is invalid
 * 
 * @author Ramanuj
 *
 */
public class InValidFileException extends Exception {

	private static final long serialVersionUID = -3303140394530385882L;

	public InValidFileException(String errorMessage) {
		super(errorMessage);
	}

	public InValidFileException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
